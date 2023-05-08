package com.apispring.api_spring.services.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apispring.api_spring.models.productos.Producto;
import com.apispring.api_spring.repository.productos.ProductoRepositorio;

@Service
public class ProductoServicioImplementacion implements IProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> obtenerTodo() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    // obtener producto por id
    @Override
    public Producto obtenerPorId(long id) {
        return productoRepositorio.findById(id).get();
    }

}
