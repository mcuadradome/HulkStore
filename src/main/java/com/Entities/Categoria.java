package com.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCategoria;
	
	private String nombre;
	@Column
	private int ProductFK;
	
	public int getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProductFK() {
		return ProductFK;
	}
	public void setProductFK(int productFK) {
		ProductFK = productFK;
	}
	@Override
	public String toString() {
		return "Categoria [IdCategoria=" + IdCategoria + ", nombre=" + nombre + ", ProductFK=" + ProductFK + "]";
	}
	
	

}
