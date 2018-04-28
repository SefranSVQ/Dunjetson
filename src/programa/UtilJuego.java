package programa;

public class UtilJuego {

	/*
	 * pararTiempo
	 * 
	 * Este método permite parar el tiempo del hilo.
	 * Precondiciones: ninguna
	 * Entradas: entero (milisegundos)
	 * salida: no hay.
	 * E/S: no hay
	 * Postcondiciones: el hilo se habrá parado el número
	 * 	de milisegundos pasados en el parámetro de entrada.
	 * 
	 * 	Si la entrada de milisegundos es un numero negativo,
	 * 	el hilo no se parará
	 * 
	 */
	
	public static void pararTiempo(int milisegundos) {
		
		if (milisegundos < 0) milisegundos = 0;
		
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {}
		
	}
	
	/*
	 * limpiarPantalla
	 * 
	 * Este método pasará un número de lineas en la consola
	 * para limpiar los mensajes anteriores.
	 * 
	 * precondiciones: ninguna
	 * entradas: int (lineas a saltar)
	 * salidas: no hay
	 * e/s: no hay
	 * Portcondiciones: se habrán pintado por pantalla
	 * 	el número indicado de lineas pasadas en la entrada.
	 * 
	 * 	si el número es negativo, no se pasará ninguna.
	 * 
	 * 
	 */
	
public static void limpiarPantalla(int lineas) {
		
		if (lineas < 0) lineas = 0;
		
		for (int i = 0 ; i < lineas ; i++) {
			System.out.println(" ");
		}
		
	}
	
}
