/*
 * 
 * Clase Evento <Abstracta>
 * 
 * 		Atributos básicos:
 * 			- Nombre: String, consultable y modificable.
 * 			- DificultadBase: Entero, consultable y modificable.
 * 
 * 		Atributos derivados:
 * 			- recompensaBase: entero, consultable.
 * 
 * 		Restricciones:
 * 			- DificultadBase debe tener un valor superior a 0
 * 
 * 		Metodos añadidos:
 * 			- int calcularDificultad(int nivel)
 * 			- int calcularRecompensa(int nivel)
 * 			- int calcularVictoria(Jugador j) <abstracto>
 * 
 * 		Criterio de igualdad / comparacion: no necesita (no es instanciable)
 * 
 */


package clases;

import java.util.Random;

import excepciones.ExcepcionEvento;

public abstract class Evento {

	private String nombre;
	private int dificultadBase;	
	
	//Constructores
	public Evento() {
		nombre = "SinNombre";
		dificultadBase = 1;
	}
	
	public Evento(String nombre, int dificultadBase) {
		this.nombre = nombre;
		this.dificultadBase = dificultadBase;
	}

	public Evento(Evento e) {
		this.nombre = e.getNombre();
		this.dificultadBase = e.getDificultadBase();
	}


	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDificultadBase() {
		return dificultadBase;
	}
	public void setDificultadBase(int dificultadBase) throws ExcepcionEvento{
		if (dificultadBase < 1) throw new ExcepcionEvento("DificultadBase Incorrecta");
		this.dificultadBase = dificultadBase;
	}
	
	public int getRecompensaBase() {
		
		int recompensa;
		
		if (this.getDificultadBase()/5 == 0) recompensa = 1;
		else recompensa = this.getDificultadBase()/5;
		
		return recompensa;
	}

	
	//Metodos
	
	/*
	 * calcularDificultad
	 * 
	 * este método calculará la dificultad del evento en función
	 * del nivel en el que se encuentre el jugador.
	 * 
	 * precondiciones: el nivel debe ser un valor positivo
	 * entradas: nivel (entero)
	 * salidas: dificultad (entero)
	 * E/S: no hay
	 * 
	 * 
	 */
	
	public int calcularDificultad(int nivel) {
		
		int dificultad;
		
		dificultad = (int) (this.getDificultadBase()+(this.getDificultadBase()*nivel/12));
		
		return dificultad;
		
	}
	
	/*
	 * calcularRecompensa
	 * 
	 * este método calculará la recompensa del evento en función
	 * del nivel en el que se encuentre el jugador.
	 * 
	 * precondiciones: el nivel debe ser un valor positivo
	 * entradas: nivel (entero)
	 * salidas: recompensa (entero)
	 * E/S: no hay
	 */
	
	public int calcularRecompensa(int nivel) {
		
		int recompensa;
		Random rm = new Random();
		
		recompensa = (int) (this.getRecompensaBase()+rm.nextInt(2+(this.getRecompensaBase()*nivel)/25));
		
		return recompensa;
		
	}
	
	// -- Metodos sobreescritos -- //
	
	@Override
	public int hashCode() {
	
		int code = (int) this.getDificultadBase()*7+this.getNombre().hashCode();
		
		return code;
	}
	
	@Override
	public String toString() {
		
		String s = this.getNombre()+","+this.getDificultadBase();
		
		return s;
		
	}
	
	
}
