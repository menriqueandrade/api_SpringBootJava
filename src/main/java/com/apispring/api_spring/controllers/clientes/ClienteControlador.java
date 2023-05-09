package com.apispring.api_spring.controllers.clientes;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apispring.api_spring.models.clientes.Cliente;
import com.apispring.api_spring.services.clientes.ClienteServicioImplementacion;

@RestController
@RequestMapping("/clientController")
@CrossOrigin(origins = "*")
public class ClienteControlador {
    @Autowired
    ClienteServicioImplementacion clienteservicio;

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
        return clienteservicio.obtenerTodo();

    }

    //
    @PutMapping("/{clienteId}/productos/{productoId}")
    public Cliente asignarProductoCliente(@PathVariable Long clienteId,
            @PathVariable Long productoId) {
        return clienteservicio.asignarProductoCliente(clienteId, productoId);
    }
    //

    @PostMapping("/guardar")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente nuevo_cliente = clienteservicio.guardar(cliente);
        System.out.println(nuevo_cliente);
        return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> obtenerClienteId(@PathVariable long id) {
        Cliente clientePorId = clienteservicio.obtenerPorId(id);
        return new ResponseEntity<>(clientePorId, HttpStatus.OK);

    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        Cliente clienteporId = clienteservicio.obtenerPorId(id);
        clienteporId.setNombre(cliente.getNombre());
        clienteporId.setApellido(cliente.getApellido());
        clienteporId.setEmail(cliente.getEmail());

        Cliente cliente_actualizado = clienteservicio.guardar(clienteporId);
        return new ResponseEntity<>(cliente_actualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarCliente(@PathVariable long id) {
        this.clienteservicio.eliminar(id);
        HashMap<String, Boolean> respuestadoEstadoCliente = new HashMap<>();
        respuestadoEstadoCliente.put("Eliminado", true);
        return ResponseEntity.ok(respuestadoEstadoCliente);
    }
}
