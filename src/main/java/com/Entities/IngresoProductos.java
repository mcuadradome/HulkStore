package com.Entities;

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
@Table(name = "ingresoproductos")
public class IngresoProductos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codIngreso;
	@Column
	private String proveedor;
	@Column
	private String clienteFK;
	@Column
	private int productoFK;
	@Column
	private int categoriaFK;
	@Column
	private int cantidad;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	public int getCodIngreso() {
		return codIngreso;
	}
	public void setCodIngreso(int codIngreso) {
		this.codIngreso = codIngreso;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getClienteFK() {
		return clienteFK;
	}
	public void setClienteFK(String clienteFK) {
		this.clienteFK = clienteFK;
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
		return "IngresoProductos [codIngreso=" + codIngreso + ", proveedor=" + proveedor + ", clienteFK=" + clienteFK
				+ ", productoFK=" + productoFK + ", categoriaFK=" + categoriaFK + ", cantidad=" + cantidad + ", fecha="
				+ fecha + "]";
	}
	
	

}
