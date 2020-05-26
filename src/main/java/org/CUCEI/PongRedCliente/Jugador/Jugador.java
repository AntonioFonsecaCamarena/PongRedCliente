package org.CUCEI.PongRedCliente.Jugador;

import org.CUCEI.PongRedCliente.ContenedorDelJuego;
import org.CUCEI.PongRedCliente.Objetos.ObjetoDelJuego;

import com.majoolwip.engine.Renderer;

public class Jugador extends ObjetoDelJuego {

	// Porpiedades del Jugador

	public Jugador(float posicionX, float posicionY, String nombre) {
		this.setNombre(nombre);
		this.setPosicionX(posicionX * this.getTamanoTiles() + 8);
		this.setPosicionY(posicionY * this.getTamanoTiles() + 8);
		this.setAltura(this.getTamanoTiles() * 3);
		this.setAnchura(this.getTamanoTiles() * 3 / 5);
	}

	@Override
	public void update(ContenedorDelJuego juego, float dt) {
		
	}

	@Override
	public void render(ContenedorDelJuego juego, Renderer r) {
		r.draw2DRect((int) getPosicionX(), (int) getPosicionY(), getAnchura(), getAltura(), 0xFF00FF00);
	}

}
