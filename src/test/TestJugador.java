package test;
 
import clases.Clase;
import clases.Jugador;
import excepciones.ExcepcionJugador;

public class TestJugador {

	public static void main(String[] args) {
		
		//Variables de jugadores.
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador("CaptainCub", Clase.GUERRERO, 10, 3, 5, 25, 0);
		Jugador j3 = new Jugador(j1);
		Jugador j4 = j1.clone();
		
		//Muestra de variables de los jugadores.
		System.out.println("Defecto: "+j1.toString());
		System.out.println("Con parametros: "+j2.toString());
		System.out.println("Copia: "+j3.toString());
		System.out.println("Clone: "+j4.toString());
		
			//Setters
		
		//No correcto
		System.out.println("Valores incorrectos:");
		try {
			j3.setNick("Misterioso M. Rajoy");		
		} catch (ExcepcionJugador e) {}
		
		j3.setClase(Clase.LADRON);
		
		try {
			j3.setFuerza(0);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setInteligencia(-100);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setAgilidad(0);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setOro(-20);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setMazmorrasCompletadas(-10);
		} catch (ExcepcionJugador e) {};
		
		//Correcto
		
		System.out.println("Valores correctos:");
		try {
			j3.setNick("Jolsensei");	
		} catch (ExcepcionJugador e) {}
		
		j3.setClase(Clase.MAGO);
		
		try {
			j3.setFuerza(3);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setInteligencia(10);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setAgilidad(5);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setOro(25);
		} catch (ExcepcionJugador e) {}
		
		try {
			j3.setMazmorrasCompletadas(0);
		} catch (ExcepcionJugador e) {};
				
		System.out.println("\n Nuevos valores:");
		System.out.println(j1.toString());
		System.out.println(j2.toString());
		System.out.println(j3.toString());
		
		System.out.println("\n Destreza:");
		System.out.println(j1.getDestreza());
		System.out.println(j2.getDestreza());
		System.out.println(j3.getDestreza());
		
		System.out.println("\n Modificamos las estadísticas del "
				+ "\njugador 1 con los métodos especiales:");
		System.out.println("Valor incorrecto en el oro:");
		
		try {
			j1.modificarOro(-1);
		} catch (ExcepcionJugador e) {}
		
		System.out.println("Valor correcto en el oro:");
		
		try {
			j1.modificarOro(1);
		} catch (ExcepcionJugador e) {}
		
		j1.modificarFuerza(7);
		j1.modificarInteligencia(7);
		j1.modificarAgilidad(7);
		
		System.out.println("Nuevas estadisticas del jugador 1:");
		System.out.println(j1.toString());
		
		j1.modificarFuerza(-77);
		j1.modificarInteligencia(-77);
		j1.modificarAgilidad(-77);
		
		System.out.println("Nuevas estadisticas del jugador 1 "
				+ "\ntras restarles numeros con resultados negativos:");
		System.out.println(j1.toString());
		
		System.out.println("\n igualdad entre el jugador 2 con los jugadores 1, 2 y 3:");
		System.out.println(j2.equals(j1));
		System.out.println(j2.equals(j2));
		System.out.println(j2.equals(j3));
		
		System.out.println("\n comparacion entre el jugador 2 con los jugadores 1, 2 y 3:");
		System.out.println(j2.compareTo(j1));
		System.out.println(j2.compareTo(j2));
		System.out.println(j2.compareTo(j3));
		
		System.out.println("\n hascodes:");
		System.out.println(j1.hashCode());
		System.out.println(j2.hashCode());
		System.out.println(j3.hashCode());
		
		
		
	}
}
