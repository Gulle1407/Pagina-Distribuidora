package com.Distribuidora.app;

public class ProductoUpdateDTO {
	private String nombre;
	private double precio;
	
	public ProductoUpdateDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	
}
