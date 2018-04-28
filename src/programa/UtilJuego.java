package programa;

public class UtilJuego {

	/*
	 * pararTiempo
	 * 
	 * Este m�todo permite parar el tiempo del hilo.
	 * Precondiciones: ninguna
	 * Entradas: entero (milisegundos)
	 * salida: no hay.
	 * E/S: no hay
	 * Postcondiciones: el hilo se habr� parado el n�mero
	 * 	de milisegundos pasados en el par�metro de entrada.
	 * 
	 * 	Si la entrada de milisegundos es un numero negativo,
	 * 	el hilo no se parar�
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
	 * Este m�todo pasar� un n�mero de lineas en la consola
	 * para limpiar los mensajes anteriores.
	 * 
	 * precondiciones: ninguna
	 * entradas: int (lineas a saltar)
	 * salidas: no hay
	 * e/s: no hay
	 * Portcondiciones: se habr�n pintado por pantalla
	 * 	el n�mero indicado de lineas pasadas en la entrada.
	 * 
	 * 	si el n�mero es negativo, no se pasar� ninguna.
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
