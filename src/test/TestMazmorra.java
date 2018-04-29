package test;

import clases.*;

public class TestMazmorra {

	public static void main(String[] args) {

		Mazmorra m1 = new Mazmorra();
		
		Evento[] eventos2 = new Evento[] {new Jefe("Gatito", 3,3,3,3), new Monstruo("Paloma",2), new Puzzle("Puzzle de 2 piezas", 1), new Trampa("Cascara de platano",2)};
		
		Mazmorra m2 = new Mazmorra("Jungla", 10, eventos2 );
		Mazmorra m3 = new Mazmorra(m1);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
		System.out.println("\nNumero de mazmorras diferentes creadas:"+Mazmorra.getContadorID());
		
		System.out.println("\nHashCodes:");
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
		
		System.out.println("\nComparaciones: (1 -> 2, 2 -> 2, 2 -> 1)");
		System.out.println(m1.compareTo(m2));
		System.out.println(m2.compareTo(m2));
		System.out.println(m2.compareTo(m1));
		
		System.out.println("\nIgualdad: (1 -> 2, 2 -> 2, 2 -> 1)");
		System.out.println(m1.equals(m2));
		System.out.println(m2.equals(m2));
		System.out.println(m2.equals(m1));

	}

}
