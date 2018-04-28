package test;

import clases.Jefe;
import excepciones.ExcepcionJefe;
import excepciones.ExcepcionMonstruo;
 
public class TestJefe {

	public static void main(String[] args) {
	
		Jefe j1 = new Jefe();
		Jefe j2 = new Jefe("Troll",15,3,8,5);
		Jefe j3 = new Jefe(j2);
		
		System.out.println("Jefe 1, constructor por defecto.");
		System.out.println(j1.toString());
		System.out.println("\nJefe 2, constructor con valores");
		System.out.println(j2.toString());
		System.out.println("\nJefe 3, constructor de copia con jefe 2");
		System.out.println(j3.toString());
		
		System.out.println("\nCambio de valores de jefe 3");
		j3.setNombre("Faraon");
		
		try {
			j3.setPoder(30);
		} catch (ExcepcionMonstruo e3) {}
		
		try {
			j3.setInteligencia(-40);
		} catch (ExcepcionJefe e2) {}
		try {
			j3.setInteligencia(40);
		} catch (ExcepcionJefe e2) {}
		
		try {
			j3.setAgilidad(-10);
		} catch (ExcepcionJefe e1) {}
		try {
			j3.setAgilidad(10);
		} catch (ExcepcionJefe e1) {}
		
		try {
			j3.setBonusDestreza(-25);
		} catch (ExcepcionJefe e) {}
		try {
			j3.setBonusDestreza(25);
		} catch (ExcepcionJefe e) {}
		
		System.out.println(j3.toString());
		
		System.out.println("\nDestreza: suma de todos los atributos de cada jefe junto con su bonus de destreza.");
		System.out.println(j1.getDestreza());
		System.out.println(j2.getDestreza());
		System.out.println(j3.getDestreza());
		
		System.out.println("\nRecompensas aleatorias del Jefe 3");
		System.out.println(j3.generarRecompensaDeOro());
		System.out.println(j3.generarRecompensaDeOro());
		System.out.println(j3.generarRecompensaDeOro());
		System.out.println(j3.generarRecompensaDeOro());
		
		System.out.println("\nComparación de jefe 2 con el resto de jefes");
		System.out.println(j2.compareTo(j1));
		System.out.println(j2.compareTo(j2));
		System.out.println(j2.compareTo(j3));
		
		System.out.println("\nIgualdad de jefe 2 con el resto de jefes");
		System.out.println(j2.equals(j1));
		System.out.println(j2.equals(j2));
		System.out.println(j2.equals(j3));
		
		System.out.println("\nHashCodes de todos los jefes");
		System.out.println(j1.hashCode());
		System.out.println(j2.hashCode());
		System.out.println(j3.hashCode());
		
	}

}
