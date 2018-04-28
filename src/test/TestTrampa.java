package test;

import clases.Trampa;
import excepciones.ExcepcionTrampa;
 
public class TestTrampa {

	public static void main(String[] args) {
		
		Trampa t1 = new Trampa();
		Trampa t2 = new Trampa("Cepo",10);
		Trampa t3 = new Trampa(t2);
		int agilidad = 5;
		
		System.out.println("Constructores");
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		
		System.out.println("\nCambio de variables en la trampa 3");
		t3.setNombre("Positivo en programación");
		try {
			t3.setPoder(-1);
		} catch (ExcepcionTrampa e) {}
		try {
			t3.setPoder(Integer.MAX_VALUE);
		} catch (ExcepcionTrampa e) {}
		
		System.out.println("\nNuevos valores\n"+t3.toString());
		
		System.out.println("\nComparacion de trampas");
		System.out.println(t2.compareTo(t1));
		System.out.println(t2.compareTo(t2));
		System.out.println(t2.compareTo(t3));
		
		System.out.println("\nComparacion de igualdad");
		System.out.println(t2.equals(t1));
		System.out.println(t2.equals(t2));
		System.out.println(t2.equals(t3));
		
		System.out.println("\nHashcodes");
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t3.hashCode());
		
		System.out.println("\nMetodo Trampa2.esquivarTrampa con agilidad == 5 (50%)");
		System.out.println(t2.esquivarTrampa(5));
		System.out.println(t2.esquivarTrampa(5));
		System.out.println(t2.esquivarTrampa(5));
		System.out.println(t2.esquivarTrampa(5));
		
		System.out.println("\nMetodo Trampa2.esquivarTrampa con agilidad == 0 (0%)");
		System.out.println(t2.esquivarTrampa(0));
		System.out.println(t2.esquivarTrampa(0));
		System.out.println(t2.esquivarTrampa(0));
		System.out.println(t2.esquivarTrampa(0));
		
		System.out.println("\nMetodo Trampa2.esquivarTrampa con agilidad == 10 (100%)");
		System.out.println(t2.esquivarTrampa(10));
		System.out.println(t2.esquivarTrampa(10));
		System.out.println(t2.esquivarTrampa(10));
		System.out.println(t2.esquivarTrampa(10));
		
		System.out.println("\n Metodo generarRecompensaDeAgilidad");
		System.out.println(t1.generarRecompensaDeAgilidad(agilidad));
		System.out.println(t2.generarRecompensaDeAgilidad(agilidad));
		System.out.println(t3.generarRecompensaDeAgilidad(agilidad));
		

	}

}
