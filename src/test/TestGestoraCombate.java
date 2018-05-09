package test;

import clases.*;
import programa.GestoraCombate;

public class TestGestoraCombate {

	public static void main(String[] args) {
		
		Jugador jug = new Jugador("M. Rajoy", Clase.LADRON, 10, 10, 10, 1000, 0);
		Monstruo mons = new Monstruo("Babosa corrupta", 10);
		Jefe jef = new Jefe("La Espe", 10, 10, 10, 10);
		int res = 0;
		GestoraCombate gc = new GestoraCombate();
		
		//Test con monstruo
		gc.pintarEnfrentamiento(jug, mons, 10);
		res = gc.calcularVictoria(jug, mons, 10, 'n');
		gc.pintarResultadoCombate(res);
		
		
		//Test con jefe
		gc.pintarEnfrentamiento(jug, jef, 10);
		
		res = gc.calcularVictoria(jug, jef, 10, 'f');
		gc.pintarResultadoCombateJefe(res, 1);
		
		res = gc.calcularVictoria(jug, jef, 10, 'i');
		gc.pintarResultadoCombateJefe(res, 2);
		
		res = gc.calcularVictoria(jug, jef, 10, 'a');
		gc.pintarResultadoCombateJefe(res, 3);
		
		res = gc.calcularVictoria(jug, jef, 10, 'd');
		gc.pintarResultadoCombateJefe(res, 4);
		

	}

}
