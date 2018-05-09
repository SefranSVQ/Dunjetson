package clases;

/*
 * Clase Trampa
 * 
 * 		clase hija de "Evento"
 * 
 * 		Atributos propios: ninguno.
 * 
 * 		criterio de comparacion / igualdad: dificultadBase
 */

public class Trampa extends Evento implements Comparable<Trampa>{

	
	//Constructores
	public Trampa() {
		super();
	}

	public Trampa(Trampa t) {
		super(t);
	}

	public Trampa(String nombre, int dificultadBase) {
		super(nombre, dificultadBase);
	}

	// Metodos
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null & o instanceof Trampa) {
			
			Trampa p = (Trampa) o;
			
			if (p.getDificultadBase() == this.getDificultadBase()) {
			
				igual = true;
				
			}
			
		}
		
		return igual;
		
	}	
	
	public int compareTo(Trampa p) {
		
		int comparacion = -1;
		
		if (this.getDificultadBase() == p.getDificultadBase()) comparacion = 0;
		else if (this.getDificultadBase() > p.getDificultadBase()) comparacion = 1;
		
		return comparacion;
		
	}
	
}
