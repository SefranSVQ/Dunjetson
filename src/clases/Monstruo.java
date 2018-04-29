package clases;

/*
 * Clase Monstruo
 * 
 * 		clase hija de "Evento"
 * 
 * 		Atributos propios: ninguno.
 * 
 * 		criterios de comparacion / igualdad: dificultadBase
 */

public class Monstruo extends Evento implements Comparable<Monstruo>{

	
	// Constructores
	public Monstruo() {
		super();
	}

	public Monstruo(Monstruo m) {
		super(m);
	}

	public Monstruo(String nombre, int dificultadBase) {
		super(nombre, dificultadBase);
	}
	
	
	// Metodos
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null & o instanceof Monstruo) {
			
			Monstruo m = (Monstruo) o;
			
			if (m.getDificultadBase() == this.getDificultadBase()) {
			
				igual = true;
				
			}
			
		}
		
		return igual;
		
	}	
	
	public int compareTo(Monstruo m) {
		
		int comparacion = -1;
		
		if (this.getDificultadBase() == m.getDificultadBase()) comparacion = 0;
		else if (this.getDificultadBase() > m.getDificultadBase()) comparacion = 1;
		
		return comparacion;
		
	}
	


}
