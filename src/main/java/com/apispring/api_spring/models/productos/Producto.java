package com.apispring.api_spring.models.productos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.apispring.api_spring.models.clientes.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productoId;
    private String nombre;
    private String valor;
    @JsonIgnore
    @ManyToMany(mappedBy = "productosAsignados")
    private Set<Cliente> clienteSet = new HashSet<>();

}
