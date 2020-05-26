package org.CUCEI.PongRedCliente;

import com.majoolwip.engine.Pix;
import com.majoolwip.engine.util.PixSettings;

/**
 * Clase principal del Juego, que contiene el metodo Main. Esta clase extiende
 * la interfaz abstracta com.majoolwip.engine.game para ser usada con el
 * proyecto PixEngine de Ryan Moore.
 * 
 * @see https://github.com/Majoolwip/PixEngine Cuenta con una serie de Videos
 *      explicando el desarrollo del motor grafico.
 */
public class App {

	public static void main(String[] args) {
		try {
			System.out.println("1");
			ContenedorDelJuego juego = new ContenedorDelJuego();
			System.out.println("2");
			PixSettings settings = new PixSettings();
			System.out.println("3");
			Pix pix = new Pix(juego, settings);
			System.out.println("raro 4");
			pix.start();
			System.out.println("5=?");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
