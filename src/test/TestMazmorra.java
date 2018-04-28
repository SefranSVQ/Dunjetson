package test;
 
import clases.*;
import excepciones.ExcepcionJugador;

public class TestMazmorra {

	public static void main(String[] args) {
		
		//Mazmorra por defecto
		Mazmorra defecto = new Mazmorra();
		
		//Mazmorra con atributos
		Monstruo[] monstruos = new Monstruo[2];
		monstruos[0] = new Monstruo("Rata", 2);
		monstruos[1] = new Monstruo("Paloma", 3);
		
		Puzzle[] puzzles = new Puzzle[2];
		puzzles[0] = new Puzzle("1+1", "2", 1);
		puzzles[1] = new Puzzle("Raíz cuadrada de 4", "2", 1);
		
		Trampa[] trampas = new Trampa[2];
		trampas[0] = new Trampa("Cepo", 20);
		trampas[1] = new Trampa("Examen sorpresa de traza", 999);
		
		Jefe jefe = new Jefe("Pseudoso", 5, 7, 5, 3);
		
		Mazmorra atributos = new Mazmorra("Instituto", 5, monstruos, puzzles, trampas, jefe);
		Mazmorra copia = new Mazmorra(defecto);
		
		
		//Test
		System.out.println("Atributos de las 2 mazmorras:");
		System.out.println(defecto.toString());
		System.out.println(atributos.toString());
		System.out.println(copia.toString());
		
		//Modificación de valores de la mazmorra por defecto (setters)
		defecto.setNombre("Patio");
		
		try {
			defecto.setTotalNiveles(-3);
		} catch (ExcepcionJugador e) {}
		try {
			defecto.setTotalNiveles(3);
		} catch (ExcepcionJugador e) {
			System.out.println("Total de niveles incorrecto.");
		}
		
		defecto.setMonstruos(monstruos);
		defecto.setPuzzles(puzzles);
		defecto.setTrampas(trampas);
		defecto.setJefe(jefe);
		
		System.out.println("\nModificación de valores en la mazmorra creada por defecto.");
		System.out.println(defecto.toString());
		System.out.println(atributos.toString());
		System.out.println(copia.toString());
		
		System.out.println("\nHashCodes");
		System.out.println(defecto.hashCode());
		System.out.println(atributos.hashCode());
		System.out.println(copia.hashCode());
		
		System.out.println("\nCompareTo (defecto -> atributos, atributos -> defecto, defecto -> defecto");
		System.out.println(defecto.compareTo(atributos));
		System.out.println(atributos.compareTo(defecto));
		System.out.println(defecto.compareTo(defecto));
		
		System.out.println("\nEquals (defecto -> atributos, atributos -> defecto, defecto -> defecto");
		System.out.println(defecto.equals(atributos));
		System.out.println(atributos.equals(defecto));
		System.out.println(defecto.equals(defecto));

	}

}
