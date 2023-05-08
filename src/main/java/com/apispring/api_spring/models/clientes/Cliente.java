package com.apispring.api_spring.models.clientes;

import java.io.Serializable;

import com.apispring.api_spring.models.productos.Producto;
import com.fasterxml.jackson.annotation.JsonCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties(value = { "id" }, allowGetters = true)
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nombre;
    private String apellido;
    private String email;

    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @JsonCreator
    public Cliente(

            @JsonProperty("nombre") String nombre,
            @JsonProperty("apellido") String apellido,
            @JsonProperty("email") String email,
            @JsonProperty("producto") Producto producto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.producto = producto;
    }

    public Cliente() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
