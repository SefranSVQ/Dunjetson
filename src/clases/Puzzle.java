/*
 * Clase Puzzle
 * 
 * 		Atributos básicos:
 * 			- Nombre: String, consultable y modificable.
 * 			- Respuesta: String, consultable y modificable.
 * 			- Recompensa: entero, consultable y modificable. //Será una recompensa de inteligencia
 * 
 * 		Restricciones:
 * 			- La recompensa debe ser un valor igual o mayor a 0.
 * 
 * 
 * 		Criterio de comparacion e igualdad: Recompensa
 * 
 */

/* interface
 * 
 *  String getNombre()
 *  void setNombre(String nombre)
 * 
 *  String getRespuesta()
 *  void setRespuesta(String respuesta)
 *  
 *  String getRecompensa()
 *  void setRecompensa(int recompensa)
 * 
 * 
 */

package clases;

import excepciones.ExcepcionPuzzle;

public class Puzzle implements Comparable<Puzzle> {

	private String nombre;
	private String respuesta;
	private int recompensa;
	
	
	// Recompensa
	
	public Puzzle() {
		
		nombre = "NoName";
		respuesta = "NoAnswer";
		recompensa = 0;
		
	}
	
	public Puzzle(String nombre, String respuesta, int recompensa) {
		
		this.nombre = nombre;
		this.respuesta = respuesta;
		this.recompensa = recompensa;
		
	}
	
	public Puzzle(Puzzle p) {
		
		this.nombre = p.getNombre();
		this.respuesta = p.getRespuesta();
		this.recompensa = p.getRecompensa();
				
	}

	
	// Getters y Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(int recompensa) throws ExcepcionPuzzle {
		if (recompensa >= 0) this.recompensa = recompensa;
		else throw new ExcepcionPuzzle("Recompensa Incorrecta");
	}

	
	//Metodos
	
	public int compareTo(Puzzle p) {

		int comparacion = -1;
		
		if (this.getRecompensa() == p.getRecompensa()) comparacion = 0;
		else if (this.getRecompensa() > p.getRecompensa() ) comparacion = 1;
		
		return comparacion;
	}
	
	@Override
	public String toString() {
		
		String s = this.getNombre()+","+this.getRespuesta()+","+this.getRecompensa();
		
		return s;
		
	}
	
	@Override 
	public int hashCode() {
		
		int code = (int) (getNombre().hashCode()-getRespuesta().hashCode())+getRecompensa();
		
		return code;
		
	}
	
	@Override
	public boolean equals(Object o) {
		
		boolean equal = false;
		
		if (o != null && o instanceof Puzzle) {
			
			Puzzle p = (Puzzle) o;
			
			if (this.getRecompensa() == p.getRecompensa()) equal = true; 
			
		}
		
		return equal;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
