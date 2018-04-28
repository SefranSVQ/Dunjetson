/*
 * Clase Trampa
 * 
 * 		Atributos básicos:
 * 			- Nombre: String, consultable y modificable.
 * 			- Poder: Entero, consultable y modificable.
 * 
 * 		Métodos añadidos:
 * 			- esquivarTrampa // Dada la agilidad del jugador como att de entrada,
 * 				// se determinará si éste consigue o no esquivar la trampa.
 * 				// Formula: Aleatorio*PoderTrampa -> Se esquiva si el número 
 * 				// sacado es igual o menor a la agilidad del jugador. 
 * 				// Devuelve un booleano.
 * 			- generarRecompensaDeAgilidad	//Devuelve una bonificación de agilidad
 * 				// en función de la diferencia de agilidad entre el poder
 * 				// de la trampa y la agilidad del jugador.
 * 				// Formula: (poderTrampa*0.1)-(AgilidadJugador*0.1)
 * 				// Si el resultado sale 0, el jugador no ganará 1 de agilidad.
 * 				// Si el resultado sale negativo, el jugador no ganará bonus.
 * 
 * 		Restricciones:
 * 			- El poder debe ser un valor igual o superior a 0
 * 
 * 		Criterio de comparacion e igualdad: Recompensa.
 * 		
 */

/*
 * String getNombre()
 * void setNombre(String nombre)
 * 
 * int getPoder()
 * void setPoder(int poder)
 * 
 */

package clases;

import excepciones.ExcepcionTrampa;

public class Trampa {

	private String nombre;
	private int poder;
	
	//Constructores
	
	public Trampa() {
		nombre = "NoName";
		poder = 0;
	}
	
	public Trampa(String nombre, int poder) {
		super();
		this.nombre = nombre;
		this.poder = poder;
	}
	
	public Trampa(Trampa t) {
		super();
		this.nombre = t.nombre;
		this.poder = t.poder;
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
	
	public void setPoder(int poder) throws ExcepcionTrampa {
		if (poder >= 0)this.poder = poder;
		else throw new ExcepcionTrampa("Poder de trampa incorrecto");
	}


	//Métodos
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null && o instanceof Trampa) {
			
			Trampa t = (Trampa) o;
			
			if (this.getPoder() == t.getPoder()) igual = true;
			
		}
		
		return igual;
		
	}

	@Override
	public int hashCode() {
		return nombre.hashCode()+poder;
	}

	@Override
	public String toString() {
		return nombre.toString()+","+getPoder();
	}
	
	public int compareTo(Trampa t) {
		
		int comparacion = -1;
		
		if (this.getPoder() == t.getPoder()) comparacion = 0;
		else if (this.getPoder() > t.getPoder()) comparacion = 1;
		
		return comparacion;
		
	}
	
	/*
	 * metodo: esquivarTrampa
	 * comentario: Este programa determinará si el jugador 
	 * 		consigue o no esquivar la trampa.
	 * 		Formula: Aleatorio*PoderTrampa -> Se esquiva si el número 
	 * 		sacado es igual o menor a la agilidad del jugador. 
	 * Signatura: public boolean esquivarTrampa(int agilidad)
	 * Precondicion: no hay.
	 * E: Agilidad del jugador, un valor entero.
	 * S: PasarTrampa, booleano.
	 * E/: no hay
	 * Postcondicion: el método devolverá si el jugador consigue esquivar (true)
	 * 		o no (false) la trampa.
	 */
	
	public boolean esquivarTrampa(int agilidad) {
		
		boolean esquiva = false;
		
		int dificultad;
		
		if (agilidad >= poder) esquiva = true;
		else if (agilidad > 0 ) {
			
				dificultad = (int) (Math.random()*poder);
				
				if (dificultad < agilidad) esquiva = true;
			
			}

		return esquiva;
	}
	
	/*
	 * metodo: generarRecompensaDeAgilidad
	 * comentario: Devuelve una bonificación de agilidad
	 * 		en función de la diferencia de agilidad entre el poder
	 * 		de la trampa y la agilidad del jugador.
	 * 		Formula: (poderTrampa*0.1)-(AgilidadJugador*0.1)
	 * 		Si el resultado sale 0, el jugador no ganará 1 de agilidad.
	 * 		Si el resultado sale negativo, el jugador no ganará bonus.
	 * signatura: public int generarRecompensaDeAgilidad(int agilidad)
	 * precondiciones: no hay.
	 * E: agilidad del jugador, valor entero.
	 * S: recompensa, valor entero.
	 * E/S: no hay
	 * Postcondiciones: el método devolverá el bonus de agilidad que 
	 * 		recibirá el jugador en función de la dificultad
	 * 		de la trampa.
	 * 
	 */

	public int generarRecompensaDeAgilidad(int agilidad) {
		
		int recompensa;
		double formula;
		
		formula = ((poder*0.1)-(agilidad*0-1));
		
		if ((int)formula == 0) recompensa = 1;
		else if (formula < 0) recompensa = 0;
		else recompensa = (int) formula;
		
		return recompensa;
		
	}
	
}
