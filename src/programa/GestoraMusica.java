package programa;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GestoraMusica {

	/*
	 * 
	 * iniciarMusicaPrincipal
	 * 
	 * este m�todo activa la m�sica del men� principal
	 * del juego.
	 * 
	 * entradas: no tiene
	 * salidas: clip
	 * E/S: no tiene
	 * 
	 * postcondicion: el m�todo devolver� el clip con la m�sica 
	 * del men� principal iniciada.
	 * 
	 */
	
	public static Clip iniciarMusicaPrincipal() {
		
		Clip musicaIntro = null;
		
		try {
			musicaIntro = AudioSystem.getClip();
			musicaIntro.open(AudioSystem.getAudioInputStream(new File("src/archivos/intro.wav")));
		} catch (LineUnavailableException e) {} catch (IOException e) {} 
		catch (UnsupportedAudioFileException e) {}
		musicaIntro.start();
		musicaIntro.loop(100);
		
		return musicaIntro;
		
	}
	
	/*
	 * 
	 * reiniciarMusicaPrincipal
	 * 
	 * este m�todo reinicia la m�sica del men� principal
	 * 
	 * entradas: clip
	 * salidas: no tiene
	 * e/s: no tiene
	 * 
	 * este m�todo habr� reiniciado el clip de 
	 * la m�sica del menu principal.
	 * 
	 */
	
	public static void reiniciarMusicaPrincipal(Clip musicaIntro) {
		
		musicaIntro.setMicrosecondPosition(0);
		musicaIntro.start();
		musicaIntro.loop(100);
		
	}
	
	/*
	 * 
	 * iniciarMusicaJuego
	 * 
	 * este m�todo activa la m�sica del juego
	 * 
	 * entradas: no tiene
	 * salidas: clip
	 * E/S: no tiene
	 * 
	 * postcondicion: el m�todo devolver� el clip con la m�sica 
	 * del juego
	 * 
	 */
	
	public static Clip iniciarMusicaJuego() {
		
		Clip musicaJuego = null;
		
		try {
			musicaJuego = AudioSystem.getClip();
			musicaJuego.open(AudioSystem.getAudioInputStream(new File("src/archivos/dungeon.wav")));
		} catch (LineUnavailableException e) {} catch (IOException e) {} 
		catch (UnsupportedAudioFileException e) {}
		musicaJuego.start();
		musicaJuego.loop(100);
		
		return musicaJuego;
		
	}
	
}
