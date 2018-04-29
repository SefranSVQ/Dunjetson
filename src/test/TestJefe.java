package test;

import clases.Jefe;
import excepciones.ExcepcionEvento;
import excepciones.ExcepcionJefe;

public class TestJefe {

	public static void main(String[] args) {
		
		Jefe m = new Jefe("Gatito con metralleta",5, 5, 5, 5);
		Jefe m2 = new Jefe();
		Jefe m3 = new Jefe(m);
		
		System.out.println(m.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
		try {
			m3.setNombre("T-Rex");
			m3.setDificultadBase(50);
			m3.setFuerza(50);
			m3.setInteligencia(25);
			m3.setAgilidad(40);
		} catch (ExcepcionEvento | ExcepcionJefe e) {}
		
		System.out.println("\nCambio de parametros al jefe 3");
		System.out.println(m3.toString());
		
		
		System.out.println("\nCalculamos sus poderes de fuerza en función del nivel en el que se encuentren (1, 15, 50):");
		System.out.println("\nJefe 1:");
		System.out.println(m.calcularDificultadFuerza(1));
		System.out.println(m.calcularDificultadFuerza(15));
		System.out.println(m.calcularDificultadFuerza(50));
		
		System.out.println("\nJefe 2:");
		System.out.println(m2.calcularDificultadFuerza(1));
		System.out.println(m2.calcularDificultadFuerza(15));
		System.out.println(m2.calcularDificultadFuerza(50));
		
		System.out.println("\nJefe 3:");
		System.out.println(m3.calcularDificultadFuerza(1));
		System.out.println(m3.calcularDificultadFuerza(15));
		System.out.println(m3.calcularDificultadFuerza(50));
		
		System.out.println("\nCalculamos sus poderes de inteligencia en función del nivel en el que se encuentren (1, 15, 50):");
		System.out.println("\nJefe 1:");
		System.out.println(m.calcularDificultadInteligencia(1));
		System.out.println(m.calcularDificultadInteligencia(15));
		System.out.println(m.calcularDificultadInteligencia(50));
		
		System.out.println("\nJefe 2:");
		System.out.println(m2.calcularDificultadInteligencia(1));
		System.out.println(m2.calcularDificultadInteligencia(15));
		System.out.println(m2.calcularDificultadInteligencia(50));
		
		System.out.println("\nJefe 3:");
		System.out.println(m3.calcularDificultadInteligencia(1));
		System.out.println(m3.calcularDificultadInteligencia(15));
		System.out.println(m3.calcularDificultadInteligencia(50));
		
		System.out.println("\nCalculamos sus poderes de agilidad en función del nivel en el que se encuentren (1, 15, 50):");
		System.out.println("\nJefe 1:");
		System.out.println(m.calcularDificultadAgilidad(1));
		System.out.println(m.calcularDificultadAgilidad(15));
		System.out.println(m.calcularDificultadAgilidad(50));
		
		System.out.println("\nJefe 2:");
		System.out.println(m2.calcularDificultadAgilidad(1));
		System.out.println(m2.calcularDificultadAgilidad(15));
		System.out.println(m2.calcularDificultadAgilidad(50));
		
		System.out.println("\nJefe 3:");
		System.out.println(m3.calcularDificultadAgilidad(1));
		System.out.println(m3.calcularDificultadAgilidad(15));
		System.out.println(m3.calcularDificultadAgilidad(50));
		
		
		System.out.println("\nCalculamos sus poderes totales en función del nivel en el que se encuentren (1, 15, 50):");
		System.out.println("\nJefe 1:");
		System.out.println(m.calcularDificultad(1));
		System.out.println(m.calcularDificultad(15));
		System.out.println(m.calcularDificultad(50));
		
		System.out.println("\nJefe 2:");
		System.out.println(m2.calcularDificultad(1));
		System.out.println(m2.calcularDificultad(15));
		System.out.println(m2.calcularDificultad(50));
		
		System.out.println("\nJefe 3:");
		System.out.println(m3.calcularDificultad(1));
		System.out.println(m3.calcularDificultad(15));
		System.out.println(m3.calcularDificultad(50));
		
		System.out.println("\ncalculamos diversas recompensas para el jefe 3 en el nivel 10:");
		System.out.println(m3.calcularRecompensa(10));
		System.out.println(m3.calcularRecompensa(10));
		System.out.println(m3.calcularRecompensa(10));
		System.out.println(m3.calcularRecompensa(10));
		
		
		// Metodos comparativos
		
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
