package com.apispring.api_spring.models.productos;

import java.io.Serializable;

import com.apispring.api_spring.models.clientes.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
// nombre tabla
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String valor;
    // bidireccional
    @OneToOne(mappedBy = "producto")
    private Cliente cliente;

    public Producto() {
    }

    public Producto(long id, String nombre, String valor, Cliente cliente) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.cliente = cliente;

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
