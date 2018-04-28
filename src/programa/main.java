
/*
 * Programa: Dunjetson
 * 
 * Comentario: este programa consistirá en recrear el
 * 		archiconocido juego de "Dunjetson", original de "SefranSVQ"
 * 		junto a nuevas mejoras añadidas.
 * 	
 * 	Al iniciar el juego, se podrá elegir entre las siguientes opciones:
 * 		- 0: Salir del juego
 * 		- 1: Nueva Partida.
 * 		- 2: Cargar Partida.
 * 		- 3: Borrar Partida.
 * 		- 4: Copiar Partida.
 * 
 * Al iniciar una nueva partida, el programa preguntará al jugador por su
 * 	nick/nombre, así como la clase de personaje (Guerrero, Mago, Ladrón o Comerciante) 
 * 	con la que iniciará su aventura. En función de la clase elegida, empezará con 
 * 	una estadística mejorada.
 * 
 * Una vez completada la introducción, se le permitirá al usuario iniciar el tutorial, 
 * 	donde se le mostrarán las bases para jugar.
 * 
 * Después de completar el tutorial, tendrá acceso al menú de selección de mazmorras. Cada
 * 	vez que complete una mazmorra, tendrá acceso a las mazmorras ya completadas y 
 * 	a la siguiente.
 * 
 * En cada mazmorra, el jugador se enfrentará a distintos eventos, los cuales tendrá 
 * 	que superar con sus distintas estadísticas en función de a qué se enfrente; 
 * 	para enfrentarse a un monstruo, se tendrá en cuenta el poder, 
 *  para superar un puzzle, su inteligenci, para superar una trampa, su agilidad, etc.
 *  
 * Si el jugador no supera alguna sala de alguna mazmorra, volverá al menú de mazmorras,
 * 	salvaguardando todo aquello que haya conseguido en sus aventuras anteriores.
 * 
 * Cada vez que el jugador acabe/muera en una mazmorra, se guardará su progreso en 
 * 	un fichero externo. Cuando un usuario quiera continuar la aventura por donde 
 * 	la dejó, podrá cargar su partida en la opción "Cargar partida" del menú 
 *	principal, seleccionando cual de las 4 disponibles quiere continuar.
 * 		
 * 
 * 
 * P.G.
 * 
 * inicio
 * 	iniciarJuego
 * fin
 * 
 * //iniciarJuego
 * 
 * Inicio
 * 	mostrarMensajeInicioYObtenerInicioJuego
 * 	repetir
 * 		mostrarMenuPrincipalYObtenerYValidarOpcionMenuPrincipal
 * 		si (opcionMenuPrincipal != 0)
 * 			segun (opcionMenuPrincipal)
 * 				caso 1: nuevaPartida
 * 				caso 2:	cargarPartida
 * 				caso 3: borrarPartida
 * 				caso 4: copiarPartida
 * 			fin segun
 * 			si (opcionMenuPrincipal == 1 || opcionMenuPrincipal == 2 && espacioCargado != 0)
 * 				iniciarPartida
 * 			fin si
 * 		fin si
 * 	mientras (opcionMenu != 0)
 * Fin
 * 
 * //nuevaPartida
 * 
 * inicio
 * 	
 * 	repetir
 * 		obtenerYValidarNickJugador
 * 		obtenerYValidarClaseJugador
 * 		obtenerYValidarConfirmacionJugador
 * 	mientras (confirmacionJugador = 'N')
 * 	PintarPartidasGuardadasYObtenerYValidarEspacioGuardado
 * 	confirmacionYValidacionEspacioGuardado
 * 	si (confirmacionEspacioGuardado == 'S')
 * 		crearJugadorEnEspacioSeleccionado
 * 	fin si
 * 	
 * 	
 *  si (confirmacionJugador == 'S')
 * Fin
 * 
 * //cargarPartida
 * 
 * inicio
 * 	pintarPartidasGuardasYObtenerYValidarEspacioGuardado
 * 	cargarJugador
 * fin
 * 
 * //borrarPartida
 * 
 * inicio
 * 	obtenerYValidarEspacioABorrar
 * 	obtenerConfirmacionEspacioABorrar
 * 	si (confirmacionEspacioABorrar == 'S')
 * 		borrarDatosDeEspacioSeleccionado
 *  fin si
 * fin
 * 
 * //copiarPartida
 * 
 * inicio
 * 	obtenerYValidarEspacioACopiar
 * 	obtenerYValidarEspacioASobreescribir
 * 	obtenerYValidarConfirmacionCopiar
 *  si (confirmacionCopiar == 'S')
 * 		copiarDatosEnEspacioSeleccionado
 *  fin si
 * fin
 * 
 * // iniciarPartida
 * 
 * inicio
 *  mostrarMenuJuegoYObtenerYValidarOpcionJuego
 *  si (opcionJuego != -1)
 *  	segun (opcionJuego)
 *  		caso 0: jugarTutorial
 *  		caso 1: jugarMazmorra1
 *  		caso 2: jugarMazmorra2
 *  		caso 3: jugarMazmorra3
 *  		caso 4: jugarMazmorra4
 *  		caso 5: jugarMazmorra5
 *  		caso 6: jugarMazmorra6
 *  		caso 7: jugarMazmorra7
 *  		caso 8: jugarMazmorra8
 *  		caso 9: jugarMazmorra9
 *  	fin segun
 *  	guardarPartida
 *  fin si
 * fin
 * 
 * // jugarTutorial
 * 
 * inicio
 * 	mostrarMensajeIntroductorio
 * 	EventoMonstruoTutorial
 * 	EventoTrampaTutorial
 * 	EventoDialogoTutorial
 * fin
 * 
 * //JugarMazmorra1	
 * 
 * inicio
 * 	para (i = 1 ; mientras i <= longitudMazmorra && vidasJugador > 0 ; i++) 
 * 		generarAleatorio
 * 		si (i < longitudMazmorra )
 * 			segun (aleatorio)
 * 				caso 1: generarEventoMonstruoAleatorioMazmorra1
 * 				caso 2: generarEventoTrampaAleatorioMazmorra1
 * 				caso 3: generarEventoDialogoAleatorioMazmorra1
 * 			fin segun
 * 		sino
 * 			generarEventoJefeMazmorra1
 * 		fin si
 * 		si (vidasJugador > 0)
 * 			elegirSiguienteSala
 * 		sino
 * 			mostrarMensajeDerrota
 * 		fin si
 *  fin para
 * fin
 * 
 * 
 */

package programa;

public class main {

	public static void main(String[] args) {
		
		GestoraPrincipal gest = new GestoraPrincipal();
		gest.iniciarJuego();
		
		
	}
	
}
