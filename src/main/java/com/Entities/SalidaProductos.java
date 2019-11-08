package com.Entities;

import java.util.Date;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "salidaproductos")
public class SalidaProductos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codVenta;
	@Column
	private String cliente;
	@Column
	private String usuarioFK;
	@Column
	private int productoFK;
	@Column
	private int categoriaFK;
	@Column()
	private int cantidad;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	public int getCodVenta() {
		return codVenta;
	}
	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getUsuarioFK() {
		return usuarioFK;
	}
	public void setUsuarioFK(String usuarioFK) {
		this.usuarioFK = usuarioFK;
	}
	public int getProductoFK() {
		return productoFK;
	}
	public void setProductoFK(int productoFK) {
		this.productoFK = productoFK;
	}
	public int getCategoriaFK() {
		return categoriaFK;
	}
	public void setCategoriaFK(int categoriaFK) {
		this.categoriaFK = categoriaFK;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "SalidaProductos [codVenta=" + codVenta + ", cliente=" + cliente + ", usuarioFK=" + usuarioFK
				+ ", productoFK=" + productoFK + ", categoriaFK=" + categoriaFK + ", cantidad=" + cantidad + ", fecha="
				+ fecha + "]";
	}
	
	

}
