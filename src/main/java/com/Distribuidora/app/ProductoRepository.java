package com.Distribuidora.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public Optional<Producto> findByNombre(String nombre);
	 
	@Transactional
	public void deleteByNombre(String nombre);
	
}
