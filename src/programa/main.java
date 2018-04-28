
/*
 * Programa: Dunjetson
 * 
 * Comentario: este programa consistir� en recrear el
 * 		archiconocido juego de "Dunjetson", original de "SefranSVQ"
 * 		junto a nuevas mejoras a�adidas.
 * 	
 * 	Al iniciar el juego, se podr� elegir entre las siguientes opciones:
 * 		- 0: Salir del juego
 * 		- 1: Nueva Partida.
 * 		- 2: Cargar Partida.
 * 		- 3: Borrar Partida.
 * 		- 4: Copiar Partida.
 * 
 * Al iniciar una nueva partida, el programa preguntar� al jugador por su
 * 	nick/nombre, as� como la clase de personaje (Guerrero, Mago, Ladr�n o Comerciante) 
 * 	con la que iniciar� su aventura. En funci�n de la clase elegida, empezar� con 
 * 	una estad�stica mejorada.
 * 
 * Una vez completada la introducci�n, se le permitir� al usuario iniciar el tutorial, 
 * 	donde se le mostrar�n las bases para jugar.
 * 
 * Despu�s de completar el tutorial, tendr� acceso al men� de selecci�n de mazmorras. Cada
 * 	vez que complete una mazmorra, tendr� acceso a las mazmorras ya completadas y 
 * 	a la siguiente.
 * 
 * En cada mazmorra, el jugador se enfrentar� a distintos eventos, los cuales tendr� 
 * 	que superar con sus distintas estad�sticas en funci�n de a qu� se enfrente; 
 * 	para enfrentarse a un monstruo, se tendr� en cuenta el poder, 
 *  para superar un puzzle, su inteligenci, para superar una trampa, su agilidad, etc.
 *  
 * Si el jugador no supera alguna sala de alguna mazmorra, volver� al men� de mazmorras,
 * 	salvaguardando todo aquello que haya conseguido en sus aventuras anteriores.
 * 
 * Cada vez que el jugador acabe/muera en una mazmorra, se guardar� su progreso en 
 * 	un fichero externo. Cuando un usuario quiera continuar la aventura por donde 
 * 	la dej�, podr� cargar su partida en la opci�n "Cargar partida" del men� 
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
