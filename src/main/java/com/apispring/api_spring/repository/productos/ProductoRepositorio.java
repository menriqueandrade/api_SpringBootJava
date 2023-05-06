package com.apispring.api_spring.repository.productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apispring.api_spring.models.productos.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long>{
    
}
