package org.CUCEI.PongRedCliente.Objetos;

import org.CUCEI.PongRedCliente.ContenedorDelJuego;

import com.majoolwip.engine.Renderer;
import com.majoolwip.engine.gfx.PixImage;

public class BotonJugador extends ObjetoDelJuego {

	// Porpiedades del Jugador
	ContenedorDelJuego juego;

	public BotonJugador (float posicionX, float posicionY, String nombre) {
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
		r.draw2DImage((int) getPosicionX(), (int) getPosicionY(), new PixImage("/img/"+getNombre()+".png"));
	}




}
