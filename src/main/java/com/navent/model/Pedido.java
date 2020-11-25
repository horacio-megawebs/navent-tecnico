package com.navent.model;

public class Pedido {

		private Integer idPedido;
		private String nombre;
		private String monto;
		private String descuento;
		
		public Integer getIdPedido() {
			return idPedido;
		}
		public void setIdPedido(Integer idPedido) {
			this.idPedido = idPedido;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getMonto() {
			return monto;
		}
		public void setMonto(String monto) {
			this.monto = monto;
		}
		public String getDescuento() {
			return descuento;
		}
		public void setDescuento(String descuento) {
			this.descuento = descuento;
		}
		
		@Override
		public String toString() {
			return "Pedido [idPedido=" + idPedido + ", nombre=" + nombre + ", monto=" + monto + ", descuento="
					+ descuento + "]";
		}
		
}
