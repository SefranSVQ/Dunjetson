/*
 * Clase Jugador
 * 
 * 	Atributos básicos:
 * 		- Nick: String, consultable y modificable.
 * 		- Clase: Enum, consultable y modificable.
 * 		- Poder: Entero, consultable y modificable.		//Sirve para enfrentarse a los monstruos.
 * 		- Inteligencia: Entero, consultable y modificable.	//Sirve para enfrentarse a los puzzles.
 * 		- Agilidad: Entero, consultable y modificable.	//Sirve para salvarse de las trampas.
 * 		- Oro: Entero, consultable y modificable.	//Sirve para hacer transacciones en los eventos.
 * 		- MazmorrasCompletadas: entero, consultable y modificable. //Sirve para indicar las mazmorras completadas.
 * 
 *  Atributos derivados:
 *  	- Destreza: Entero, consultable //Poder+Inteligencia+Agilidad
 *  
 * Restricciones:
 * 		- Longitud de nick <= 10
 *  	- Clase debe ser GUERRERO, MAGO, LADRON, COMERCIANTE o NINGUNA
 *  	- Poder > 0
 *  	- Inteligencia > 0
 *  	- Agilidad > 0
 *  	- Oro >= 0
 *  	- Mazmorras completadas >= 0
 *  
 *  Criterio de igualdad y comparación: destreza.
 */

/*
 * Getters y setters
 * 
 * String getNick()
 * void setNick(String nick)
 * 
 * Clase getClase()
 * void setClase(Clase clase)
 * 
 * int getPoder()
 * void setPoder(int poder)
 * 
 * int getInteligencia()
 * void setInteligencia(int inteligencia)
 * 
 * int getAgilidad()
 * void setAgilidad(int agilidad)
 * 
 * int getOro()
 * void setOro(int oro)
 * 
 * int getMazmorrasCompletadas()
 * void setMazmorrasCompletadas(int mazmorrasCompletadas)
 * 
 * int getDestreza()
 * 
 */

package clases;

import excepciones.ExcepcionJugador;

public class Jugador implements Cloneable, Comparable <Jugador>{ 

	private String nick;
	private Clase clase;
	private int poder;
	private int inteligencia;
	private int agilidad;
	private int oro;
	private int mazmorrasCompletadas;
	
	
	//constructores;
	
	public Jugador() {
		
		this.nick = "Heroe";
		this.clase = Clase.NINGUNA;
		this.poder = 1;
		this.inteligencia = 1;
		this.agilidad = 1;
		this.oro = 0;
		this.mazmorrasCompletadas = 0;
		
	}
	
	public Jugador(String nick, Clase clase, int poder, int inteligencia, int agilidad, int oro,
			int mazmorrasCompletadas) {
		
		this.nick = nick;
		this.clase = clase;
		this.poder = poder;
		this.inteligencia = inteligencia;
		this.agilidad = agilidad;
		this.oro = oro;
		this.mazmorrasCompletadas = mazmorrasCompletadas;
		
	}
	
	public Jugador(Jugador j) {
		
		this.nick = j.getNick();
		this.clase = j.getClase();
		this.poder = j.getPoder();
		this.inteligencia = j.getInteligencia();
		this.agilidad = j.getAgilidad();
		this.oro = j.getOro();
		this.mazmorrasCompletadas = j.getMazmorrasCompletadas();
		
	}
	
	
	// Getters y setters
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) throws ExcepcionJugador {
		
		if (nick.length() <= 10) {
			this.nick = nick;
		}
		else throw new ExcepcionJugador("Nombre incorrecto. Longitud muy larga.");
			
	}
	
	public Clase getClase() {
		return clase;
	}
	
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
	public int getPoder() {
		return poder;
	}
	
	public void setPoder(int poder) throws ExcepcionJugador {
		
		if (poder > 0) {
			this.poder = poder;
		}
		else throw new ExcepcionJugador("Poder incorrecto");
	}
	
	public int getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(int inteligencia) throws ExcepcionJugador {
		if (inteligencia > 0) {
			this.inteligencia = inteligencia;
		}
		else throw new ExcepcionJugador("Inteligencia incorrecta");
	}
	
	public int getAgilidad() {
		return agilidad;
	}
	
	public void setAgilidad(int agilidad) throws ExcepcionJugador {
		if (agilidad > 0 ) {
			this.agilidad = agilidad;
		}
		else throw new ExcepcionJugador("Agilidad incorrecta");
	}
	
	public int getOro() {
		return oro;
	}
	
	public void setOro(int oro) throws ExcepcionJugador {
		if (oro >= 0) {
			this.oro = oro;
		}
		else throw new ExcepcionJugador("Oro incorrecto");
	}
	
	public int getMazmorrasCompletadas() {
		return mazmorrasCompletadas;
	}
	
	public void setMazmorrasCompletadas(int mazmorrasCompletadas) throws ExcepcionJugador {
		if (mazmorrasCompletadas >= 0) {
			this.mazmorrasCompletadas = mazmorrasCompletadas;
		}
		else throw new ExcepcionJugador("Mazmorras completadas incorrectas");
	}
	
	public int getDestreza() {
		
		return getPoder()+getAgilidad()+getInteligencia();
		
	}
	
	//Metodos
	
	/*
	 * Metodo: modificarOro
	 * Comentario: Este método permite sumar (o restar)
	 * 	una cantidad de oro a la perteneciente al jugador.
	 * Signatura: void modificarOro(int modificadorOro)
	 * Precondiciones: no hay.
	 * Entradas: modificadorOro (entero)
	 * Salidas: no hay
	 * E/S: no hay
	 * Postcondiciones: El valor del oro del jugador 
	 * 		se habrá modificado si el resultado no es menor a 0.
	 * 
	 */
	
	public void modificarOro(int modificadorOro) throws ExcepcionJugador {
		
		if (getOro() + modificadorOro >= 0) oro += modificadorOro;
		else throw new ExcepcionJugador("El jugador no puede tener dinero a deber.");
			
	}
	
	
	/*
	 * Metodo: modificarPoder
	 * Comentario: Este método permite sumar (o restar)
	 * 	una cantidad de poder a la perteneciente al jugador.
	 *  Si el resultado es menor a 1, se quedará a ese valor.
	 * Signatura: void modificarPoder(int modificadorPoder)
	 * Precondiciones: no hay
	 * Entradas: modificadorPoder (entero)
	 * Salidas: no hay
	 * E/S: no hay
	 * Postcondiciones: El valor del poder del jugador 
	 * 		se habrá modificado. Si el resultado es
	 * 		menor a 1, se quedará a 1.
	 * 
	 */
	
	public void modificarPoder(int modificadorPoder) {
		
		if (getPoder() + modificadorPoder > 1) poder += modificadorPoder;
		else poder = 1;
	}
	
	/*
	 * Metodo: modificarInteligencia
	 * Comentario: Este método permite sumar (o restar)
	 * 	una cantidad de inteligencia a la perteneciente al jugador.
	 *  Si el resultado es menor a 1, se quedará a ese valor.
	 * Signatura: void modificarInteligencia (int modificadorInteligencia)
	 * Precondiciones: no hay
	 * Entradas: modificadorInteligencia (entero)
	 * Salidas: no hay
	 * E/S: no hay
	 * Postcondiciones: El valor de inteligencia del jugador 
	 * 		se habrá modificado. Si el resultado es
	 * 		menor a 1, se quedará a 1.
	 * 
	 */
	
	public void modificarInteligencia(int modificadorInteligencia) {
		
		if (getInteligencia() + modificadorInteligencia > 1) inteligencia += modificadorInteligencia;
		else inteligencia = 1;
	}
	
	/*
	 * Metodo: modificarAgilidad
	 * Comentario: Este método permite sumar (o restar)
	 * 	una cantidad de agilidad a la perteneciente al jugador.
	 *  Si el resultado es menor a 1, se quedará a ese valor.
	 * Signatura: void modificarAgilidad (int modificadorAgilidad)
	 * Precondiciones: no hay
	 * Entradas: modificadorAgilidad (entero)
	 * Salidas: no hay
	 * E/S: no hay
	 * Postcondiciones: El valor de Agilidad del jugador 
	 * 		se habrá modificado. Si el resultado es
	 * 		menor a 1, se quedará a 1.
	 * 
	 */
	
	public void modificarAgilidad(int modificadorAgilidad) {
		
		if (getAgilidad() + modificadorAgilidad > 1) agilidad += modificadorAgilidad;
		else agilidad = 1;
	}

	
	/*
	 * reiniciarJugador
	 * 
	 * este método reinicia las estadísticas del jugador
	 * 
	 * sin entradas ni salidas
	 */
	
	public void reiniciarJugador() {
		try {
			setNick("Heroe");
			setClase(Clase.NINGUNA);
			setPoder(1);
			setInteligencia(1);
			setAgilidad(1);
			setOro(0);
			setMazmorrasCompletadas(0);
		} catch (ExcepcionJugador e) {}
	}
	
	@Override
	public Jugador clone(){
		
		Jugador clon = null;
		
		try {
			clon = (Jugador)super.clone();
		}
		catch (CloneNotSupportedException e) {
			System.out.println("Clon no creado.");
		}
		
		return clon;
	}

	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if (o != null & o instanceof Jugador) {
			
			Jugador j = (Jugador) o;
			
			if (j.getDestreza() == this.getDestreza()) {
			
				igual = true;
				
			}
			
		}
		
		return igual;
	}

	
	@Override
	public int hashCode() {
		
		return (int) (nick.hashCode()+clase.hashCode()*0.1+getDestreza());
	}

	
	@Override
	public String toString() {
		
		String s = this.getNick()+","+this.getClase()+","+this.getPoder()+","+this.getInteligencia();
		s += ","+this.getAgilidad()+","+this.getOro()+","+this.getMazmorrasCompletadas();
		
		return s;
	}
	
	public int compareTo(Jugador j) {
		
		int comparacion = -1;
		
		if (this.getDestreza() == j.getDestreza()) comparacion = 0;
		else if (this.getDestreza() > j.getDestreza()) comparacion = 1;
		
		return comparacion;
		
	}
	
}
