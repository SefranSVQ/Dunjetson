/*
 *  Clase Mazmorra
 *  
 *  	Atributos básicos:
 *  		- ID: entero, consultable.
 *  		- Nombre: String, consultable y modificable.
 *  		- totalNiveles: entero, consultable y modificable.
 *  
 *  	Atributos Agregados:
 *  		- monstruos: array de monstruos, consultable y modificable.
 *   		- puzzles: array de puzzles, consultable y modificable.
 *    		- trampas: array de trampas, consultable y modificable.
 *  		- jefe: jefe, consultable y modificable.
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
 * Monstruo[] getMonstruos()
 * void setMonstruos(Monstruo[] monstruos)
 * 
 * Puzzle[] getPuzzles()
 * void setPuzzles(Puzzle[] puzzles)
 * 
 * Trampa[] getTrampa()
 * void setTrampas(Trampa[] trampas)
 * 
 * Jefe getJefe()
 * void setJefe(Jefe jefe)
 * 
 * int getContadorID()
 * 
 */

package clases;

import excepciones.ExcepcionJugador;
 
public class Mazmorra implements Comparable<Mazmorra>{

	private int ID;
	private String nombre;
	private int totalNiveles;
	private Monstruo[] monstruos;
	private Puzzle[] puzzles;
	private Trampa[] trampas;
	private Jefe jefe;
	
	private static int contadorID;
	
	//Constructores
	public Mazmorra() {
		
		contadorID++;
		this.ID = contadorID;
		this.nombre = "NoName";
		this.totalNiveles = 1;
		this.monstruos = new Monstruo[2];
			monstruos[0] = new Monstruo();
			monstruos[1] = new Monstruo();
		this.puzzles = new Puzzle[2];
			puzzles[0] = new Puzzle();
			puzzles[1] = new Puzzle();
		this.trampas = new Trampa[2];
			trampas[0] = new Trampa();
			trampas[1] = new Trampa();
		this.jefe = new Jefe();
	}
	
	public Mazmorra(String nombre, int totalNiveles, Monstruo[] monstruos, Puzzle[] puzzles, Trampa[] trampas, Jefe jefe) {
		
		contadorID++;
		this.ID = contadorID;
		this.nombre = nombre;
		this.monstruos = monstruos;
		this.totalNiveles = totalNiveles;
		this.puzzles = puzzles;
		this.trampas = trampas;
		this.jefe = jefe;
	}
	
	public Mazmorra(Mazmorra m) {
		
		this.ID = m.getID();
		this.nombre = m.getNombre();
		this.totalNiveles = m.getTotalNiveles();
		this.monstruos = m.getMonstruos();
		this.puzzles = m.getPuzzles();
		this.trampas = m.getTrampas();
		this.jefe = m.getJefe();
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
	
	public void setTotalNiveles(int totalNiveles) throws ExcepcionJugador {
		if (totalNiveles > 0) this.totalNiveles = totalNiveles;
		else throw new ExcepcionJugador("Total de niveles incorrecto.");
	}
	
	public Monstruo[] getMonstruos() {
		return monstruos;
	}

	public void setMonstruos(Monstruo[] monstruos) {
		this.monstruos = monstruos;
	}

	public Puzzle[] getPuzzles() {
		return puzzles;
	}
	
	public void setPuzzles(Puzzle[] puzzles) {
		this.puzzles = puzzles;
	}
	
	public Trampa[] getTrampas() {
		return trampas;
	}
	
	public void setTrampas(Trampa[] trampas) {
		this.trampas = trampas;
	}
	
	public Jefe getJefe() {
		return jefe;
	}
	
	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

	
	// Métodos

	@Override
	public int hashCode() {

		int code = (int)this.getJefe().hashCode()/this.getID();
		
		return code;
		
	}

	@Override
	public String toString() {
		String s;
		
		s = this.getID()+","+this.getNombre()+","+this.getTotalNiveles()+",";
		
		
		for (int i = 0 ; i < monstruos.length ; i++ ) {
			s += this.getMonstruos()[i].toString()+",";
		}
		
		for (int i = 0 ; i < puzzles.length ; i++ ) {
			s += this.getPuzzles()[i].toString()+",";
		}
		
		for (int i = 0 ; i < trampas.length ; i++ ) {
			s += this.getTrampas()[i].toString()+",";
		}

		s += this.getJefe().toString();
		
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
