package test;

import clases.Puzzle;
import excepciones.ExcepcionPuzzle;
 
public class TestPuzzle {

	public static void main(String[] args) {

		Puzzle p1 = new Puzzle();
		Puzzle p2 = new Puzzle("1+1","2",1);
		Puzzle p3 = new Puzzle(p2);
		
		System.out.println("Puzzle 1: Constructor sin att.");
		System.out.println(p1.toString());
		
		System.out.println("Puzzle 2: Constructor con att");
		System.out.println(p2.toString());
		
		System.out.println("Puzzle 3: Constructor copia.");
		System.out.println(p3.toString());
		
		
		System.out.println("\nPuzzles: cambio de variables.");
		p1.setNombre("Formula química del agua (En Mayusculas)");
		p1.setRespuesta("H2O");
		try {
			p1.setRecompensa(3);
		} catch (ExcepcionPuzzle e) {}
		try {
			p3.setRecompensa(-10);
		} catch (ExcepcionPuzzle e) {}
		try {
			p3.setRecompensa(0);
		} catch (ExcepcionPuzzle e) {}
		
		System.out.println("\nPuzzles: cambio de variables, resultado");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());

		System.out.println("\nComparacion de puzzle 2 con los 3 puzzles");
		System.out.println(p2.compareTo(p1));
		System.out.println(p2.compareTo(p2));
		System.out.println(p2.compareTo(p3));
		
		System.out.println("\nComparación de igualdad de puzzle 2 con los 3 puzzles");
		System.out.println(p2.equals(p1));
		System.out.println(p2.equals(p2));
		System.out.println(p2.equals(p3));
		
		System.out.println("\nHashcodes");
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		
	}

}
