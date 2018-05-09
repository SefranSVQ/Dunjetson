package programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import clases.Clase;
import clases.Jugador;

public class GestoraFichero {

	/*
	 * reiniciarPartidas
	 * 
	 * Este método reinicia todas las partidas del fichero save.txt.
	 * Sin entradas / salidas.
	 * 
	 */
	
	public static void reiniciarPartidas() {
		
		File save = new File("src/archivos/save.txt");
		BufferedWriter bw = null;
		Jugador nuevo = new Jugador();
		
		try {
			bw = new BufferedWriter(new FileWriter(save));
		} catch (IOException e1) {}
		
		for (int i = 0 ; i < 5 ; i++) {
			if (i == 0) {
				try {
					bw.write("Salir.");
					bw.newLine();
				} catch (IOException e) {}
				
			}
			else {
				try {
					
					bw.write(nuevo.toString());
					bw.newLine();
				} catch (IOException e) {}
				
			}
			
		}
		
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {}
	}
	
	
	/*
	 * guardarPartidasEnArray
	 * 
	 * este método guarda las partidas almacenadas
	 * en el fichero "save.txt" en un array 
	 * para un tratamiento más cómodo.
	 * 
	 * Entradas: el array donde se guardará
	 * Salidas: no hay
	 * E/S: no hay
	 * 
	 */
	
	public static void guardarPartidasEnArray(String[] partidas) {
		
		BufferedReader br = null;
		File save = new File("src/archivos/save.txt");
		
		try {
			br = new BufferedReader(new FileReader(save));
		} catch (FileNotFoundException e1) {}
		
		for (int i = 0 ; i < partidas.length ; i++) {
			
			try {
				partidas[i] = br.readLine();
			} catch (IOException e) {}
		
		}
		
		try {
			br.close();
		} catch (IOException e1) {}
		
	}
	
	/*
	 * pintarPartidasGuardadas
	 * 
	 * Este método pintará por pantalla las partidas 
	 * guardadas en el fichero save.txt.
	 * 
	 * Entradas: nada
	 * Salidas: nada
	 * E/S: nada
	 * 
	 */
	
	public static void pintarPartidasGuardadas() {
		
		Jugador j = null;
		
		System.out.println("\t0 - Salir\n");
		for(int i = 1 ; i < 5 ; i++) {
			System.out.println("\t"+i+" - Partida "+i);
			j = cargarJugador(i);
			j.pintarEstadisticas();
		}
		
		
	}
	
	/*
	 * guardarJugadorEnPosicion
	 * 
	 * este método guardará un jugador en la posición
	 * indicada del fichero save.txt
	 * 
	 * precondiciones: la posicion debe ser un valor entre 1 y 4
	 * Entradas: jugador (Jugador), posicion (int)
	 * salidas: no hay
	 * E/S: no hay
	 * 
	 */
	
	public static void guardarJugadorEnPosicion(Jugador jugador, int posicion) {
		
		File save = new File("src/archivos/save.txt");
		BufferedWriter bw = null;
		String[] partidas = new String[5];
		guardarPartidasEnArray(partidas);
		
		try {
			bw = new BufferedWriter(new FileWriter(save));
		} catch (IOException e1) {}
		
		for (int i = 0 ; i < 5 ; i++) {
			
			if (i == posicion) {
	
				try {				
					bw.write(jugador.toString());
					bw.newLine();
				} catch (IOException e) {}
				
			} 
			else {
				
				try {
					bw.write(partidas[i]);
					bw.newLine();
				} catch (IOException e1) {}
				
			}
			
		}
		
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {}
		
	}
	
	/*
	 * cargarJugador
	 * 
	 * este método devolverá el jugador guardado en la posición 
	 * indicada dentro del fichero save.txt
	 * 
	 * precondiciones: la posición debe ser un valor entre 1 y 4
	 * entrada: posicion de guardado (int)
	 * salida: un objeto jugador
	 * E/S: no hay
	 * 
	 */
	
	public static Jugador cargarJugador(int posicion) {
		
		BufferedReader br = null;
		File save = new File("src/archivos/save.txt");
		Jugador jug = null;
		String cadena = " ";
		String[] parametros = new String[7];
		boolean leido = false;
		
		try {
			br = new BufferedReader(new FileReader(save));
		} catch (FileNotFoundException e1) {}
		
		for (int i = 0 ; i < 5 && leido == false; i++) {
			
			if (i == posicion) {
				try {
					cadena = br.readLine();
					leido = true;
				} catch (IOException e) {}
			}
			else {
				try {
					br.readLine();
				} catch (IOException e) {}
			}
		
		}
		
		parametros = cadena.split(",");
		
		jug = new Jugador(parametros[0], Clase.valueOf(parametros[1]) ,Integer.parseInt(parametros[2]),
				Integer.parseInt(parametros[3]),Integer.parseInt(parametros[4]),
				Integer.parseInt(parametros[5]),Integer.parseInt(parametros[6]));
		
		try {
			br.close();
		} catch (IOException e1) {}
		
		return jug;
		
	}
	
	/*
	 * sobreescribirPartida
	 * 
	 * este método sobreescribirá una partida sobre otra
	 * en el fichero save.txt.
	 * 
	 * Precondiciones: ambas posiciones de partidas deben 
	 * 	ser valores entre 1 y 4.
	 * entradas: posicionInicial, posicionDestino
	 * salidas: no hay
	 * E/S: no hay
	 * 
	 */
	
	public static void sobreescribirPartida(int posInicial, int posDestino) {
		
		File save = new File("src/archivos/save.txt");
		BufferedWriter bw = null;
		String[] partidas = new String[5];
		guardarPartidasEnArray(partidas);
		
		try {
			bw = new BufferedWriter(new FileWriter(save));
		} catch (IOException e1) {}
		
		for (int i = 0 ; i < 5 ; i++) {
			
			if (i == posDestino) {
	
				try {				
					bw.write(partidas[posInicial]);
					bw.newLine();
				} catch (IOException e) {}
				
			} 
			else {
				
				try {
					bw.write(partidas[i]);
					bw.newLine();
				} catch (IOException e1) {}
				
			}
			
		}
		
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {}
		
		
	}
	
}
