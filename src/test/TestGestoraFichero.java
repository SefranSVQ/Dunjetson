package test;

import clases.Clase;
import clases.Jugador;
import programa.GestoraFichero;

public class TestGestoraFichero {

	public static void main(String[] args) {
		
		Jugador jugador = new Jugador("Patata", Clase.GUERRERO,5,3,3,10,0);
		Jugador jugador2 = new Jugador("Pseudoso", Clase.GUERRERO,5,3,3,10,0);
		int posicion = 1;
		String[] partidas = new String[5];
		
		GestoraFichero.reiniciarPartidas();
		System.out.println("Partidas reiniciadas en el fichero save.txt");
		
		GestoraFichero.guardarPartidasEnArray(partidas);
		GestoraFichero.pintarPartidasGuardadas(partidas);
		
		GestoraFichero.guardarJugadorEnPosicion(jugador, posicion);
		System.out.println("Partida en la posicion 1 modificada");
		
		GestoraFichero.guardarPartidasEnArray(partidas);
		GestoraFichero.pintarPartidasGuardadas(partidas);
		
		jugador2 = GestoraFichero.cargarJugador(1);
		
		System.out.println(jugador2.toString());
		
		

	}

}
