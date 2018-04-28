package test;
 
import clases.Monstruo;
import excepciones.ExcepcionMonstruo;

public class TestMonstruo {

	public static void main(String[] args) {
		
		Monstruo m1 = new Monstruo();
		Monstruo m2 = new Monstruo("Murciélago", 2);
		Monstruo m3 = new Monstruo(m2);
		
		System.out.println("Monstruo 1 creado por defecto");
		System.out.println(m1.toString());
		
		System.out.println("Monstruo 2 creado con valores");
		System.out.println(m2.toString());
		
		System.out.println("Monstruo 3 con constructor de copia de monstruo 2");
		System.out.println(m3.toString());

		System.out.println("Cambio de variables al monstruo 3:");
		m3.setNombre("Zombie común");
		try {
			m3.setPoder(-10);
		} catch (ExcepcionMonstruo e) {}
		try {
			m3.setPoder(0);
		} catch (ExcepcionMonstruo e) {}
		try {
			m3.setPoder(10);
		} catch (ExcepcionMonstruo e) {}
		System.out.println(m3.toString());
		
		
		System.out.println("Recompensas aleatorias del monstruo 3");
		System.out.println(m3.generarRecompensaDeOro());
		System.out.println(m3.generarRecompensaDeOro());
		System.out.println(m3.generarRecompensaDeOro());
		System.out.println(m3.generarRecompensaDeOro());
		
		System.out.println("Comparación de monstruo 2 con el resto de monstruos");
		System.out.println(m2.compareTo(m1));
		System.out.println(m2.compareTo(m2));
		System.out.println(m2.compareTo(m3));
		
		System.out.println("Igualdad de monstruo 2 con el resto de monstruos");
		System.out.println(m2.equals(m1));
		System.out.println(m2.equals(m2));
		System.out.println(m2.equals(m3));
		
		System.out.println("HashCodes de todos los monstruos");
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
	}

}
