package com.navent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navent.cache.BumexMemcached;
import com.navent.dao.PedidoDAO;
import com.navent.model.Pedido;
import com.navent.web.RequestNT;
import com.navent.web.ResponseNT;

@Service
public class PedidoService {

	// esto se puede pasar a un properties despues
	final String RESULTADO_OK = "OK";
	final String RESULTADO_ERROR = "ERROR";
	
	@Autowired
	PedidoDAO pedidoDao;
	
	public ResponseNT crearPedido(RequestNT requestPedido) {
		ResponseNT responseNT = new ResponseNT();
		Pedido pedido = new Pedido();
		pedido.setNombre( requestPedido.getNombre() );
		pedido.setMonto( requestPedido.getMonto() );
		pedido.setDescuento( requestPedido.getDescuento() );
		BumexMemcached.set( requestPedido.getIdPedido(), pedido);
		if( null != pedido.getIdPedido() ) {
			responseNT.setIdCliente( pedido.getIdPedido().toString() );
			responseNT.setResultado( RESULTADO_OK );
			responseNT.setMensaje("Cliente creado exitosamente");
		} else {
			responseNT.setResultado( RESULTADO_ERROR );
			responseNT.setMensaje( "Error al crear cliente");
		}
		responseNT.setNombre( pedido.getNombre() );
		return responseNT;
	}
	
	public ResponseNT modificarPedido(RequestNT requestPedido) {
		ResponseNT responseNT = new ResponseNT();
		Pedido pedido = null;
		pedido = BumexMemcached.get( requestPedido.getIdPedido() );
		if ( null != pedido ) {
			pedido.setIdPedido( Integer.valueOf( requestPedido.getIdPedido() ) );
			pedido.setNombre( requestPedido.getNombre() );
			pedido.setMonto( requestPedido.getMonto() );
			pedido.setDescuento( requestPedido.getDescuento() );
			BumexMemcached.set( requestPedido.getIdPedido(), pedido );
			// aca iria un condicional atrapando un error en el insertUpdate
			responseNT.setResultado( RESULTADO_OK );
			responseNT.setMensaje( "Pedido modificado correctamente");
		} else {
			responseNT.setResultado( RESULTADO_ERROR );
			responseNT.setMensaje( "Error al modificar pedido, no se encuentra" );
		}
		responseNT.setNombre( requestPedido.getNombre() );
		responseNT.setIdCliente( requestPedido.getIdPedido() );

		return responseNT;
	}
	
	public ResponseNT buscarPedido(RequestNT requestPedido) {
		ResponseNT responseNT = new ResponseNT();
		Pedido pedido = null;
		pedido = BumexMemcached.get( requestPedido.getIdPedido() );
		if( null != pedido ) {
			responseNT.setResultado( RESULTADO_OK);
			responseNT.setMensaje("Pedido encontrado");
		} else {
			responseNT.setResultado( RESULTADO_ERROR );
			responseNT.setMensaje("Error al buscar mensaje" );
		}
		responseNT.setNombre( requestPedido.getNombre() );
		responseNT.setIdCliente( requestPedido.getIdPedido() );

		return responseNT;
	}
	
	
	public ResponseNT eliminarPedido( RequestNT requestPedido ) {
		ResponseNT responseNT = new ResponseNT();
		Pedido pedido = null;
		responseNT = buscarPedido( requestPedido );
		if( null != responseNT.getResultado() && RESULTADO_OK.equals( responseNT.getResultado() )) {
			BumexMemcached.delete( requestPedido.getIdPedido() );
			responseNT.setResultado( RESULTADO_OK );
			responseNT.setMensaje( "Pedido eliminado correctamente");
		} else {
			responseNT.setResultado( RESULTADO_ERROR );
			responseNT.setMensaje( "No se encontro pedido a eliminar");
		}
		responseNT.setNombre( requestPedido.getNombre() );
		responseNT.setIdCliente( requestPedido.getIdPedido() );

		return responseNT;
	}
	
}
