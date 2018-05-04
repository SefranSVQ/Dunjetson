package programa;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.Clip;

import clases.*;
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
		int opcionMenuJuego = 0;
		int opcionTienda = 0;
		int opcionMazmorra = 0;
		int opcionSala = 0;
		char confirmacionJugador = ' ';
		char confirmacionGuardado = ' ';
		char confirmacionBorrado = ' ';
		char confirmacionSobreescritura = ' ';
		char confirmacionTienda = ' ';
		int espacioGuardado = 0;
		int espacioSobreescrito = 0 ;
		
		//Objetos.
		GestoraCombate gc = new GestoraCombate();
		Scanner sc = new Scanner(System.in);
		File save = new File("src/archivos/save.txt");
		Clip musicaIntro = null;
		Clip musicaJuego = null;
		Random rng = new Random();
		
		//Si es la primera vez que se ejecuta, creamos el fichero save.txt
		// con los valores por defecto.
		if (!save.exists()) {
			GestoraFichero.reiniciarPartidas();
		}
		
		//Variables de jugadores
		Jugador jugadorActual = new Jugador();
		Jefe jefeActual = new Jefe();
		String nombre = " ";
		String clase = " ";
		String[] partidas = new String[5];
		GestoraFichero.guardarPartidasEnArray(partidas);
		int victoria = 0;
		boolean jugadorVivo = true;
		int siguienteEvento = 0;
		int recompensaOro = 0;
		int recompensaEstadistica = 0;
		int salaPintada = 0;
			
		// Mazmorras
			
			/* 
			 * Notas:
			 * Los jefes siempre están en la posición 0 de eventos.
			 * 
			 */
		
		Mazmorra[] mazmorras = new Mazmorra[10];
		
		mazmorras[0] = new Mazmorra("Ciudad de inicio", 3, new Evento[]{
				new Jefe("Runner",2,1,1,2),
				new Monstruo("Paloma", 2),
				new Puzzle("Puzzle de 2 piezas", 2),
				new Trampa("Cáscara de plátano", 2)
				}	
		);
		
		mazmorras[1] = new Mazmorra("Era Prehistorica", 10, new Evento[]{
				new Jefe("T-Rex",15,20,12,16),
				new Monstruo("Bearusaurus", 6),
				new Monstruo("Triceraptor", 5),
				new Monstruo("Diplodocus", 4),
				new Puzzle("Pintada en pared", 5),
				new Puzzle("Pintada en pared", 5),
				new Trampa("Planta carnívora gigante", 5),
				new Trampa("Liana atrapa-humanos", 6)
				}	
		);
		
		mazmorras[2] = new Mazmorra("Barco Pirata", 15, new Evento[]{
				new Jefe("Capitán",40,42,58,48),
				new Monstruo("Bucanero", 32),
				new Puzzle("Cofre Maldito", 31),
				new Puzzle("Mapa del tesoro", 31),
				new Trampa("Red para peces", 30)
				}	
		);
		
		mazmorras[3] = new Mazmorra("Antiguo Egipto", 23, new Evento[]{
				new Jefe("Faraon",186,201,212,152),
				new Monstruo("Momia", 135),
				new Puzzle("Jeroglífico", 140),
				new Puzzle("Jeroglífico", 140),
				new Trampa("Tormenta de arena", 128)
				}	
		);
		
		mazmorras[4] = new Mazmorra("Ciudad de inicio", 3, new Evento[]{
				new Jefe("Runner",2,1,1,2),
				new Monstruo("Paloma", 2),
				new Puzzle("Puzzle de 2 piezas", 2),
				new Trampa("Cáscara de plátano", 2)
				}	
		);
		
		mazmorras[5] = new Mazmorra("Ciudad de inicio", 3, new Evento[]{
				new Jefe("Runner",2,1,1,2),
				new Monstruo("Paloma", 2),
				new Puzzle("Puzzle de 2 piezas", 2),
				new Trampa("Cáscara de plátano", 2)
				}	
		);
		
		mazmorras[6] = new Mazmorra("Ciudad de inicio", 3, new Evento[]{
				new Jefe("Runner",2,1,1,2),
				new Monstruo("Paloma", 2),
				new Puzzle("Puzzle de 2 piezas", 2),
				new Trampa("Cáscara de plátano", 2)
				}	
		);
		
		mazmorras[7] = new Mazmorra("Ciudad de inicio", 3, new Evento[]{
				new Jefe("Runner",2,1,1,2),
				new Monstruo("Paloma", 2),
				new Puzzle("Puzzle de 2 piezas", 2),
				new Trampa("Cáscara de plátano", 2)
				}	
		);
		
		mazmorras[8] = new Mazmorra("Ciudad de inicio", 3, new Evento[]{
				new Jefe("Runner",2,1,1,2),
				new Monstruo("Paloma", 2),
				new Puzzle("Puzzle de 2 piezas", 2),
				new Trampa("Cáscara de plátano", 2)
				}	
		);
		
		mazmorras[9] = new Mazmorra("Ciudad de inicio", 3, new Evento[]{
				new Jefe("Runner",2,1,1,2),
				new Monstruo("Paloma", 2),
				new Puzzle("Puzzle de 2 piezas", 2),
				new Trampa("Cáscara de plátano", 2)
				}	
		);
		 
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

						do {
							
							do {
								
								System.out.println("¿Cómo te llamas? (Máximo 10 caracteres)");
								try {
									nombre = sc.nextLine();
								}
								catch (Exception e) {nombre = "aaaaaaaaaaaaaaaa";}
							}
							while(nombre.length() > 10 || nombre.length() == 0);
							
							do {
								
								System.out.println("¿Y qué tipo de aventurero eres?\n"
										+ "(guerrero / mago / ladron / comerciante)");
								try {
									clase = sc.nextLine();
								}
								catch (Exception e) {clase = "-1";}
							
							}
							while(!clase.equals("guerrero") && !clase.equals("mago") && !clase.equals("ladron") && !clase.equals("comerciante"));
							
							do {
								System.out.println("Entonces te llamas "+nombre+" y eres un " + clase + "? (S/N) \n"
										+ "Nota: si no quieres crear un nuevo personaje, pon 'S' y luego podrás deshacerlo.");
								try {
									confirmacionJugador =  Character.toUpperCase(sc.nextLine().charAt(0));
								}
								catch (Exception e) { confirmacionJugador = 'm';}
								
							}
							while (confirmacionJugador != 'N' && confirmacionJugador != 'S');
							
							
						}
						while (confirmacionJugador == 'N');
						
						
						do {
							
							GestoraFichero.guardarPartidasEnArray(partidas);
							
							System.out.println("Elige espacio donde guardar: \n");
							GestoraFichero.pintarPartidasGuardadas();
							
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
								try {
									confirmacionGuardado = Character.toUpperCase(sc.nextLine().charAt(0));
								}
								catch (Exception e) {confirmacionGuardado = 'A';}
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
							GestoraFichero.pintarPartidasGuardadas();
							
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
							GestoraFichero.pintarPartidasGuardadas();
							
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
								try {
									confirmacionBorrado = Character.toUpperCase(sc.nextLine().charAt(0));
								}
								catch (Exception e) {confirmacionBorrado = 'A';}
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
							GestoraFichero.pintarPartidasGuardadas();
							
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
								GestoraFichero.pintarPartidasGuardadas();
								
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
										try {
											confirmacionSobreescritura = Character.toUpperCase(sc.nextLine().charAt(0));
										}
										catch (Exception e) {confirmacionSobreescritura = 'A';}
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
						try {
							opcionMenuJuego = Integer.parseInt((sc.nextLine()));
						}
						catch (Exception e) { opcionMenuJuego = -1; }
						
					}
					while (opcionMenuJuego < 0 || opcionMenuJuego > 3);
					
					if (opcionMenuJuego != 0) {
						
						switch (opcionMenuJuego) {
								
							case 1: // Mostrar estadisticas del jugador
								
								UtilJuego.limpiarPantalla(10);
								jugadorActual.pintarEstadisticas();
								
								System.out.println("Pulsa intro para continuar.");
								sc.nextLine();
								
							break;
								
							case 2: // Tienda
								do {
									do {
										
										pintarMenuTienda();
										
										try {
											opcionTienda = Integer.parseInt(sc.nextLine());
										}
										catch (Exception e) { opcionTienda = -1; }
										
									}
									while (opcionTienda < 0 || opcionTienda > 3);
									
									if (opcionTienda != 0) {
										
										do {
											
											pintarConfirmacionTienda(jugadorActual, opcionTienda);
											
											try {
												confirmacionTienda = Character.toUpperCase(sc.nextLine().charAt(0));
											}
											catch (Exception e) {confirmacionTienda = 'A';}
										}
										while (confirmacionTienda != 'S' && confirmacionTienda != 'N');
										
										if (confirmacionTienda == 'S') {
											switch (jugadorActual.getClase()) {
											
												case GUERRERO:
													switch(opcionTienda) {
														case 1: 
															jugadorActual.modificarFuerza((int)jugadorActual.getOro()/5*2); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 2: 
															jugadorActual.modificarInteligencia((int)jugadorActual.getOro()/5); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 3: 
															jugadorActual.modificarAgilidad((int)jugadorActual.getOro()/5); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
													}
												break;
												
												case MAGO:
													switch(opcionTienda) {
														case 1: 
															jugadorActual.modificarFuerza((int)jugadorActual.getOro()/5); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 2: 
															jugadorActual.modificarInteligencia((int)jugadorActual.getOro()/5*2); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 3: 
															jugadorActual.modificarAgilidad((int)jugadorActual.getOro()/5); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
													}
												break;
													
												case LADRON:
													switch(opcionTienda) {
														case 1: 
															jugadorActual.modificarFuerza((int)jugadorActual.getOro()/5); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 2: 
															jugadorActual.modificarInteligencia((int)jugadorActual.getOro()/5); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 3: 
															jugadorActual.modificarAgilidad((int)jugadorActual.getOro()/5*2); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
													}
												break;
													
												case COMERCIANTE:
													switch(opcionTienda) {
														case 1: 
															jugadorActual.modificarFuerza((int)jugadorActual.getOro()/3); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 2: 
															jugadorActual.modificarInteligencia((int)jugadorActual.getOro()/3); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
														case 3: 
															jugadorActual.modificarAgilidad((int)jugadorActual.getOro()/3); 
															try {jugadorActual.setOro(0); } catch (ExcepcionJugador e) {}
														break;
													}
												break;
												
												default: break;
											}
											UtilJuego.limpiarPantalla(10);
											jugadorActual.pintarEstadisticas();
											GestoraFichero.guardarJugadorEnPosicion(jugadorActual, espacioGuardado);
										}
									}
								}
								while(opcionTienda != 0);
							break;
								
							case 3: // Menu de Mazmorras
								
								do {
									do {
										
										pintarMenuMazmorras();
										try {
											opcionMazmorra = Integer.parseInt(sc.nextLine());
										}
										catch (Exception e) { opcionMazmorra = -2; }
										
									}
									while (opcionMazmorra < -1 || opcionMazmorra > 9);
									
									if (opcionMazmorra != 0) {
										switch (opcionMazmorra) {
											case -1:  //Tutorial
												
												System.out.println("En Dunjetson tendrás que enfrentarte a distintos eventos.\n"
														+ "Estos eventos pueden ser de distintos tipos (Monstruos, Puzzles, Trampas y Jefe). \n"
														+ "Vamos a enfrentarnos a los evento de "+mazmorras[0].getNombre()+" para que puedas familiarizarte.");
												
												System.out.println("Los monstruos son tipos fuertes. Para enfrentarte a ellos tendrás\n"
														+ "que usar la fuerza bruta.");
												
												//MonstruoTutorial
												gc.pintarEnfrentamiento(jugadorActual, mazmorras[0].getEventos()[1], 1);
												victoria = gc.calcularVictoria(jugadorActual, mazmorras[0].getEventos()[1], 1, 'n');
												gc.pintarResultadoCombate(victoria);
												
												System.out.println("Los puzzles son acertijos que debes completar, tendrás que\n"
														+ "enfrentarte a ellos con la inteligencia. ");
												
												//PuzzleTutorial
												gc.pintarEnfrentamiento(jugadorActual, mazmorras[0].getEventos()[2], 1);
												victoria = gc.calcularVictoria(jugadorActual, mazmorras[0].getEventos()[2], 1, 'n');
												gc.pintarResultadoCombate(victoria);
												
												System.out.println("Las trampas son obstáculos que te encontrarás por tu camino.\n"
														+ "tu agilidad para esquivarlos es todo lo que necesitas. ");
												
												//TrampaTutorial
												gc.pintarEnfrentamiento(jugadorActual, mazmorras[0].getEventos()[3], 1);
												victoria = gc.calcularVictoria(jugadorActual, mazmorras[0].getEventos()[3], 1, 'n');
												gc.pintarResultadoCombate(victoria);
												
												System.out.println("Por último, los jefes son guerreros fuertes, inteligentes y\n"
														+ "ágiles, por lo que tendrás que darlo todo contra ellos. Además, \n"
														+ "en las peores circunstancias, cuando se sientan acorralados, serán más fuertes.");
												
												//JefeTutorial
												gc.pintarEnfrentamiento(jugadorActual, mazmorras[0].getEventos()[0], 1);
												
												System.out.println("El jefe golpea con fuerza...");
												victoria = gc.calcularVictoria(jugadorActual, mazmorras[0].getEventos()[0], 1, 'f');
												gc.pintarResultadoCombateJefe(victoria,1);
												
												System.out.println("Buscas su punto débil...");
												victoria = gc.calcularVictoria(jugadorActual, mazmorras[0].getEventos()[0], 1, 'i');
												gc.pintarResultadoCombateJefe(victoria,2);
												
												System.out.println("!!! Intentas esquivar un golpe inesperado !!!");
												victoria = gc.calcularVictoria(jugadorActual, mazmorras[0].getEventos()[0], 1, 'a');
												gc.pintarResultadoCombateJefe(victoria,3);
												
												System.out.println("El jefe combate con todas sus fuerzas y...");
												victoria = gc.calcularVictoria(jugadorActual, mazmorras[0].getEventos()[0], 1, 'd');
												gc.pintarResultadoCombateJefe(victoria,4);
												
												
												System.out.println("Tutorial completado. Ahora puedes acceder a la mazmorra 1!");
												System.out.println("\nPulsa intro para continuar.");
												sc.nextLine();
												try {
													jugadorActual.setMazmorrasCompletadas(1);
												} catch (ExcepcionJugador e) {}
												
											break;
											default: // jugarMazmorraSeleccionada

												if (opcionMazmorra <= jugadorActual.getMazmorrasCompletadas()) {
												
													UtilJuego.limpiarPantalla(5);
													System.out.println("Comenzando mazmorra: "+mazmorras[opcionMazmorra].getNombre());
													jugadorVivo = true;
													
													for (int i = 0 ; i < mazmorras[opcionMazmorra].getTotalNiveles() && jugadorVivo ; i++) {
														
														UtilJuego.limpiarPantalla(3);
														System.out.println("Nivel "+(i+1)+"/"+mazmorras[opcionMazmorra].getTotalNiveles());
														
														if (i < mazmorras[opcionMazmorra].getTotalNiveles()-1) {
															
															// Evento aleatorio
															siguienteEvento = rng.nextInt(mazmorras[opcionMazmorra].getEventos().length-1);
															
															gc.pintarEnfrentamiento(jugadorActual, mazmorras[opcionMazmorra].getEventos()[siguienteEvento+1], i);
															victoria = gc.calcularVictoria(jugadorActual, mazmorras[opcionMazmorra].getEventos()[siguienteEvento+1], i, 'n');
															gc.pintarResultadoCombate(victoria);
															
															if (victoria == -1) { // -1 => jugador derrotado.
																jugadorVivo = false;
																System.out.println("Has sido derrotado. Hazte más fuerte "
																		+ "en la tienda mágica para avanzar más lejos.");
															}
															else { 
																
																recompensaOro = mazmorras[opcionMazmorra].getEventos()[siguienteEvento+1].calcularRecompensa(i+1);
																
																if (jugadorActual.getClase() == Clase.COMERCIANTE) recompensaOro = (int) (recompensaOro*1.5);
																System.out.println("Has ganado "+recompensaOro+" de oro");
																
																try {
																	jugadorActual.modificarOro(recompensaOro);
																} catch (ExcepcionJugador e) {}
																
																recompensaEstadistica = mazmorras[opcionMazmorra].getEventos()[siguienteEvento+1].calcularRecompensa(i);
																
																if (mazmorras[opcionMazmorra].getEventos()[siguienteEvento+1] instanceof Monstruo) {
																	if (jugadorActual.getClase() == Clase.GUERRERO) recompensaEstadistica = recompensaEstadistica*2;
																	System.out.println("Has ganado "+recompensaEstadistica+" en fuerza.");
																	jugadorActual.modificarFuerza(recompensaEstadistica);
																}
																else if (mazmorras[opcionMazmorra].getEventos()[siguienteEvento+1] instanceof Puzzle) {
																	if (jugadorActual.getClase() == Clase.MAGO) recompensaEstadistica = recompensaEstadistica*2;
																	System.out.println("Has ganado "+recompensaEstadistica+" en inteligencia.");
																	jugadorActual.modificarInteligencia(recompensaEstadistica);
																}
																else {
																	if (jugadorActual.getClase() == Clase.LADRON) recompensaEstadistica = recompensaEstadistica*2;
																	System.out.println("Has ganado "+recompensaEstadistica+" en agilidad.");
																	jugadorActual.modificarAgilidad(recompensaEstadistica);
																}
																
																System.out.println("Pulsa intro para continuar.");
																sc.nextLine();
																
																salaPintada = rng.nextInt(4)+1; 
																
																//PintarSalaYObtenerYValidarOpcionSala
																do {
																	
																	pintarSala(salaPintada);
																	pintarOpcionesSala(salaPintada);
																	
																	try {
																		opcionSala = Integer.parseInt(sc.nextLine());
																	}
																	catch (Exception e) { opcionSala = -1; }
																	if ((salaPintada >= 1 && salaPintada <=3) && (opcionSala < 1 || opcionSala > 2)
																			|| (salaPintada == 4 && (opcionSala < 1 || opcionSala > 3))) {
																		System.out.println(jugadorActual.getNick()+", quieres comerte una pared, verdad? :)");
																	}
																		
																	
																}
																while ((salaPintada >= 1 && salaPintada <=3) && (opcionSala < 1 || opcionSala > 2)
																		|| (salaPintada == 4 && (opcionSala < 1 || opcionSala > 3)));
																
															}
															
														}	
														else {	//Jefe de mazmorra
															
															gc.pintarEnfrentamiento(jugadorActual, mazmorras[opcionMazmorra].getEventos()[0], i);
															
															System.out.println("El jefe golpea con fuerza...");
															victoria = gc.calcularVictoria(jugadorActual, mazmorras[opcionMazmorra].getEventos()[0], 1, 'f');
															gc.pintarResultadoCombateJefe(victoria,1);
															
															if (victoria == -1) jugadorVivo = false;
															
															if (jugadorVivo) {
																System.out.println("Buscas su punto débil...");
																victoria = gc.calcularVictoria(jugadorActual, mazmorras[opcionMazmorra].getEventos()[0], 1, 'i');
																gc.pintarResultadoCombateJefe(victoria,2);
															}
																														
															if (victoria == -1) jugadorVivo = false;
																														
															if (jugadorVivo) {
																System.out.println("!!! Intentas esquivar un golpe inesperado !!!");
																victoria = gc.calcularVictoria(jugadorActual, mazmorras[opcionMazmorra].getEventos()[0], 1, 'a');
																gc.pintarResultadoCombateJefe(victoria,3);
															}
															
															if (victoria == -1) jugadorVivo = false;
																														
															if (jugadorVivo) {
																System.out.println("El jefe combate con todas sus fuerzas y...");
																victoria = gc.calcularVictoria(jugadorActual, mazmorras[opcionMazmorra].getEventos()[0], 1, 'd');
																gc.pintarResultadoCombateJefe(victoria,4);
																
															}
															
															if (victoria == -1) {
																jugadorVivo = false;
																System.out.println("Has sido derrotado. Hazte más fuerte "
																		+ "en la tienda mágica para avanzar más lejos.");
															}
															else {
																jefeActual = (Jefe)(mazmorras[opcionMazmorra].getEventos()[0]);
																
																if (jugadorActual.getClase() == Clase.COMERCIANTE) {
																	recompensaOro = (int)(jefeActual.calcularRecompensa(i)*1.5);
																}
																else {
																	recompensaOro = (int)(jefeActual.calcularRecompensa(i));
																}
																
																System.out.println("Has ganado "+recompensaOro+" de oro");
																try {
																	jugadorActual.modificarOro(recompensaOro);
																} catch (ExcepcionJugador e) {}
																
																if (opcionMazmorra != 9 && opcionMazmorra == jugadorActual.getMazmorrasCompletadas()) {
																	try {
																		jugadorActual.setMazmorrasCompletadas(opcionMazmorra+1);
																	} catch (ExcepcionJugador e) {}
																	System.out.println("Mazmorra " +(opcionMazmorra+1)+  " desbloqueada.");
																}
																else if (opcionMazmorra == 9){
																	//Pintar creditos
																	System.out.println("Creditos en construcción.");
																}
																
																System.out.println("Pulsa intro para continuar.");
																
																sc.nextLine();
																
															}

														}
														
													}	
													
												}
												else {
													System.out.println("Aun no has desbloqueado esa mazmorra.");
												}
												
													
											break;	
										}
										
										GestoraFichero.guardarJugadorEnPosicion(jugadorActual, espacioGuardado);
									}
								}
								while (opcionMazmorra != 0);
								
							break;
								
						}
						
					}
				}
				while (opcionMenuJuego != 0);
				
				musicaJuego.stop();
		
			}
			
		}
		while (opcionMenuPrincipal != 0);
		
		sc.close();
		musicaIntro.close();
		
	}
	
	/*
	 * pintarOpcionesSala
	 * 
	 * este método pinta por pantalla las opciones
	 * de salida en las salas de la mazmorra
	 * 
	 * precondiciones: la sala pintada tendrá un valor entre 1 y 4
	 * entradas: salaPintada
	 * salida: no hay
	 * e/s: no hay
	 * postcondiciones:
	 * 
	 */
	
	public void pintarOpcionesSala(int salaPintada) {
		System.out.println(" --- Elige Salida --- ");
		switch (salaPintada)  {
			
			case 1:
				System.out.println("1 - Arriba.");
				System.out.println("2 - Derecha.");
			break;
			
			case 2:
				System.out.println("1 - Arriba.");
				System.out.println("2 - Izquierda.");
			break;
				
			case 3:
				System.out.println("1 - Derecha.");
				System.out.println("2 - Izquierda.");
			break;
				
			case 4:
				System.out.println("1 - Arriba.");
				System.out.println("2 - Derecha.");
				System.out.println("3 - Izquierda.");
			break;
		
		}
	}
	
	/* 
	 * pintarSala
	 * 
	 * este método se encargará de pintar por pantalla la
	 * habitación que se encontrará el jugador al pasar un evento.
	 * 
	 * entradas: salaPintada (int)
	 * salidas: nada
	 * E/S: nada
	 * Postcondiciones: se habrá pintado por pantalla
	 */
	 
	public static int pintarSala(int salaPintada) {
		
		UtilJuego.limpiarPantalla(10);
		// Imagenes de la sala
		switch (salaPintada){
			case 1: 
					
				System.out.println("\t                               ");
				System.out.println("\t           |       |           ");
				System.out.println("\t   ---------       ---------   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |___");
				System.out.println("\t   |                           ");
				System.out.println("\t   |                           ");
				System.out.println("\t   |                        ___");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   ---------   ^   ---------   ");
				System.out.println("\t           |   ^   |           ");
				System.out.println("\t               ^               ");
				System.out.println("\t                               ");
				

			break;
			
			case 2: 
					
				System.out.println("\t                               ");
				System.out.println("\t           |       |           ");
				System.out.println("\t   ---------       ---------   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t___|                       |   ");
				System.out.println("\t                           |   ");
				System.out.println("\t                           |   ");
				System.out.println("\t___                        |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   ---------   ^   ---------   ");
				System.out.println("\t           |   ^   |           ");
				System.out.println("\t               ^               ");
				System.out.println("\t ");
				
			break;
			
			case 3: 
					
				System.out.println("\t                               ");
				System.out.println("\t   -------------------------   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t___|                       |___");
				System.out.println("\t                               ");
				System.out.println("\t                               ");
				System.out.println("\t___                         ___");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   ---------   ^   ---------   ");
				System.out.println("\t           |   ^   |           ");
				System.out.println("\t               ^               ");
				System.out.println("\t ");
				
			break;
			
			case 4:
					
				System.out.println("\t                               ");
				System.out.println("\t           |       |           ");
				System.out.println("\t   ---------       ---------   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t___|                       |___");
				System.out.println("\t                               ");
				System.out.println("\t                               ");
				System.out.println("\t___                         ___");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   |                       |   ");
				System.out.println("\t   ---------   ^   ---------   ");
				System.out.println("\t           |   ^   |           ");
				System.out.println("\t               ^               ");
				System.out.println("\t ");
				
			break;
		}
		
		UtilJuego.limpiarPantalla(3);
		return salaPintada;
		
	}
	
	
	private void pintarMenuMazmorras() {


		UtilJuego.limpiarPantalla(10); 
		
		System.out.println("   _________________________________________________________");
		System.out.println("   /|     -_-                                             _-  |\\");
		System.out.println("  / |_-_- _                                         -_- _-   -| \\   ");
		System.out.println("    |                            _-  _--                      | ");
		System.out.println("    |                            ,                            |");
		System.out.println("    |      .-'````````'.        '(`        .-'```````'-.      |");
		System.out.println("    |    .` |           `.      `)'      .` |           `.    |");        
		System.out.println("    |   /   |   ()        \\      U      /   |    ()       \\   |");
		System.out.println("    |  |    |    ;         | o   T   o |    |    ;         |  |");
		System.out.println("    |  |    |     ;        |  .  |  .  |    |    ;         |  |");
		System.out.println("    |  |    |     ;        |   . | .   |    |    ;         |  |");
		System.out.println("    |  |    |     ;        |    .|.    |    |    ;         |  |");
		System.out.println("    |  |    |____;_________|     |     |    |____;_________|  |");
		System.out.println("    |  |   /  __ ;   -     |     !     |   /     `'() _ -  |  |");
		System.out.println("    |  |  / __  ()        -|        -  |  /  __--      -   |  |");
		System.out.println("    |  | /        __-- _   |   _- _ -  | /        __--_    |  |");
		System.out.println("    |__|/__________________|___________|/__________________|__|");
		System.out.println("   /                                             _ -        lc \\");
		System.out.println("  /   -_- _ -             _- _---                       -_-  -_ \\");
		
		System.out.println("\n\n\t ---- Elige tu mazmorra ---- ");
		System.out.println("\t 0 - Salir.");
		System.out.println("\t-1 - Tutorial.");
		System.out.println("\t 1 - Mazmorra 1");
		System.out.println("\t 2 - Mazmorra 2");
		System.out.println("\t 3 - Mazmorra 3");
		System.out.println("\t 4 - Mazmorra 4");
		System.out.println("\t 5 - Mazmorra 5");
		System.out.println("\t 6 - Mazmorra 6");
		System.out.println("\t 7 - Mazmorra 7");
		System.out.println("\t 8 - Mazmorra 8");
		System.out.println("\t 9 - Mazmorra 9");
		System.out.println("\t ---- ----- ----- ----- ---- ");
		
		
	}


	/*
	 * pintarConfirmacionTienda
	 * 
	 * este método pintará por pantalla lo que el
	 * jugador recibirá en función de su oro y su clase.
	 * 
	 * si es comerciante, gastará 4 monedas por cada 
	 * punto de estadística, sino, gastará 5.
	 * 
	 * Si es guerrero y ha elegido subir fuerza, verá incrementada
	 * su bonificación en x2
	 * 
	 * Si es mago y ha elegido subir inteligencia, verá incrementada
	 * su bonificación en x2
	 * 
	 * Si es ladron y ha elegido subir agilidad, verá incrementada
	 * su bonificación en x2
	 * 
	 * la opcion de la tienda indica: 
	 * 		1 - fuerza
	 * 		2 - inteligencia
	 * 		3 - agilidad
	 * 
	 * precondiciones: la clase del jugador no puede ser "NINGUNA" o nula.
	 * 		opcionTienda debe tener un valor entre 1 y 3
	 * entradas: jugador, la opcion de la tienda (int)
	 * salidas: no hay
	 * e/s: no hay
	 * 
	 * 
	 * 
	 */
	
	private void pintarConfirmacionTienda(Jugador j, int opcionTienda) {
		
		System.out.println("Gastarás "+j.getOro()+  " oro(s) para obtener ");
		
		switch (j.getClase()) {
		
			case GUERRERO:
				switch(opcionTienda) {
					case 1: System.out.print((int)j.getOro()/5*2 + " de fuerza"); break;
					case 2: System.out.print((int)j.getOro()/5 + " de inteligencia"); break;
					case 3: System.out.print((int)j.getOro()/5 + " de agilidad"); break;
				}
			break;
			
			case MAGO:
				switch(opcionTienda) {
					case 1: System.out.print((int)j.getOro()/5 + " de fuerza"); break;
					case 2: System.out.print((int)j.getOro()/5*2 + " de inteligencia"); break;
					case 3: System.out.print((int)j.getOro()/5 + " de agilidad"); break;
				}
			break;
				
			case LADRON:
				switch(opcionTienda) {
					case 1: System.out.print((int)j.getOro()/5 + " de fuerza"); break;
					case 2: System.out.print((int)j.getOro()/5 + " de inteligencia"); break;
					case 3: System.out.print((int)j.getOro()/5*2 + " de agilidad"); break;
				}
			break;
				
			case COMERCIANTE:
				switch(opcionTienda) {
					case 1: System.out.print((int)j.getOro()/4 + " de fuerza"); break;
					case 2: System.out.print((int)j.getOro()/4 + " de inteligencia"); break;
					case 3: System.out.print((int)j.getOro()/4 + " de agilidad"); break;
				}
			break;
			
			default: break;
			
		}
		System.out.println(", Continuar? (S/N)");
	}
	
	/*
	 * pintarMenuTienda
	 * 
	 * este método pinta por pantalla el menú de la tienda
	 * sin entradas/salidas
	 * postcondición: se habrá pintado por pantalla el menú de la tienda.
	 * 
	 * 
	 */

	private void pintarMenuTienda() {
		
		UtilJuego.limpiarPantalla(10);
		System.out.println("\t(       \"     )  ");
		System.out.println("\t ( _  *            ");
		System.out.println("\t    * (     /          ___\\");
		System.out.println("\t       \"              _/ /\\");
		System.out.println("\t       (   *  )    ___/   |\\");
		System.out.println("\t        )   \"     _ o)'-./__");
		System.out.println("\t        *  _ )    (_, . $$$\\" );
		System.out.println("\t        (  )   __ __ 7_ $$$$\\");
		System.out.println("\t          ( :  { _)  '---  $\\\\");
		System.out.println("\t     ______'___//__\\   ____, \\\\");
		System.out.println("\t    )           ( \\_/ _____\\_\\");
		System.out.println("\t   .'             \\   \\------''.\\");
		System.out.println("\t  |='           '=|  |         )\\");
		System.out.println("\t  |               |  |  .    _/\\");
		System.out.println("\t   \\    (. ) ,   /  /__I_____\\");
		System.out.println("\t    '._/_)_(\\__.'   (__,(__,_]\\");
		System.out.println("\t    @---()_.'---@\\");
		
		
		System.out.println("\n\n");
		System.out.println("\t ---- Elige tu opción ----");
		System.out.println("\t 0 - Salir");
		System.out.println("\t 1 - Cambiar todo tu oro por fuerza");
		System.out.println("\t 2 - Cambiar todo tu oro por inteligencia");
		System.out.println("\t 3 - Cambiar todo tu oro por agilidad");
		System.out.println("\t---- ---- ---- ---- ----");
		
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
		
		System.out.println("\t  	      _____   _____");
		System.out.println("\t  	     /     \\ /     \\");
		System.out.println("\t  	,   |       '       |");
		System.out.println("\t  	I __L________       L__");
		System.out.println("\t   O====IE__________/     ./___>");
		System.out.println("\t  	I      \\.       ./");
		System.out.println("\t  `	        \\.   ./");
		System.out.println("\t  	           \\ /");
		System.out.println("\t   	           '");
		
		System.out.println("\n\n");
		System.out.println("\t ---- Elige tu opción ----");
		System.out.println("\t 0 - Salir");
		System.out.println("\t 1 - Mostrar Estadisticas.");
		System.out.println("\t 2 - Ir a la tienda mágica.");
		System.out.println("\t 3 - Ir a las mazmorras.");
		System.out.println("\t---- ---- ---- ---- ----");
		
		
	}

	/*
	 * pintarMenuPrincipal
	 * 
	 * pinta el menú principal del juego por pantalla.
	 * sin entradas / salidas.
	 * postcondicion: se habrá pintado por pantalla el menú principal.
	 */
	
	private void pintarMenuPrincipal() {
		
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
	
	private void pintarTitulo() {
		
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
