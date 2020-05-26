package org.CUCEI.PongRedCliente.Estados;

import java.util.ArrayList;
import java.util.Random;

import org.CUCEI.PongRedCliente.ContenedorDelJuego;
import org.CUCEI.PongRedCliente.ConectividadRed.Cliente;
//import org.CUCEI.PongRedCliente.Objetos.ObjetoDelJuego;
import org.CUCEI.PongRedServer.Estado;
import org.CUCEI.PongRedServer.Objetos.ObjetoDelJuego;

import com.majoolwip.engine.Renderer;
import com.majoolwip.engine.util.State;

import lombok.Getter;

public class EstadoBeta extends State {
	/**
	 * Es la lista de objetos que interactuaran en el render.
	 */
	@Getter
	private ArrayList<ObjetoDelJuego> listaObjetos = new ArrayList<ObjetoDelJuego>();
	private ContenedorDelJuego juego;
	Cliente cliente;
	Estado estado;
	@Getter
	int jugador;

	public EstadoBeta(ContenedorDelJuego juego, int jugador) {
		this.juego = juego;
		cliente = new Cliente("127.0.0.1", 5000, jugador);
		estado = cliente.getEstado();
		listaObjetos.add(estado.getBola());
		listaObjetos.add(estado.getJugador1());
		listaObjetos.add(estado.getJugador2());
		this.jugador = jugador;
	}

	@Override
	public void update(float dt) {
		estado = cliente.getEstado();
		if (estado != null) {
			estado.setJugador(jugador);
			if (jugador == 1) {
				estado.getJugador1().setPosicionY(juego.getInput().getMouseY());
				if (estado.getBola().estaTocando(estado.getJugador1())) {
					estado.getBola().setVelocidadX(-calculaVelocidad(estado.getBola().getVelocidadX()));
					estado.getBola().setVelocidadY(calculaVelocidadAleatoria());
				}
				if (estado.getBola().estaTocando(estado.getJugador2())) {
					estado.getBola().setVelocidadX(calculaVelocidad(estado.getBola().getVelocidadX()));
					estado.getBola().setVelocidadY(calculaVelocidadAleatoria());
				}
				estado.getBola().update(juego, dt);
			} else {
				estado.getJugador2().setPosicionY(juego.getInput().getMouseY());
			}
			cliente.update(estado);
		}

	}

	private float calculaVelocidad(float velocidad) {
		if (velocidad > 0)
			return -(velocidad + (int) (Math.random() * ((10 - 5) + 1)));
		return (velocidad - (int) (Math.random() * ((10 - 5) + 1)));
	}

	private float calculaVelocidadAleatoria() {
		Random random = new Random();
		return (float) (random.nextInt(30 + 30) - 30);
	}

	@Override
	public void render(Renderer r) {
		estado.getJugador1().render(juego, r);
		estado.getJugador2().render(juego, r);
		estado.getBola().render(juego, r);

	}

}
