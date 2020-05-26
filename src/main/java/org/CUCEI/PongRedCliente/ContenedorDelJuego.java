package org.CUCEI.PongRedCliente;

import org.CUCEI.PongRedCliente.Estados.EstadoMenu;

import com.majoolwip.engine.Game;
import com.majoolwip.engine.Input;

import lombok.Getter;
import lombok.Setter;

public class ContenedorDelJuego extends Game {

	@Getter
	@Setter
	private Input input;

	@Override
	public void init(Input input) {
		this.setState(new EstadoMenu(this));
		this.input = input;
	}

	@Override
	public void dispose() {
	}

}
