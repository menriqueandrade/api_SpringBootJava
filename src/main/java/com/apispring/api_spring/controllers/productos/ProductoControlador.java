package com.apispring.api_spring.controllers.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        Producto nuevo_producto = productoservicio.guardar(producto);

        return new ResponseEntity<>(nuevo_producto, HttpStatus.CREATED);
    }

}
