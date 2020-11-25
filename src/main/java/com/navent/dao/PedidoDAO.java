package com.navent.dao;

import org.springframework.stereotype.Component;

import com.navent.controller.PedidoController;
import com.navent.model.Pedido;

@Component
public class PedidoDAO {
	
	// inserta un nuevo pedido en la base de datos modifica un pedido existente 
	// (en cado de crear uno nuevo, el pedido pasado como
	// parámetro se completa con el nuevo id). 
	public void insertOrUpdate(Pedido pedido) {
	}
	
	// elimina el pedido que corresponde al id recibido.
	public void delete(Pedido pedido) {};
	
	// busca un pedido por id.
	public Pedido select(Integer idPedido) { return new Pedido();}; 
}
