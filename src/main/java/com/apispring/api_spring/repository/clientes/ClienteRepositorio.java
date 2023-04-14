package com.apispring.api_spring.repository.clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apispring.api_spring.models.clientes.Cliente;



@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long>{
    
}
