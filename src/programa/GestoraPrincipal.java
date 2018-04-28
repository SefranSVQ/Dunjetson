package programa;

import java.io.BufferedReader;
import java.io.File;
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
		
		//Variables
		int opcionMenuPrincipal = 0;
		char confirmacionJugador = ' ';
		char confirmacionGuardado = ' ';
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Clip sonido = null;
		int espacioGuardado = 0;
		
		//Jugadores
		Jugador jugador = new Jugador();
		String nombre = " ";
		String clase = " ";
		
		
		//Inicio
		
		//reproducimos la musica
		try {
			sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(new File("src/sonidos/intro.wav")));
		} catch (LineUnavailableException e) {} catch (IOException e) {} 
		catch (UnsupportedAudioFileException e) {}
		sonido.start();
		sonido.loop(100);
		
		System.out.println("   ");
		
		//paramos el tiempo 2 segundos
		
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
						
						// PintarDatosGuardadoYObtenerYValidarEspacioGuardado
						
						do {
							
							System.out.println("Selecciona donde quieres guardar los datos: ");
							System.out.println("0 - Salir sin guardar");
							System.out.println("1 - ");
							System.out.println("2 - ");
							System.out.println("3 - ");
							System.out.println("4 - ");
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						
						//confirmacionEspacioGuardado
						if (espacioGuardado != 0) {
							
							do {
								System.out.println("¿Seguro que quieres guardarlo en la posición "+espacioGuardado+"? "
										+ "Los cambios no se podrán deshacer. (S/N)");
								confirmacionGuardado = Character.toUpperCase(sc.next().charAt(0));
							}
							while (confirmacionGuardado != 'S' && confirmacionGuardado != 'N');
								
							if (confirmacionGuardado == 'S') {
								
								//crearJugadorEnEspacioSeleccionado
								switch (clase) {
									case "guerrero": 
										try {
											jugador.setNick(nombre);
											jugador.setClase(Clase.GUERRERO);
											jugador.setPoder(5);
											jugador.setInteligencia(3);
											jugador.setAgilidad(3);
											jugador.setOro(10);
											jugador.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
									
									case "mago":
										try {
											jugador.setNick(nombre);
											jugador.setClase(Clase.MAGO);
											jugador.setPoder(3);
											jugador.setInteligencia(5);
											jugador.setAgilidad(3);
											jugador.setOro(10);
											jugador.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
										
									case "ladron": 
										try {
											jugador.setNick(nombre);
											jugador.setClase(Clase.LADRON);
											jugador.setPoder(3);
											jugador.setInteligencia(3);
											jugador.setAgilidad(5);
											jugador.setOro(10);
											jugador.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
									
									case "comerciante": 
										try {
											jugador.setNick(nombre);
											jugador.setClase(Clase.COMERCIANTE);
											jugador.setPoder(3);
											jugador.setInteligencia(3);
											jugador.setAgilidad(3);
											jugador.setOro(20);
											jugador.setMazmorrasCompletadas(0);
										} catch (ExcepcionJugador e) {}
									break;
								}
								
								//falta guardar el jugador en el espacio correspondiente
								System.out.println("Jugador no guardado en fichero, valores seleccionados: \n"
										+ jugador.toString());
							}
						}
						
						
					break;
					
					case 2:
						//cargarPartida
						System.out.println("Opcion en construccion");
					break;
					
					case 3:
						//borrarPartida
						System.out.println("Opcion en construccion");
					break;
					
					case 4:
						//copiarPartida
						System.out.println("Opcion en construccion");
					break;
				
				}
				
			}
			
			
			if (opcionMenuPrincipal == 1 || opcionMenuPrincipal == 2 && espacioGuardado!= 0) {
				
				sonido.stop();
				
				//iniciarPartida
				System.out.println("Inicio de partida en construcción.");

			}
			
		}
		while (opcionMenuPrincipal != 0);
		
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
