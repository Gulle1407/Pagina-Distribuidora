package com.Distribuidora.app;

import java.util.List;
import java.util.Optional;

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

	
	/*	
	 		Optional<Producto> p = productoRepository.findByNombre(producto.getNombre());
		if(!p.isPresent()) {
			productoRepository.save(producto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return  ResponseEntity.status(HttpStatus.CONFLICT).body("Producto ya existente");

	public Producto addProductoOrUpdateByName(Producto producto) {
		Optional<Producto> p = productoRepository.findByNombre(producto.getNombre());
		if(p.isPresent()) {
			Producto existent = p.get();
			existent.setDescripcion(producto.getDescripcion());
			existent.setCategoria(producto.getCategoria());
			existent.setPrecio(producto.getPrecio());
			existent.setStock(producto.getStock());
			return productoRepository.save(existent);
		} else 	return productoRepository.save(producto);
	}
*/
	
	public Optional<Producto> getById(Long id){
		return productoRepository.findById(id);
	}
	
	public Optional<Producto> getByName(String nombre){
		return productoRepository.findByNombre(nombre);
	}
	
	
	public List<Producto> getAll(){
		return productoRepository.findAll();
		
	}
	
}
