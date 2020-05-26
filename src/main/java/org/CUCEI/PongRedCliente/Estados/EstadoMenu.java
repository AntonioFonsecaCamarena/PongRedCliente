package org.CUCEI.PongRedCliente.Estados;

import java.util.ArrayList;

import org.CUCEI.PongRedCliente.ContenedorDelJuego;
import org.CUCEI.PongRedCliente.Objetos.BotonJugador;
import org.CUCEI.PongRedCliente.Objetos.ObjetoDelJuego;

import com.majoolwip.engine.Renderer;
import com.majoolwip.engine.util.State;

import lombok.Getter;

public class EstadoMenu extends State {
	@Getter
	private ArrayList<ObjetoDelJuego> listaObjetos = new ArrayList<ObjetoDelJuego>();
	private ContenedorDelJuego juego;
	BotonJugador btnJ1, btnJ2;

	public EstadoMenu(ContenedorDelJuego juego) {
		this.juego = juego;
		btnJ1 = new BotonJugador(1, 8, "Jugador1");
		btnJ2 = new BotonJugador(10, 8, "Jugador2");
		listaObjetos.add(btnJ1);
		listaObjetos.add(btnJ2);

	}

	@Override
	public void update(float dt) {
		for (ObjetoDelJuego objeto : listaObjetos) {
			objeto.update(juego, dt);
		}
		if (juego.getInput().isButton(1) && juego.getInput().getMouseX() > btnJ1.getPosicionX()
				&& juego.getInput().getMouseX() < btnJ2.getPosicionX())
			juego.setState(new EstadoBeta(juego, 1));
		if (juego.getInput().isButton(1) && juego.getInput().getMouseX() > btnJ1.getPosicionX()
				&& juego.getInput().getMouseX() > btnJ2.getPosicionX())
			juego.setState(new EstadoBeta(juego, 2));

	}

	@Override
	public void render(Renderer r) {
		for (ObjetoDelJuego objeto : listaObjetos) {
			objeto.render(juego, r);
		}
	}
}
