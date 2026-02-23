package com.Distribuidora.app;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper{
	
	    ProductoDTO productoToDto(Producto producto);
	    Producto dtoToProducto(ProductoDTO dto);
	    List<ProductoDTO> ToDtoList(List<Producto> producto);
}
