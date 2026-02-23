package com.Distribuidora.app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;	

	@Column(unique = true)
	private String nombre;
	
	private double precio ;
	
	private String descripcion;
	
	private Categorias categoria;
	
	private int stock;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String nombre, double precio, String descripcion, Categorias categoria, int stock) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.categoria=categoria;
		this.precio=precio;
		this.stock=stock;	
	}
	
	public Categorias getCategoria() {
		return categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getStock() {
		return stock;
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
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
