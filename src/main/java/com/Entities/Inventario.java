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
@Table(name = "inventario")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column
	private int ingresoProductoFk;
	@Column
	private int salidaProductFK;
	@Column
	private int stock;
	@Column
	private int venta;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getIngresoProductoFk() {
		return ingresoProductoFk;
	}
	public void setIngresoProductoFk(int ingresoProductoFk) {
		this.ingresoProductoFk = ingresoProductoFk;
	}
	public int getSalidaProductFK() {
		return salidaProductFK;
	}
	public void setSalidaProductFK(int salidaProductFK) {
		this.salidaProductFK = salidaProductFK;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getVenta() {
		return venta;
	}
	public void setVenta(int venta) {
		this.venta = venta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Inventario [codigo=" + codigo + ", ingresoProductoFk=" + ingresoProductoFk + ", salidaProductFK="
				+ salidaProductFK + ", stock=" + stock + ", venta=" + venta + ", fecha=" + fecha + "]";
	}
	
	

}
