package com.apispring.api_spring.models.clientes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import com.apispring.api_spring.models.productos.Producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cliente")
// @JsonIgnoreProperties(value = { "id" }, allowGetters = true)
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long clienteId;
    private String nombre;
    private String apellido;
    private String email;
    // JoincOLUMN BUSCA PRODUCT_ID PARA RELACIONAR
    @ManyToMany
    @JoinTable(name = "cliente_producto", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private Set<Producto> productosAsignados = new HashSet<>();
}
