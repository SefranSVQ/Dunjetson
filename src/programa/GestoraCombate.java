package programa;

import java.util.Random;

import clases.*;

public class GestoraCombate {

	/*
	 * calcularVictoria
	 * 
	 * Este método calculará el resultado del enfrentamiento
	 * del jugador con un evento. En función del evento se
	 * tendrán en cuenta distintos parametros.
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
	
	public int calcularVictoria(Jugador j, Evento e, int nivel, char faseJefe) {
		
		int vence = -1;
		Random rm = new Random();
		Jefe jefe = null;
		
		if (e instanceof Monstruo) {
			if (e.calcularDificultad(nivel) < j.getFuerza()) vence = 1;
			else if (rm.nextInt(e.calcularDificultad(nivel)) < j.getFuerza()) vence = 0;
		}
		else if (e instanceof Puzzle) {
			if (e.calcularDificultad(nivel) < j.getInteligencia()) vence = 1;
			else if (rm.nextInt(e.calcularDificultad(nivel)) < j.getInteligencia()) vence = 0;
		} 
		else if (e instanceof Trampa) {
			if (e.calcularDificultad(nivel) < j.getAgilidad()) vence = 1;
			else if (rm.nextInt(e.calcularDificultad(nivel)) < j.getAgilidad()) vence = 0;
		}
		else {
			jefe = (Jefe) e;
			
			switch (faseJefe) {
			
				case 'f': 
					
					if (jefe.calcularDificultadFuerza(nivel) < j.getFuerza()) vence = 1;
					else if (rm.nextInt(jefe.calcularDificultadFuerza(nivel)) < j.getFuerza()) vence = 0;
					
				break;
				
				case 'i': 
					
					if (jefe.calcularDificultadInteligencia(nivel) < j.getInteligencia()) vence = 1;
					else if (rm.nextInt(jefe.calcularDificultadInteligencia(nivel)) < j.getInteligencia()) vence = 0;
					
				break;
				
				case 'a': 
					
					if (jefe.getAgilidad() < j.getAgilidad()) vence = 1;
					else if (rm.nextInt(jefe.getAgilidad()) < j.getAgilidad()) vence = 0;
					
				break;
				
				case 'd': 
					
					if (jefe.getDestreza() < j.getDestreza()) vence = 1;
					
				break;
			
			}
			if (jefe.getDestreza() < j.getDestreza()) vence = 1;
			
		}
		
		return vence;
	}
	
	
}
