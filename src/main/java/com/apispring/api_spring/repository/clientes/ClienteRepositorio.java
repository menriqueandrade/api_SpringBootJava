package com.apispring.api_spring.repository.clientes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apispring.api_spring.models.clientes.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
