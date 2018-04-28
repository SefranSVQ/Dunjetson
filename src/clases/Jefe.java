/*
 * Clase Jefe
 * 		
 * 		Clase hija de "Monstruo"
 * 		
 * 		Atributos básicos:
 * 			- inteligencia: entero, consultable y modificable
 * 			- agilidad: entero, consultable y modificable
 * 			- bonusDestreza: entero, consultable y modificable
 * 
 * 		Atributos derivados:
 * 			- Destreza: entero, consultable //poder+inteligencia+agilidad+bonusDestreza
 * 
 * 		Metodos añadidos:
 * 			- generarRecompensaDeOro //Metodo sobreescrito. Se tomará el valor de la destreza.
 * 
 * 		Restricciones:
 * 			- La inteligencia debe ser un valor igual o superior a 0
 * 			- La agilidad debe ser un valor igual o superior a 0
 * 			- El bonus de destreza debe ser u valor igual o superior a 0
 * 
 * 		Criterios de igualdad y comparación: destreza
 * 
 */

/*
 * getters y setters
 * 
 * int getInteligencia()
 * void setInteligencia(int inteligencia)
 * 
 * int getAgilidad()
 * void setAgilidad(int agilidad)
 * 
 * int getBonusDestreza()
 * void setBonusDestreza(int bonusDestreza)
 * 
 * int getDestreza()
 * 
 * 
 * 
 */

package clases;

import java.util.Random;
import excepciones.ExcepcionJefe;

public class Jefe extends Monstruo {

	private int inteligencia;
	private int agilidad;
	private int bonusDestreza;

	
	//constructores
	
	public Jefe() {
		
		super();
		inteligencia = 0;
		agilidad = 0;
		bonusDestreza = 0;
		
	}
	
	public Jefe (String nombre, int poder, int inteligencia, int agilidad, int bonusDestreza) {
		
		super(nombre, poder);
		this.inteligencia = inteligencia;
		this.agilidad = agilidad;
		this.bonusDestreza = bonusDestreza;
		
	}
	
	public Jefe (Jefe jefe) {
		
		super(jefe.getNombre(), jefe.getPoder());
		this.inteligencia = jefe.getInteligencia();
		this.agilidad = jefe.getAgilidad();
		this.bonusDestreza = jefe.getBonusDestreza();
		
	}


	// Getters y setters
	
	public int getInteligencia() {
		return inteligencia;
	}


	public void setInteligencia(int inteligencia) throws ExcepcionJefe {
		
		if (inteligencia > 0) this.inteligencia = inteligencia;
		else throw new ExcepcionJefe("Inteligencia incorrecta");
			
	}


	public int getAgilidad() {
		return agilidad;
	}


	public void setAgilidad(int agilidad) throws ExcepcionJefe {
		
		if (agilidad > 0) this.agilidad = agilidad;
		else throw new ExcepcionJefe("Agilidad incorrecta");
	}


	public int getBonusDestreza() {
		return bonusDestreza;
	}


	public void setBonusDestreza(int bonusDestreza) throws ExcepcionJefe {
		if (bonusDestreza > 0) this.bonusDestreza = bonusDestreza;
		else throw new ExcepcionJefe("Bonus de destreza incorrecto");
	}
	
	public int getDestreza() {
		
		return super.getPoder()+this.getAgilidad()+this.getInteligencia()+this.getBonusDestreza();
		
	}
	
	//Métodos
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null & o instanceof Jefe) {
			
			Jefe j = (Jefe) o;
			
			if (j.getDestreza() == this.getDestreza()) {
			
				igual = true;
				
			}
			
		}
		
		return igual;
		
	}

	@Override
	public int hashCode() {
	
		int code = (int) this.getDestreza()*7+this.getNombre().hashCode();
		
		return code;
	}

	@Override
	public String toString() {
		
		String s = super.toString()+","+this.getInteligencia()+","+this.getAgilidad()+","+this.getBonusDestreza();
		
		return s;
		
	}
	
	public int compareTo(Jefe j) {
		
		int comparacion = -1;
		
		if (this.getDestreza() == j.getDestreza()) comparacion = 0;
		else if (this.getDestreza() > j.getDestreza()) comparacion = 1;
		
		return comparacion;
		
	}
	
	/*
	 * Método generarRecompensaDeOro
	 * Comentario: devuelve una cantidad de oro en función
	 * de la destreza del jefe. 
	 * Signatura: int generarRecompensaDeOro()
	 * Precondiciones: no hay
	 * E: no hay
	 * S: un valor entero
	 * E/S: no hay
	 * Postcondiciones: el método devolverá un valor entero correspondiente
	 * 	al oro generado de un jefe al ser derrotado.
	 */
	
	@Override
	public int generarRecompensaDeOro() {
		
		int oro = 0;
		Random rng = new Random();
		
		oro = (int) (getDestreza()+rng.nextInt(getDestreza())/5)+1;
		
		return oro;
		
	}
	
	

}
