package programa;

import java.util.Random;
import java.util.Scanner;

import clases.*;

public class GestoraCombate {

	/*
	 * pintarEnfrentamiento
	 * 
	 * este método pintará por pantalla las estadisticas
	 * que se tendrán en cuenta en un enfrentamiento, tanto
	 * por parte del jugador como por parte del evento.
	 * 
	 * en función del tipo de evento, se tendrán en cuenta 
	 * distintos parámetros del jugador.
	 * 
	 * precondiciones: jugador y evento no pueden
	 * 	tener valores nulos.
	 * 
	 * entradas: jugador, evento, nivel
	 * salidas: no hay
	 * e/s: no hay
	 * 
	 */
	
	public void pintarEnfrentamiento(Jugador jug, Evento e, int nivel) {
		
		Jefe jefe = null;
		Scanner sc = new Scanner(System.in);
		
		UtilJuego.limpiarPantalla(5);
		System.out.println("Te has encontrado con : "+e.getNombre()+".");
		if (e instanceof Monstruo) {
			System.out.println("Su poder es de "+e.calcularDificultad(nivel)+".");
			System.out.println("Tu fuerza es de: "+jug.getFuerza());
		}
		else if (e instanceof Puzzle) {
			System.out.println("Su poder es de "+e.calcularDificultad(nivel)+".");
			System.out.println("Tu inteligencia es de: "+jug.getInteligencia());
		} 
		else if (e instanceof Trampa) {
			System.out.println("Su poder es de "+e.calcularDificultad(nivel)+".");
			System.out.println("Tu agilidad es de: "+jug.getAgilidad());
		}
		else {
			jefe = (Jefe) e;
			System.out.println("Su fuerza es de "+jefe.calcularDificultadFuerza(nivel)+".");
			System.out.println("Su inteligencia es de "+jefe.calcularDificultadInteligencia(nivel)+".");
			System.out.println("Su agilidad es de "+jefe.calcularDificultadAgilidad(nivel)+".");
			System.out.println("y parece que tiene un as bajo la manga...");
			//-- cambiar a todas las estadisticas y a "comentario del jefe"
		}
		
		System.out.println("Pulsa intro para realizar combate.");
		sc.nextLine();
		
	}
	
	
	/*
	 * calcularVictoria
	 * 
	 * Este método calculará el resultado del enfrentamiento
	 * del jugador con un evento. En función del evento se
	 * tendrán en cuenta distintos parametros del jugador.
	 * 
	 * precondiciones: el jugador y el evento no pueden tener valores nulos, 
	 * el caracter de fase jefe debe ser uno de los siguientes: 
	 * 		f: fuerza
	 * 		i: inteligencia
	 * 		a: agilidad
	 * 		d: destreza
	 * 		n: ninguno
	 * 		
	 * entradas: un jugador, un evento, nivel actual (int),
	 * 		fase de Jefe (caracter)
	 * salidas resultado (int)
	 * E/S: no hay
	 * postcondiciones: el método devolverá el resultado
	 * con un entero indicando lo siguiente:
	 * 		-1 : el jugador no logra pasar el evento.
	 * 		 0 : el jugador logra pasar el evento con suerte
	 * 		 1 el jugador logra pasar el evento sobradamente
	 * 
	 */
	
	public int calcularVictoria(Jugador jug, Evento e, int nivel, char faseJefe) {
		
		int vence = -1;
		Random rm = new Random();
		Jefe jefe = null;
		
		if (e instanceof Monstruo) {
			if (e.calcularDificultad(nivel) < jug.getFuerza()) vence = 1;
			else if (rm.nextInt(e.calcularDificultad(nivel)+1) < jug.getFuerza()) vence = 0;
		}
		else if (e instanceof Puzzle) {
			if (e.calcularDificultad(nivel) < jug.getInteligencia()) vence = 1;
			else if (rm.nextInt(e.calcularDificultad(nivel)+1) < jug.getInteligencia()) vence = 0;
		} 
		else if (e instanceof Trampa) {
			if (e.calcularDificultad(nivel) < jug.getAgilidad()) vence = 1;
			else if (rm.nextInt(e.calcularDificultad(nivel)+1) < jug.getAgilidad()) vence = 0;
		}
		else {
			jefe = (Jefe) e;
			
			switch (faseJefe) {
			
				case 'f': 
					
					if (jefe.calcularDificultadFuerza(nivel) < jug.getFuerza()) vence = 1;
					else if (rm.nextInt(jefe.calcularDificultadFuerza(nivel)+1) < jug.getFuerza()) vence = 0;
					
				break;
				
				case 'i': 
					
					if (jefe.calcularDificultadInteligencia(nivel) < jug.getInteligencia()) vence = 1;
					else if (rm.nextInt(jefe.calcularDificultadInteligencia(nivel)+1) < jug.getInteligencia()) vence = 0;
					
				break;
				
				case 'a': 
					
					if (jefe.calcularDificultadAgilidad(nivel) < jug.getAgilidad()) vence = 1;
					else if (rm.nextInt(jefe.calcularDificultadAgilidad(nivel)+1) < jug.getAgilidad()) vence = 0;
					
				break;
				
				case 'd': 
					
					if (jefe.calcularDificultad(nivel)  < jug.getDestreza()) vence = 1;
					
				break;
			
			}
			
		}
		
		return vence;
	}
	
	/*
	 * pintarResultadoCombate
	 * 
	 * este método pintará por pantalla el resultado
	 * del encuentro con un evento del jugador a partir
	 * de un valor entero.
	 * 
	 * precondiciones: entero debe tener valores -1, 0 o 1
	 * entrada: resultado (int)
	 * salidas: no hay.
	 * e/s: no hay.
	 * 
	 */
	
	public void pintarResultadoCombate(int resultado) {
		
		Scanner sc = new Scanner(System.in);
		
		switch (resultado) {
			case -1:
				System.out.println("No tenías posibilidad alguna.");
			break;
			
			case 0:
				System.out.println("Con un poco de maña, lo pudiste contar.");
			break;
				
			case 1:
				System.out.println("No podía hacer nada contra ti.");
			break;
		
		}
		
		System.out.println("Pulsa intro para continuar.");
		sc.nextLine();
	
		
	}
	
	/*
	 * pintarResultadoCombateJefe
	 * 
	 * este método pintará por pantalla el resultado
	 * de los encuentros con un jefe.
	 * 
	 * precondiciones: 
	 * 		el resultado debe tener valores -1, 0 o 1
	 * 		la fase de batalla debe tener valores de entre 1 y 4
	 * entrada: resultado (int), faseBatalla (int)
	 * salidas: no hay.
	 * e/s: no hay.
	 * 
	 */
	
	public void pintarResultadoCombateJefe(int resultado, int faseCombate) {
		
		Scanner sc = new Scanner(System.in);
		
		switch (faseCombate) {
		
			case 1:
				switch (resultado) {
					case -1: System.out.println("Te ha aplastado cruelmente."); break;
					case 0: System.out.println("Consigues resistir su golpe a duras penas."); break;
					case 1: System.out.println("Resistes su golpe con firmeza."); break;
				}
			break;
			
			case 2:
				switch (resultado) {
					case -1: System.out.println("No lo has logrado. En un descuido te ha aplastado."); break;
					case 0: System.out.println("Crees haberlo encontrado."); break;
					case 1: System.out.println("Lo has encontrado."); break;
				}
			break;
		
			case 3:
				switch (resultado) {
					case -1: System.out.println("Pero tus reflejos te fallaron :("); break;
					case 0: System.out.println("Su arma te roza la cara."); break;
					case 1: System.out.println("Te burlas en su cara mientras lo esquivas."); break;
				}
			break;
			
			case 4:
				switch (resultado) {
					case -1: System.out.println("Esta vez no pudiste hacer nada. Te ha derrotado."); break;
					case 1: System.out.println("Consigues asestarle el golpe final, ¡Bien hecho!"); break;
				}
			break;
		}
		
		
		System.out.println("Pulsa intro para continuar.");
		sc.nextLine();
	
		
	}
	
}
