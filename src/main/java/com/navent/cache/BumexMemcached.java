package com.navent.cache;

import com.navent.model.Pedido;

public class BumexMemcached {
	static public void set(String key, Pedido value) {
		// acceder a DAO si es necesario
	}
	static public Pedido get(String key) {
		// obetener objeto de DAO si es necesario
		return new Pedido();
	}
	static public void delete(String key) {
		// acceder a DAO si es necesario
	}
}
