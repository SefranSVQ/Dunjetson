
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
 * Despu�s de completar el tutorial, tendr� acceso al resto del men� de selecci�n de mazmorras. 
 * Cada vez que complete una mazmorra, tendr� acceso a las mazmorras ya completadas y 
 * 	a la siguiente.
 * 
 * En cada mazmorra, el jugador se enfrentar� a distintos eventos, los cuales tendr� 
 * 	que superar con sus distintas estad�sticas en funci�n de a qu� se enfrente; 
 * 	para enfrentarse a un monstruo, se tendr� en cuenta el poder, 
 *  para superar un puzzle, su inteligenci, para superar una trampa, su agilidad, etc.
 *  
 * Si el jugador no supera alguna sala de alguna mazmorra, volver� al men� de mazmorras,
 * 	salvaguardando todo aquello que haya conseguido en sus aventuras.
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
 *
 * inicio
 *  mostrarMenuJuegoYObtenerYValidarOpcionMenuJuego
 *  si (opcionMenuJuego != 'S')
 *  	segun (opcionMenuJuego)
 *  		caso 1: mostrarEstadisticasJugador
 *  		caso 2: Tienda
 *  		caso 3: MenuMazmorras
 *  	fin segun
 *  fin si
 * fin
 * 
 * // Tienda
 * 
 * inicio
 * 	mostrarMenuTiendaYObtenerYValidarOpcionTienda
 * 	si (opcionTienda != 0)
 * 		confirmarOpcionTienda
 * 		si (confirmacionTienda = 'S')
 * 			segun (opcionTienda)
 * 				caso 1: cambiarOroPorFuerza
 * 				caso 2: cambiarOroPorInteligencia
 * 				caso 3: cambiarOroPorAgilidad
 * 			fin segun
 * 			mostrarEstadisticasJugador
 * 			guardarPartida
 * 		fin si
 * 	fin si
 * fin
 * 
 * //MenuMazmorras
 * 
 * inicio
 * 	repetir
 * 		mostrarMenuMazmorraYObtenerYValidarOpcionMazmorra
 * 		si (opcionMazmorra != 0)
 * 			segun (opcionMazmorra)
 * 				caso -1: jugarTutorial
 * 				cualquierOtroCaso: jugarMazmorraSeleccionada
 * 			fin segun
 * 			guardarPartida
 * 		fin si
 * 	mientras (opcionMazmorra != -1)
 * fin
 * 
 * //jugarTutorial
 * 
 * inicio
 * 	realizarEventoMonstruoTutorial
 * 	realizarEventoPuzzleTutorial
 * 	realizarEventoTrampaTutorial
 * 	realizarEventoJefeTutorial
 * fin
 * 
 * //JugarMazmorraSeleccionada
 * 
 * inicio
 * 	si (mazmorraSeleccionada <= mazmorrasCompletadasJugador)
 * 		para (i = 0 ; mientras i < longitudMazmorra && jugadorVivo ; i++) 
 * 			si (i < longitudMazmorra-1 )
 * 				generarAleatorio
 * 				realizarEventoDeMazmorraSeleccionadaAleatorio
 * 				si (!jugadorVivo)
 * 					indicarJugadorMuerto
 * 				sino
 * 					generarRecompensaOroYEstadistica
 * 				fin si
 * 			sino
 * 				generarEventosJefeDeMazmorraSeleccionada
 * 				si (!jugadorVivo)
 * 					indicarJugadorMuerto
 * 				sino
 * 					generarRecompensaOro
 * 				fin si
 * 			fin si
 * 			si (!jugadorVivo)
 * 				mostrarMensajeDerrota
 * 			sino si (no es la �ltima sala)
 * 				elegirSiguienteSala
 * 				sino si (mazmorraSeleccionada == mazmorrasDesbloqueadas)
 * 					incrementarNumeroMazmorrasCompletadas
 * 				fin si
 * 			fin si
 *  	fin para
 *  sino
 *  	mostrarMensajeMazmorraNoAlcanzada
 *  fin si
 * fin
 * 
 * 
 */

package programa;

public class Main {

	public static void main(String[] args) {
		
		GestoraPrincipal gest = new GestoraPrincipal();
		gest.iniciarJuego();
		
		
	}
	
}
