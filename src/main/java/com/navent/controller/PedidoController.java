package com.navent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navent.service.PedidoService;
import com.navent.web.RequestNT;
import com.navent.web.ResponseNT;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	/**
	 * REST web service que crea un pedido
	 * 
	 * @throws Exception 
	 */
	@RequestMapping ( method = RequestMethod.POST, 
						value= "/crear" ,
						consumes =  { MediaType.APPLICATION_JSON_VALUE },
						produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<Object> crear( @RequestBody(required = false) RequestNT requestNT ) throws Exception {
		ResponseNT responseNT = new ResponseNT();
	
		responseNT = pedidoService.crearPedido( requestNT );
		
		return new ResponseEntity<Object>( responseNT, HttpStatus.OK );
	}
	
	/**
	 * REST web service que modifica un pedido
	 * 
	 * @throws Exception 
	 */
	@RequestMapping ( method = RequestMethod.POST, 
						value= "/modificar" ,
						consumes =  { MediaType.APPLICATION_JSON_VALUE },
						produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<Object> modificar( @RequestBody(required = false) RequestNT requestNT ) throws Exception {
		ResponseNT responseNT = new ResponseNT();
	
		responseNT = pedidoService.modificarPedido( requestNT );
		
		return new ResponseEntity<Object>( responseNT, HttpStatus.OK );
	}
	
	/**
	 * REST web service que busca un pedido
	 * 
	 * @throws Exception 
	 */
	@RequestMapping ( method = RequestMethod.POST, 
						value= "/buscar" ,
						consumes =  { MediaType.APPLICATION_JSON_VALUE },
						produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<Object> buscar( @RequestBody(required = false) RequestNT requestNT ) throws Exception {
		ResponseNT responseNT = new ResponseNT();
	
		responseNT = pedidoService.buscarPedido( requestNT );
		
		return new ResponseEntity<Object>( responseNT, HttpStatus.OK );
	}
	
	/**
	 * REST web service que elimina un pedido
	 * 
	 * @throws Exception 
	 */
	@RequestMapping ( method = RequestMethod.POST, 
						value= "/eliminar" ,
						consumes =  { MediaType.APPLICATION_JSON_VALUE },
						produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<Object> eliminar( @RequestBody(required = false) RequestNT requestNT ) throws Exception {
		ResponseNT responseNT = new ResponseNT();
	
		responseNT = pedidoService.eliminarPedido( requestNT );
		
		return new ResponseEntity<Object>( responseNT, HttpStatus.OK );
	}
	
}
	
