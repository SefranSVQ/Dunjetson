package clases;

/*
 * Clase Puzzle
 * 
 * 		clase hija de "Evento"
 * 
 * 		Atributos propios: ninguno.
 * 
 * 		criterio de comparacion / igualdad: dificultadBase
 */

public class Puzzle extends Evento implements Comparable<Puzzle>{

	
	//Constructores
	public Puzzle() {
		super();
	}

	public Puzzle(Puzzle p) {
		super(p);
	}

	public Puzzle(String nombre, int dificultadBase) {
		super(nombre, dificultadBase);
	}

	// Metodos
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null & o instanceof Puzzle) {
			
			Puzzle p = (Puzzle) o;
			
			if (p.getDificultadBase() == this.getDificultadBase()) {
			
				igual = true;
				
			}
			
		}
		
		return igual;
		
	}	
	
	public int compareTo(Puzzle p) {
		
		int comparacion = -1;
		
		if (this.getDificultadBase() == p.getDificultadBase()) comparacion = 0;
		else if (this.getDificultadBase() > p.getDificultadBase()) comparacion = 1;
		
		return comparacion;
		
	}
	
	
}
