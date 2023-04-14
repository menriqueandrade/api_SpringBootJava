package com.apispring.api_spring.services.clientes;

import java.util.List;

import com.apispring.api_spring.models.clientes.Cliente;



public interface IClienteServicio {
    public List<Cliente> obtenerTodo();
    public Cliente guardar(Cliente cliente);
    public Cliente obtenerPorId(Long id);
    public void eliminar(Long id);

}
