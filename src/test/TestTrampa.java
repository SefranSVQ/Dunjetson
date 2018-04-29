package test;

import clases.Puzzle;
import excepciones.ExcepcionEvento;

public class TestTrampa {

	public static void main(String[] args) {
		
		Puzzle m = new Puzzle("cáscara de platano",5);
		Puzzle m2 = new Puzzle();
		Puzzle m3 = new Puzzle(m);
		
		try {
			m3.setDificultadBase(20);
		} catch (ExcepcionEvento e) {}

		System.out.println(m.toString());
		
		System.out.println("\nMetodos de la clase padre:");
		System.out.println("\n\t calcularDificultad con niveles 1, 50 y 200");
		System.out.println(m.calcularDificultad(1));
		System.out.println(m.calcularDificultad(50));
		System.out.println(m.calcularDificultad(200));
		
		System.out.println("\n\t calcularRecompensa con niveles 1, 50 y 200");
		System.out.println(m.calcularRecompensa(1));
		System.out.println(m.calcularRecompensa(50));
		System.out.println(m.calcularRecompensa(200));
		
		System.out.println("\ncomparaciones");
		System.out.println(m.compareTo(m2));
		System.out.println(m.compareTo(m));
		System.out.println(m.compareTo(m3));
		
		System.out.println("\n Igualdad");
		System.out.println(m.equals(m2));
		System.out.println(m.equals(m));
		System.out.println(m.equals(m3));
	
	}

}
