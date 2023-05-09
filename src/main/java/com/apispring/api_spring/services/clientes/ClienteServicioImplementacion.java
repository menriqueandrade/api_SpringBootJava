package com.apispring.api_spring.services.clientes;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apispring.api_spring.models.clientes.Cliente;
import com.apispring.api_spring.models.productos.Producto;
import com.apispring.api_spring.repository.clientes.ClienteRepositorio;
import com.apispring.api_spring.repository.productos.ProductoRepositorio;

@Service
public class ClienteServicioImplementacion implements IClienteServicio {
    @Autowired
    ClienteRepositorio clienteRepositorio;
    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<Cliente> obtenerTodo() {

        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepositorio.deleteById(id);
    }

    public Cliente asignarProductoCliente(Long clienteId, Long productoId) {
        Set<Producto> productoSet = null;
        Cliente cliente = clienteRepositorio.findById(clienteId).get();
        Producto producto = productoRepositorio.findById(productoId).get();
        productoSet = cliente.getProductosAsignados();
        productoSet.add(producto);
        cliente.setProductosAsignados(productoSet);
        return clienteRepositorio.save(cliente);
    }

}
