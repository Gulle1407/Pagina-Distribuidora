package com.Distribuidora.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public Optional<Producto> findByNombre(String nombre);
	
}
