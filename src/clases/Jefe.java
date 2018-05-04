package clases;

import java.util.Random;

/*
 * Clase Jefe
 * 
 * 		clase hija de "Evento"
 * 
 * 		Atributos básicos propios: 
 * 			- fuerza: entero, consultable y modificable.
 * 			- inteligencia: entero, consultable y modificable.
 * 			- agilidad: entero, consultable y modificable.
 * 
 * 		Atributos derivados:
 * 			- destreza: entero, consultable
 * 
 * 		Restricciones:
 * 			- fuerza > 0
 * 			- inteligencia > 0
 * 			- agilidad > 0
 * 
 * 		Metodos añadidos:
 * 			- calcularDificultadFuerza
 * 			- calcularDificultadInteligencia
 * 			- calcularDificultadAgilidad
 * 			- calcularDificultad (sobreescrito)
 * 			- calcularRecompensa (sobreescrito)
 * 			
 */

import excepciones.ExcepcionJefe;

public class Jefe extends Evento implements Comparable<Jefe>{

	private int fuerza;
	private int inteligencia;
	private int agilidad;
	
	//Constructores
	public Jefe() {
		super();
		fuerza = 1;
		inteligencia = 1;
		agilidad = 1;
	}

	public Jefe(Jefe j) {
		super(j);
		fuerza = j.getFuerza();
		inteligencia = j.getInteligencia();
		agilidad = j.getAgilidad();
	}

	public Jefe(String nombre, int dificultadBase, int fuerza, int inteligencia, int agilidad) {
		super(nombre, dificultadBase);
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.agilidad = agilidad;
	}
	
	
	// Getters y setters
	
	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) throws ExcepcionJefe{
		if (fuerza < 1) throw new ExcepcionJefe("Valor de fuerza incorrecto");
		else this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) throws ExcepcionJefe {
		if (inteligencia < 1) throw new ExcepcionJefe("Valor de inteligencia incorrecto");
		else this.inteligencia = inteligencia;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) throws ExcepcionJefe {
		if (fuerza < 1) throw new ExcepcionJefe("Valor de agilidad incorrecto");
		else this.agilidad = agilidad;
	}
	
	public int getDestreza() {
		return this.getAgilidad()+this.getFuerza()+this.getInteligencia()+this.getDificultadBase();
	}


	// Metodos
	
	/*
	 * calcularDificultadFuerza
	 * 
	 * este método calculará la dificultad del jefe en el enfrentamiento de fuerza
	 * en función del nivel en el que se encuentre el jugador.
	 * 
	 * precondiciones: el nivel debe ser un valor positivo
	 * entradas: nivel (entero)
	 * salidas: dificultad (entero)
	 * E/S: no hay
	 * 
	 * 
	 */
	
	public int calcularDificultadFuerza(int nivel) {
		
		int dificultad;
		
		dificultad = (int) (this.getFuerza()+(this.getFuerza()*nivel/12));
		
		return dificultad;
		
	}
	
	/*
	 * calcularDificultadInteligencia
	 * 
	 * este método calculará la dificultad del jefe en el enfrentamiento de inteligencia
	 * en función del nivel en el que se encuentre el jugador.
	 * 
	 * precondiciones: el nivel debe ser un valor positivo
	 * entradas: nivel (entero)
	 * salidas: dificultad (entero)
	 * E/S: no hay
	 * 
	 * 
	 */
	
	public int calcularDificultadInteligencia(int nivel) {
		
		int dificultad;
		
		dificultad = (int) (this.getInteligencia()+(this.getInteligencia()*nivel/12));
		
		return dificultad;
		
	}
	
	/*
	 * calcularDificultadAgilidad
	 * 
	 * este método calculará la dificultad del jefe en el enfrentamiento de agilidad
	 * en función del nivel en el que se encuentre el jugador.
	 * 
	 * precondiciones: el nivel debe ser un valor positivo
	 * entradas: nivel (entero)
	 * salidas: dificultad (entero)
	 * E/S: no hay
	 * 
	 * 
	 */
	
	public int calcularDificultadAgilidad(int nivel) {
		
		int dificultad;
		
		dificultad = (int) (this.getAgilidad()+(this.getAgilidad()*nivel/12));
		
		return dificultad;
		
	}
	
	/*
	 * calcularDificultad
	 * 
	 * este método calculará la dificultad del jefe en el enfrentamiento final 
	 * en función del nivel en el que se encuentre el jugador.
	 * 
	 * precondiciones: el nivel debe ser un valor positivo
	 * entradas: nivel (entero)
	 * salidas: dificultad (entero)
	 * E/S: no hay
	 * 
	 * 
	 */
	
	@Override
	public int calcularDificultad(int nivel) {
		
		int dificultad;
		
		dificultad = (int) (this.getDestreza()+(this.getDestreza()*nivel/12));
		
		return dificultad;
		
	}
	
	/*
	 * calcularRecompensa
	 * 
	 * este método calculará la recompensa del jefe en función
	 * del nivel en el que se encuentre el jugador.
	 * 
	 * precondiciones: el nivel debe ser un valor positivo
	 * entradas: nivel (entero)
	 * salidas: recompensa (entero)
	 * E/S: no hay
	 */
	
	@Override
	public int calcularRecompensa(int nivel) {
		
		int recompensa;
		Random rm = new Random();
		
		recompensa = (int) (this.getDestreza()+rm.nextInt(this.getDestreza()*nivel)/50);
		
		return recompensa;
		
	}
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null & o instanceof Jefe) {
			
			Jefe p = (Jefe) o;
			
			if (p.getDificultadBase() == this.getDificultadBase()) {
			
				igual = true;
				
			}
			
		}
		
		return igual;
		
	}	
	
	@Override
	public String toString() {
		String s;
		
		s = this.getNombre()+","+this.getDificultadBase()+","+this.getFuerza()+","+this.getInteligencia()+","+this.getAgilidad();
		
		return s;
	}
	
	public int compareTo(Jefe p) {
		
		int comparacion = -1;
		
		if (this.getDificultadBase() == p.getDificultadBase()) comparacion = 0;
		else if (this.getDificultadBase() > p.getDificultadBase()) comparacion = 1;
		
		return comparacion;
		
	}
	
}