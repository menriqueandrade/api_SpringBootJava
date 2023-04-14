package com.apispring.api_spring.services.clientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apispring.api_spring.models.clientes.Cliente;
import com.apispring.api_spring.repository.clientes.ClienteRepositorio;


@Service
public class ClienteServicioImplementacion implements IClienteServicio {
    @Autowired
    ClienteRepositorio clienteRepositorio;

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

  

}
