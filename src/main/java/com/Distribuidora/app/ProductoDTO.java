package com.Distribuidora.app;

public class ProductoDTO {

	private String nombre;
	
	private double precio ;
	
	private String descripcion;
	
	private Categorias categoria;
	
	
	public ProductoDTO() {
	}

	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
