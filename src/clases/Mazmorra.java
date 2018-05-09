/*
 *  Clase Mazmorra
 *  
 *  	Atributos básicos:
 *  		- ID: entero, consultable.
 *  		- Nombre: String, consultable y modificable.
 *  		- totalNiveles: entero, consultable y modificable.
 *  
 *  	Atributos Agregados:
 *  		- eventos: array de eventos, consultable y modificable.
 *  
 *  	Atributos compartidos:
 *  		- contadorID: entero, consultable.
 * 
 * 		Restricciones:
 * 			- El total de niveles debe ser un número entero positivo.
 * 
 */

/*
 * Getters y Setters
 * 
 * int getID()
 * 
 * String getNombre()
 * void setNombre(String nombre)
 * 
 * int getTotalNiveles()
 * void setTotalNiveles(int totalNiveles)
 * 
 * Evento[] getEventos()
 * void setEventos(Evento[] eventos)
 * 
 * int getContadorID()
 * 
 */

package clases;

import excepciones.ExcepcionMazmorra;

public class Mazmorra implements Comparable<Mazmorra>{

	private int ID;
	private String nombre;
	private int totalNiveles;
	private Evento[] eventos;
	
	private static int contadorID;
	
	//Constructores
	public Mazmorra() {
		
		contadorID++;
		this.ID = contadorID;
		this.nombre = "NoName";
		this.totalNiveles = 1;
		this.eventos = new Evento[]{new Jefe(), new Monstruo(), new Puzzle(), new Trampa()};
	}
	
	public Mazmorra(String nombre, int totalNiveles, Evento[] eventos) {
		
		contadorID++;
		this.ID = contadorID;
		this.nombre = nombre;
		this.totalNiveles = totalNiveles;
		this.eventos = eventos;
	}
	
	public Mazmorra(Mazmorra m) {
		
		this.ID = m.getID();
		this.nombre = m.getNombre();
		this.totalNiveles = m.getTotalNiveles();
		this.eventos = m.getEventos();
	}
	
	
	//Getters y Setters
	
	public int getID() {
		return ID;
	}

	public static int getContadorID() {
		return contadorID;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTotalNiveles() {
		return totalNiveles;
	}
	
	public void setTotalNiveles(int totalNiveles) throws ExcepcionMazmorra {
		if (totalNiveles > 0) this.totalNiveles = totalNiveles;
		else throw new ExcepcionMazmorra("Total de niveles incorrecto.");
	}
	
	public Evento[] getEventos() {
		return eventos;
	}

	public void setEventos(Evento[] eventos) {
		this.eventos = eventos;
	}

	
	// Métodos

	@Override
	public int hashCode() {

		int code = (int)this.nombre.hashCode()+eventos[0].hashCode()/this.getID();
		
		return code;
		
	}

	@Override
	public String toString() {
		String s;
		
		s = this.getID()+","+this.getNombre()+","+this.getTotalNiveles()+",";
		
		
		for (int i = 0 ; i < eventos.length ; i++ ) {
			s += this.getEventos()[i].toString()+",";
		}
		
		
		return s;
	}

	@Override
	public int compareTo(Mazmorra m) {

		int comparacion = -1;
		
		if (this.getID() == m.getID()) comparacion = 0;
		else if (this.getID() > m.getID()) comparacion = 1;
		
		return comparacion;
		
	}
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null && o instanceof Mazmorra) {
			
			Mazmorra m = (Mazmorra)o;
			
			if (this.getID() == m.getID()) igual = true;
			
		}
		
		return igual;
		
	}
	
}
