package test;

import clases.Clase;
 
public class TestClase {

	public static void main(String[] args) {
		
		Clase Tidus = Clase.GUERRERO;
		Clase Vivi = Clase.MAGO;
		Clase Vaan = Clase.LADRON;
		Clase Cid = Clase.COMERCIANTE;
		Clase Mog = Clase.NINGUNA;
		
		System.out.println("Test de la clase enumerada \"Clase\"");
		
		System.out.println("\nTidus: "+ Tidus.name()+","+Tidus.toString()+","+Tidus.ordinal());
		System.out.println("Vivi: "+ Vivi.name()+","+Vivi.toString()+","+Vivi.ordinal());
		System.out.println("Vaan: "+ Vaan.name()+","+Vaan.toString()+","+Vaan.ordinal());
		System.out.println("Cid: "+ Cid.name()+","+Cid.toString()+","+Cid.ordinal());
		System.out.println("Mog: "+ Mog.name()+","+Mog.toString()+","+Mog.ordinal());
		
		System.out.println("\nComparaciones");
		
		System.out.println("Vaan con Vivi: "+Vaan.compareTo(Vivi));
		System.out.println("Vaan con Vaan: "+Vaan.compareTo(Vaan));
		System.out.println("Vaan con Mog: "+Vaan.compareTo(Mog));
		
		
		

	}

}
