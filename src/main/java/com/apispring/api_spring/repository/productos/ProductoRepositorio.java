package com.apispring.api_spring.repository.productos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apispring.api_spring.models.productos.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
