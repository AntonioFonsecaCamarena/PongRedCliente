package org.CUCEI.PongRedCliente.ConectividadRed;

import java.io.IOException;

import org.CUCEI.PongRedServer.Estado;
import org.CUCEI.PongRedServer.Objetos.Bola;
import org.CUCEI.PongRedServer.Objetos.Jugador;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import lombok.Getter;

public class Cliente {

	Client client;
	@Getter
	Estado estado = null;

	public Cliente(String address, int port, int jugador) {
		try {
			client = new Client();
			client.start();
			client.connect(5000, client.discoverHost(54777, 5000), 54555, 54777);
			estado = new Estado(jugador);
			Kryo kryo = client.getKryo();
			kryo.register(Estado.class);
			kryo.register(Bola.class);
			kryo.register(Jugador.class);
			client.addListener(new Listener() {
				public void received(Connection connection, Object object) {
					if (object instanceof Estado) {
						Estado response = (Estado) object;
						estado = response;
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(Estado estado) {
		client.sendTCP(estado);
	}

}
