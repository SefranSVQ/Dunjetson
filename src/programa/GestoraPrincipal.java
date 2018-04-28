package programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import clases.Clase;
import clases.Jugador;
import excepciones.ExcepcionJugador;

public class GestoraPrincipal {

	/*
	 * iniciarJuego
	 * 
	 * Este método inicia al juego.
	 * Precondiciones: no hay
	 * E: no hay
	 * S: no hay
	 * E/S: no hay
	 * Postcondiciones: el juego se habrá ejecutado.
	 * 	
	 * 
	 */
	
	public void iniciarJuego() {
		
		//Variables de menus
		int opcionMenuPrincipal = 0;
		char confirmacionJugador = 'S';
		char confirmacionGuardado = 'S';
		char confirmacionBorrado = 'S';
		char confirmacionSobreescritura = 'S';
		int espacioGuardado = 0;
		int espacioSobreescrito = 0 ;
		
		//Objetos IO
		Scanner sc = new Scanner(System.in);
		File save = new File("src/archivos/save.txt");
		Clip sonido = null;
		//Si es la primera vez que se ejecuta, creamos el fichero save.txt
		// con los valores por defecto.
		if (!save.exists()) {
			GestoraFichero.reiniciarPartidas();
		}
		
		//Variables de jugadores
		Jugador jugadorActual = new Jugador();
		String nombre = " ";
		String clase = " ";
		String[] partidas = new String[5];
		GestoraFichero.guardarPartidasEnArray(partidas);
		
		//Inicio
		
			//Preparativos pre-juego
		
		
		//reproducimos la musica
		try {
			sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(new File("src/archivos/intro.wav")));
		} catch (LineUnavailableException e) {} catch (IOException e) {} 
		catch (UnsupportedAudioFileException e) {}
		sonido.start();
		sonido.loop(100);
		 
		//Inicio
		
		//paramos el tiempo 2 segundos y pintamos titulo
		System.out.println("   ");
		UtilJuego.pararTiempo(2000); 
		pintarTitulo();

		sc.nextLine();
		
		UtilJuego.limpiarPantalla(15);
		
		do {
			
			do {
				//si anteriormente se jugó, reiniciamos la canción.
				if (opcionMenuPrincipal == 1 || opcionMenuPrincipal == 2 && espacioGuardado != 0) {
					sonido.setMicrosecondPosition(0);
					sonido.start();
					sonido.loop(100);
				}
				
				pintarMenuPrincipal();
				UtilJuego.limpiarPantalla(10);
				
				try {
					
					opcionMenuPrincipal = Integer.parseInt(sc.nextLine());
				}
				catch (Exception e) { opcionMenuPrincipal = -1; }
				
			}
			while (opcionMenuPrincipal < 0 || opcionMenuPrincipal > 4);
			
			if (opcionMenuPrincipal != 0) {
				
				switch (opcionMenuPrincipal) {
				
					case 1:
						//nuevaPartida
					
						System.out.println("Bienvenido a Dunjetson. Estás a punto de descubrir\n"
								+ "una gran gran aventura llena de retos. ¿estás preparado? \n \n"
								+ "Pulsa intro para continuar.\n");
						
						sc.nextLine();
						
						UtilJuego.limpiarPantalla(50);
						
						System.out.println("Una gran montaña ha surgido de la nada en medio de \" El río Grande \".\n"
								+ "Muchos aventureros han decidido buscar fortuna en ella, pero tú sientes\n"
								+ "que allí hay algo más que tesoros. \n\n"
								+ "Pulsa intro para continuar.");
						
						sc.nextLine();
						
						System.out.println("\nPero antes de seguir con todo este rollo, dime, \n");

						do {
							
							do {
								
								System.out.println("¿Cómo te llamas? (Máximo 10 caracteres)");
								nombre = sc.nextLine();
							
							}
							while(nombre.length() > 10 || nombre.length() == 0);
							
							do {
								
								System.out.println("¿Y qué tipo de aventurero eres?\n"
										+ "(guerrero / mago / ladron / comerciante)");
								clase = sc.nextLine();
							
							}
							while(!clase.equals("guerrero") && !clase.equals("mago") && !clase.equals("ladron") && !clase.equals("comerciante"));
							
							do {
								System.out.println("Entonces te llamas "+nombre+" y eres un " + clase + "? (S/N) \n"
										+ "Nota: si no quieres crear un nuevo personaje, pon 'S' y luego podrás deshacerlo.");

								confirmacionJugador =  Character.toUpperCase(sc.nextLine().charAt(0));
								
							}
							while (confirmacionJugador != 'N' && confirmacionJugador != 'S');
							
							
						}
						while (confirmacionJugador == 'N');
						
						
						do {
							
							//Nos aseguramos de que las partidas están actualizadas en el array
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige espacio donde guardar: \n");
							
							//y aquí las mostramos por pantalla.
							GestoraFichero.pintarPartidasGuardadas(partidas);
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						if (espacioGuardado != 0) {
							
							do {
								System.out.println("¿Seguro que quieres guardarlo en la posición "+espacioGuardado+"? "
										+ "Los cambios no se podrán deshacer. (S/N)");
								confirmacionGuardado = Character.toUpperCase(sc.next().charAt(0));
							}
							while (confirmacionGuardado != 'S' && confirmacionGuardado != 'N');
								
							if (confirmacionGuardado == 'S') {
								
								switch (clase) {
									case "guerrero": 
										try {
											jugadorActual.setNick(nombre);
											jugadorActual.setClase(Clase.GUERRERO);
											jugadorActual.setPoder(5);
											jugadorActual.setInteligencia(3);
											jugadorActual.setAgilidad(3);
											jugadorActual.setOro(10);
											jugadorActual.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
									
									case "mago":
										try {
											jugadorActual.setNick(nombre);
											jugadorActual.setClase(Clase.MAGO);
											jugadorActual.setPoder(3);
											jugadorActual.setInteligencia(5);
											jugadorActual.setAgilidad(3);
											jugadorActual.setOro(10);
											jugadorActual.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
										
									case "ladron": 
										try {
											jugadorActual.setNick(nombre);
											jugadorActual.setClase(Clase.LADRON);
											jugadorActual.setPoder(3);
											jugadorActual.setInteligencia(3);
											jugadorActual.setAgilidad(5);
											jugadorActual.setOro(10);
											jugadorActual.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
									
									case "comerciante": 
										try {
											jugadorActual.setNick(nombre);
											jugadorActual.setClase(Clase.COMERCIANTE);
											jugadorActual.setPoder(3);
											jugadorActual.setInteligencia(3);
											jugadorActual.setAgilidad(3);
											jugadorActual.setOro(20);
											jugadorActual.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
								}
								
								GestoraFichero.guardarJugadorEnPosicion(jugadorActual, espacioGuardado);
							}
						}
						
						
					break;
					
					case 2:
						
						//Cargar partida
						
						do {
							
							//Nos aseguramos de que las partidas están actualizadas en el array
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige partida a cargar: \n");
							
							//y aquí las mostramos por pantalla.
							GestoraFichero.pintarPartidasGuardadas(partidas);
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						if (espacioGuardado != 0) {
							
							//cargarJugador
							GestoraFichero.cargarJugador(espacioGuardado);
						}
						
					break;
					
					case 3: //borrar partida

						do {
							
							//Nos aseguramos de que las partidas están actualizadas en el array
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige partida a borrar: \n");
							
							//y aquí las mostramos por pantalla.
							GestoraFichero.pintarPartidasGuardadas(partidas);
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						if (espacioGuardado != 0) {
							
							do {
								//borrar jugador
								System.out.println("Estás seguro de querer borrar a este jugador? \n"
										+ "Los cambios serán irreversibles. (S/N)");
								
								confirmacionBorrado = Character.toUpperCase(sc.nextLine().charAt(0));
							}
							while (confirmacionBorrado != 'S' && confirmacionBorrado != 'N');
							
							if (confirmacionBorrado == 'S') {

								jugadorActual.reiniciarJugador();

								GestoraFichero.guardarJugadorEnPosicion(jugadorActual, espacioGuardado);
								
							}
						}
						
					break;
					
					case 4: //copiarPartida
						
						do {
							
							//Nos aseguramos de que las partidas están actualizadas en el array
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige partida a copiar: \n");
							
							//y aquí las mostramos por pantalla.
							GestoraFichero.pintarPartidasGuardadas(partidas);
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						if (espacioGuardado != 0) {
							
							do {
								
								//Nos aseguramos de que las partidas están actualizadas en el array
								GestoraFichero.guardarPartidasEnArray(partidas);
								
								System.out.println("Elige partida a sobreescribir: \n");
								
								//y aquí las mostramos por pantalla.
								GestoraFichero.pintarPartidasGuardadas(partidas);
								
								try {
									espacioSobreescrito = Integer.parseInt(sc.nextLine());
								}
								catch (Exception e) {espacioSobreescrito = -1;}
								
							}
							while (espacioSobreescrito < 0 || espacioSobreescrito > 4);
						
							if (espacioSobreescrito != 0) {
								
								if (espacioSobreescrito == espacioGuardado) {
									System.out.println("Has elegido la misma ranura. No se hará nada.");
								}
								else {
									do {
										
										System.out.println("Estás seguro de copiar la partida "+espacioGuardado+"\n"
												+ "encima de la partida "+espacioSobreescrito+"? el cambio será irreversible. (S/N)");
										
										confirmacionSobreescritura = Character.toUpperCase(sc.nextLine().charAt(0));
										
									}
									while (confirmacionSobreescritura != 'S' && confirmacionSobreescritura != 'N');
									
									if (confirmacionSobreescritura == 'S') {
										
										GestoraFichero.sobreescribirPartida(espacioGuardado, espacioSobreescrito);
										
									}
								}
							}
						}
						
					break;
				
				}
				
			}
			
			
			// Si se ha elegido iniciar partida ->
			if ((opcionMenuPrincipal == 1 && espacioGuardado!= 0 && confirmacionGuardado == 'S')
				|| (opcionMenuPrincipal == 2 && espacioGuardado!= 0 )){
				
				sonido.stop();
				
				//iniciarPartida
				System.out.println("Inicio de partida en construcción.");

			}
			
		}
		while (opcionMenuPrincipal != 0);
		
		sc.close();
		sonido.stop();
		
	}
	
	/*
	 * pintarMenuPrincipal
	 * 
	 * pinta el menú principal del juego por pantalla.
	 * sin entradas / salidas.
	 * postcondicion: se habrá pintado por pantalla el menú principal.
	 */
	
	public void pintarMenuPrincipal() {
		
		UtilJuego.limpiarPantalla(10);
		
		System.out.println("       _    .  ,   .           .");  
		System.out.println("   *  / \\_ *  / \\_      _  *        *   /\\'__        *"); 
		System.out.println("     /    \\  /    \\,   ((        .    _/  /  \\  *'.");
		System.out.println(" .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.");
		System.out.println("   /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *"); 
		System.out.println("  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\ ");	
		System.out.println(" /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-");	
		System.out.println("/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._");	

		System.out.println("\n\n");
		System.out.println("\t ----- Elige una opcion -----");
		System.out.println("\t 0 - Salir. ");
		System.out.println("\t 1 - Nueva Partida. ");
		System.out.println("\t 2 - Cargar Partida. ");
		System.out.println("\t 3 - Borrar Partida. ");
		System.out.println("\t 4 - Copiar partida. ");
		System.out.println("\t ----- ---- ------ ---- -----");
		
	}
	
	/*
	 * 
	 * pintarTitulo
	 * 
	 * pinta el título del juego por pantalla
	 * sin entradas / salidas.
	 * postcondicion: se habrá pintado por pantalla el título.
	 * 
	 */
	
	public void pintarTitulo() {
		
		System.out.println("||====     ||    ||  |\\\\    ||  =======||  ||=======  ========   ========     =====     |\\\\    ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||    \\\\   ||    ||  ||\\\\   ||         ||  ||            ||      //         //     \\\\   ||\\\\   ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||     ||  ||    ||  || \\\\  ||         ||  ||===         ||     //         ||       ||  || \\\\  ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||     ||  ||    ||  ||  \\\\ ||         ||  ||===         ||     \\\\=====\\\\  ||       ||  ||  \\\\ ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||    //   \\\\    //  ||   \\\\||  \\\\    //   ||            ||            //   \\\\     //   ||   \\\\||"); UtilJuego.pararTiempo(333); 
		System.out.println("||====       ====    ||    \\\\|   =====     ||=======     ||     ======//      =====     ||    \\\\|"); UtilJuego.pararTiempo(333); 
		
		System.out.println("\n\n                             Pulsa \"Intro\" para jugar");
		
	}
	
}
