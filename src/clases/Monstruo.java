/*
 * Clase Monstruo
 * 
 * 		Atributos básicos:
 * 			- Nombre: String, consultable y modificable.
 * 			- Poder: Entero, consultable y modificable.
 * 
 * 		Métodos añadidos:
 * 			- generarRecompensaDeOro 
 * 
 * 		Restricciones:
 * 			- El poder debe ser un valor igual o superior a 0
 * 
 */

/*
 * 
 * String getNombre()
 * void setNombre(String nombre)
 * 
 * int getPoder()
 * void setPoder(int Poder)
 * 
 */

package clases;

import java.util.Random;

import excepciones.ExcepcionMonstruo;

public class Monstruo {

	private String nombre;
	private int poder;
	
	
	// Constructores
	public Monstruo () {
		
		nombre = "NoName";
		poder = 0;
		
	}
	
	public Monstruo (String nombre, int poder) {
		
		this.nombre = nombre;
		this.poder = poder;
		
	}
	
	public Monstruo (Monstruo m) {
		
		this.nombre = m.getNombre();
		this.poder = m.getPoder();
		
	}

	// Getters y Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) throws ExcepcionMonstruo {
		
		if (poder < 0) {
			throw new ExcepcionMonstruo("Poder no válido");
		}
		else this.poder = poder;
	}
	
	//Metodos

	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null & o instanceof Monstruo) {
			
			Monstruo m = (Monstruo) o;
			
			if (m.getPoder() == this.getPoder()) {
			
				igual = true;
				
			}
			
		}
		
		return igual;
		
	}

	@Override
	public int hashCode() {
	
		int code = (int) this.getPoder()*7+this.getNombre().hashCode();
		
		return code;
	}

	@Override
	public String toString() {
		
		String s = this.getNombre()+","+this.getPoder();
		
		return s;
		
	}
	
	public int compareTo(Monstruo m) {
		
		int comparacion = -1;
		
		if (this.getPoder() == m.getPoder()) comparacion = 0;
		else if (this.getPoder() > m.getPoder()) comparacion = 1;
		
		return comparacion;
		
	}
	
	/*
	 * Método generarRecompensaDeOro
	 * Comentario: devuelve una cantidad de oro en función
	 * del poder del monstruo. 
	 * Signatura: int generarRecompensaDeOro()
	 * Precondiciones: no hay
	 * E: no hay
	 * S: un valor entero
	 * E/S: no hay
	 * Postcondiciones: el método devolverá un valor entero correspondiente
	 * 	al oro generado de un monstruo al ser derrotado.
	 */
	
	public int generarRecompensaDeOro() {
		
		int oro = 0;
		Random rng = new Random();
		
		oro = (int) (getPoder()+rng.nextInt(getPoder())/5)+1;
		
		return oro;
		
	}
	
	
}
