package com.Distribuidora.app;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class ProductoService {
	

	private final ProductoRepository productoRepository;

	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository=productoRepository;
	}
	

	public Optional<Producto> addProducto(Producto producto) {
		Optional<Producto> p = productoRepository.findByNombre(producto.getNombre());
		if(!p.isPresent()) {
			Producto saved = productoRepository.save(producto);
			return Optional.of(saved);
		}
		return Optional.empty();
	}

	
	public Optional<Producto> getById(Long id){
		return productoRepository.findById(id);
	}
	
	public Optional<Producto> getByName(String nombre){
		return productoRepository.findByNombre(nombre);
	}
	
	
	public List<Producto> getAll(){
		return productoRepository.findAll();
	}
	
	public boolean deleteProductoByName(String nombre){
			Optional<Producto> p = productoRepository.findByNombre(nombre);
			if(p.isPresent()) {
				productoRepository.deleteByNombre(nombre);
				return true;
			}
			return false;
	}
	
	public Optional<Producto> updateProductoPrice(ProductoUpdateDTO updateP) {
		Optional<Producto> p = productoRepository.findByNombre(updateP.getNombre());
		if(p.isPresent()) {
			Producto pSave = p.get();
			pSave.setPrecio(updateP.getPrecio());
			productoRepository.save(pSave);
		} return p;
		
	}
	
	
}
