package com.Distribuidora.app;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class ProductoController {

	private final ProductoService productoService;
	private final ProductoMapper productoMapper;
	

	public ProductoController(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService=productoService;
		this.productoMapper=productoMapper;
	}
	
	
	@GetMapping("/idSearch/{id}")
	public ResponseEntity<ProductoDTO> getById(@PathVariable Long id) {
		Optional<Producto> producto = productoService.getById(id);
		return producto.map(productoMapper::productoToDto) //transformamos el optional Producto al DTO
				.map(ResponseEntity::ok) //transformamos el productoDTO a responseEntity<Dto>
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nameSearch/{nombre}")
	public ResponseEntity<ProductoDTO> getByName(@PathVariable String nombre) {
		Optional<Producto> producto = productoService.getByName(nombre);
		return producto.map(productoMapper::productoToDto) 
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/listProducts")
	public List<ProductoDTO> getAllProductos() {
		List<Producto> lista= productoService.getAll();
		return productoMapper.ToDtoList(lista);				
		
	}

	
	@PostMapping("/crear") 
	public ResponseEntity<ProductoDTO> addProducto(@RequestBody Producto p) {
		Optional<Producto> producto = productoService.addProducto(p);
		return producto.map(productoMapper::productoToDto) //transformamos el optional a optionaldto
				.map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto))// optional dto si existe a response entity created con body dto
				.orElse(ResponseEntity.status(HttpStatus.CONFLICT).build()); //optional no existe devolvemos conflicto
	}
	
	@DeleteMapping("/eliminar/{nombre}")
	public ResponseEntity<String> deleteProducto(@PathVariable String nombre) { 
		boolean borrado = productoService.deleteProductoByName(nombre);
		if(borrado) {
			return ResponseEntity.noContent().build();
		}else return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/actualizar") 
	public ResponseEntity<ProductoDTO> updateProductoPrice(@RequestBody ProductoUpdateDTO updateDto){
		Optional<Producto> p = productoService.updateProductoPrice(updateDto);
		return p.map(productoMapper::productoToDto) 
				.map(dto -> ResponseEntity.status(HttpStatus.OK).body(dto))
				.orElse(ResponseEntity.status(HttpStatus.CONFLICT).build()); 	
	}
	
	
}
