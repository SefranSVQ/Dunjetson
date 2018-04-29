package programa;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.Clip;

import clases.Clase;
import clases.Jugador;

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
		char opcionMenuJuego = ' ';
		char confirmacionJugador = 'S';
		char confirmacionGuardado = 'S';
		char confirmacionBorrado = 'S';
		char confirmacionSobreescritura = 'S';
		int espacioGuardado = 0;
		int espacioSobreescrito = 0 ;
		
		//Objetos IO
		Scanner sc = new Scanner(System.in);
		File save = new File("src/archivos/save.txt");
		Clip musicaIntro = null;
		Clip musicaJuego = null;
		
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
			
			//Preparativos pre-juego
		
		
		//reproducimos la musica
		
		 
		//Inicio
		
		musicaIntro = GestoraMusica.iniciarMusicaPrincipal();
		UtilJuego.pararTiempo(2000); 
		pintarTitulo();

		sc.nextLine();
		
		UtilJuego.limpiarPantalla(15);
		
		do {
			
			do {
				//si anteriormente se jugó, reiniciamos la canción.
				if (opcionMenuPrincipal == 1 || opcionMenuPrincipal == 2 && espacioGuardado != 0) {
					GestoraMusica.reiniciarMusicaPrincipal(musicaIntro);
				}
				
				pintarMenuPrincipal();
				UtilJuego.limpiarPantalla(5);
				
				try {
					
					opcionMenuPrincipal = Integer.parseInt(sc.nextLine());
				}
				catch (Exception e) { opcionMenuPrincipal = -1; }
				
			}
			while (opcionMenuPrincipal < 0 || opcionMenuPrincipal > 4);
			
			if (opcionMenuPrincipal != 0) {
				
				switch (opcionMenuPrincipal) {
				
					case 1: //nuevaPartida
						
						UtilJuego.limpiarPantalla(20);
						
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
							
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige espacio donde guardar: \n");
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
								confirmacionGuardado = Character.toUpperCase(sc.nextLine().charAt(0));
							}
							while (confirmacionGuardado != 'S' && confirmacionGuardado != 'N');
								
							if (confirmacionGuardado == 'S') {
								
								jugadorActual.iniciarEstadisticas(nombre, clase);
								
								GestoraFichero.guardarJugadorEnPosicion(jugadorActual, espacioGuardado);
								
							}
						}
						
						
					break;
					
					case 2: //Cargar partida
						
						do {
							
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige partida a cargar: \n");
							GestoraFichero.pintarPartidasGuardadas(partidas);
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						if (espacioGuardado != 0) {
							
							jugadorActual = GestoraFichero.cargarJugador(espacioGuardado);
							
							if (jugadorActual.getClase() == Clase.NINGUNA) {
								
								System.out.println("Esa partida no tiene ningún jugador asignado.");
								
								espacioGuardado = 0;
								
							}
						}
						
					break;
					
					case 3: //borrar partida

						do {
							
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige partida a borrar: \n");
							GestoraFichero.pintarPartidasGuardadas(partidas);
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						if (espacioGuardado != 0) {
							
							do {
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
							
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige partida a copiar: \n");
							GestoraFichero.pintarPartidasGuardadas(partidas);
							
							try {
								espacioGuardado = Integer.parseInt(sc.nextLine());
							}
							catch (Exception e) {espacioGuardado = -1;}
							
						}
						while (espacioGuardado < 0 || espacioGuardado > 4);
						
						if (espacioGuardado != 0) {
							
							do {
								
								GestoraFichero.guardarPartidasEnArray(partidas);
								
								System.out.println("Elige partida a sobreescribir: \n");
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
			
			
			// Si se ha elegido jugar ->
			if ((opcionMenuPrincipal == 1 && espacioGuardado!= 0 && confirmacionGuardado == 'S')
				|| (opcionMenuPrincipal == 2 && espacioGuardado!= 0 )){
				
				musicaIntro.stop();
				
				// Iniciamos la cancion del juego.
				musicaJuego = GestoraMusica.iniciarMusicaJuego();
				
				do {
					do {
						
						UtilJuego.limpiarPantalla(10);
						pintarMenuJuego();
						opcionMenuJuego = Character.toUpperCase(sc.nextLine().charAt(0));
						
					}
					while (opcionMenuJuego != 'S' && opcionMenuJuego != 'E' && opcionMenuJuego != 'T' && opcionMenuJuego != '0' &&
							opcionMenuJuego != '1' && opcionMenuJuego != '2' && opcionMenuJuego != '3' && opcionMenuJuego != '4' &&
							opcionMenuJuego != '5' && opcionMenuJuego != '6' && opcionMenuJuego != '7' && opcionMenuJuego != '8' &&
							opcionMenuJuego != '9' );
					
					if (opcionMenuJuego != 'S') {
						
						switch (opcionMenuJuego) {
						
							case 'E':
								
								UtilJuego.limpiarPantalla(10);
								jugadorActual.pintarEstadisticas();
								
							break;
							
							case 'T':
							
								System.out.println("En construccion.");
								
							break;
							
							case '0':
								
								System.out.println("En construccion.");
								
							break;
								
							case '1':
								
								System.out.println("En construccion.");
								
							break;
								
							case '2':
								
								System.out.println("En construccion.");
								
							break;
								
							case '3':
								
								System.out.println("En construccion.");
								
							break;
								
							case '4':
								
								System.out.println("En construccion.");
								
							break;
								
							case '5':
								
								System.out.println("En construccion.");
								
							break;
								
							case '6':
								
								System.out.println("En construccion.");
								
							break;
								
							case '7':
								
								System.out.println("En construccion.");
								
							break;
							
							case '8':
								
								System.out.println("En construccion.");
								
							break;
								
							case '9':
								
								System.out.println("En construccion.");
								
							break;
						
						
						}
						
					}
				}
				while (opcionMenuJuego != 'S');
				
				musicaJuego.stop();
				
			}
			
		}
		while (opcionMenuPrincipal != 0);
		
		sc.close();
		musicaIntro.close();
		
	}
	
	
	/*
	 * pintarMenuJuego
	 * 
	 * este método pinta por pantalla el menú de juego.
	 * sin entradas / salidas.
	 * postcondicion: se habrá pintado por pantalla el menú de juego.
	 * 
	 */
	
	private void pintarMenuJuego() {
		
		System.out.println("\t ---- Elige tu opción ----");
		System.out.println("\t S - Salir");
		System.out.println("\t E - Mostrar Estadisticas.");
		System.out.println("\t T - Ir a la tienda.");
		System.out.println("\t 0 - Jugar tutorial.");
		System.out.println("\t 1 - Mazmorra 1");
		System.out.println("\t 2 - Mazmorra 2");
		System.out.println("\t 3 - Mazmorra 3");
		System.out.println("\t 4 - Mazmorra 4");
		System.out.println("\t 5 - Mazmorra 5");
		System.out.println("\t 6 - Mazmorra 7");
		System.out.println("\t 7 - Mazmorra 7");
		System.out.println("\t 8 - Mazmorra 8");
		System.out.println("\t 9 - Mazmorra 9");
		System.out.println("\t---- ---- ---- ---- ----");
		
		
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
		
		System.out.println(" ");
		System.out.println("||====     ||    ||  |\\\\    ||  =======||  ||=======  ========   ========     =====     |\\\\    ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||    \\\\   ||    ||  ||\\\\   ||         ||  ||            ||      //         //     \\\\   ||\\\\   ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||     ||  ||    ||  || \\\\  ||         ||  ||===         ||     //         ||       ||  || \\\\  ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||     ||  ||    ||  ||  \\\\ ||         ||  ||===         ||     \\\\=====\\\\  ||       ||  ||  \\\\ ||"); UtilJuego.pararTiempo(333); 
		System.out.println("||    //   \\\\    //  ||   \\\\||  \\\\    //   ||            ||            //   \\\\     //   ||   \\\\||"); UtilJuego.pararTiempo(333); 
		System.out.println("||====       ====    ||    \\\\|   =====     ||=======     ||     ======//      =====     ||    \\\\|"); UtilJuego.pararTiempo(333); 
		
		System.out.println("\n\n                             Pulsa \"Intro\" para jugar");
		
	}
	
}
