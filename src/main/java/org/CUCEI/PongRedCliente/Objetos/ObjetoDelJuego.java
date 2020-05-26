package org.CUCEI.PongRedCliente.Objetos;

import org.CUCEI.PongRedCliente.ContenedorDelJuego;

import com.majoolwip.engine.Renderer;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase Abstracta que define las propiedades que deben de tener todos los
 * elementos en el juego.
 * 
 * @author Jose Antonio Fonseca
 *
 */

public abstract class ObjetoDelJuego {

	@Getter
	final int tamanoTiles = 16;
	@Getter
	@Setter
	private float velocidad = 1f;

	/**
	 * Nombre con el que identificaremos el objeto del juego.
	 */
	@Getter
	@Setter
	private String nombre;
	/**
	 * La coordenada X donde posicionaremos el objeto.
	 */
	@Getter
	@Setter
	private float posicionX, posicionY;

	/**
	 * Determinamos la altura y anchura del objeto.
	 */
	@Getter
	@Setter
	private int altura, anchura;
	/**
	 * Estado para considerarlo en el juego, si este se encuentra el false el
	 * elemento sera descartado.
	 */
	@Getter
	@Setter
	private boolean activo = true;
	/**
	 * Propiedad del objeto que hara colisionar con otros objetos solidos.
	 */
	@Getter
	@Setter
	private boolean solido;

	public abstract void update(ContenedorDelJuego juego, float dt);

	public abstract void render(ContenedorDelJuego juego, Renderer r);

	public boolean estaTocando(ObjetoDelJuego objeto) {
		if (enRangoY(objeto) && enRangoX(objeto)) {
			return true;
		}
		return false;
	}

	public boolean colisionaArriba(ObjetoDelJuego objeto) {
		if (getPosicionY() == (objeto.getPosicionY() + objeto.getAltura()) && enRangoX(objeto))
			return true;
		return false;
	}

	public boolean colisionaAbajo(ObjetoDelJuego objeto) {
		if ((getPosicionY() + getAltura()) == (objeto.getPosicionY()) && enRangoX(objeto))
			return true;
		return false;
	}

	public boolean colisionaIzquierda(ObjetoDelJuego objeto) {
		if (getPosicionX() == (objeto.getPosicionX() + objeto.getAnchura()) && enRangoY(objeto))
			return true;
		return false;
	}

	public boolean colisionaDerecha(ObjetoDelJuego objeto) {
		if ((getPosicionX() + getAnchura()) == (objeto.getPosicionX()) && enRangoY(objeto))
			return true;
		return false;
	}

	private boolean enRangoY(ObjetoDelJuego objeto) {
		if ((posicionY <= objeto.getPosicionY() + objeto.altura && posicionY >= objeto.getPosicionY())
				|| (posicionY + altura >= objeto.getPosicionY()
						&& posicionY + altura <= objeto.getPosicionY() + objeto.getAltura()))
			return true;
		return false;
	}

	private boolean enRangoX(ObjetoDelJuego objeto) {
		if ((posicionX <= objeto.getPosicionX() + objeto.getAnchura() && posicionX >= objeto.getPosicionX())
				|| (posicionX + anchura >= objeto.getPosicionX()
						&& posicionX + anchura <= objeto.getPosicionX() + objeto.getAnchura()))
			return true;
		return false;
	}

	public String toString() {
		return nombre + "(" + posicionX + "," + posicionY + ").";
	}
}
