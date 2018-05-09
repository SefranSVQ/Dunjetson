package test;

import programa.UtilJuego;

public class TestUtilJuego {

	public static void main(String[] args) {
		
		System.out.println("Linea 1");
		UtilJuego.limpiarPantalla(5);
		
		System.out.println("Linea 6");
		
		System.out.println("paramos el tiempo 5 segundos");
		UtilJuego.pararTiempo(5000);
		System.out.println("Listo.");

	}

}
