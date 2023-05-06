package com.apispring.api_spring.controllers.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.apispring.api_spring.models.productos.Producto;
import com.apispring.api_spring.services.productos.ProductoServicioImplementacion;

@RestController
@RequestMapping("/productController")
@CrossOrigin(origins = "*")
public class ProductoControlador {
    @Autowired
    ProductoServicioImplementacion productoservicio;

    
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        return productoservicio.obtenerTodo();
    }

}
