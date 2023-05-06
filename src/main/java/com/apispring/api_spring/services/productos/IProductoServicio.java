package com.apispring.api_spring.services.productos;

import java.util.List;

import com.apispring.api_spring.models.productos.Producto;

public interface IProductoServicio {
    public List<Producto> obtenerTodo();
    public Producto guardar(Producto producto);
    
}
