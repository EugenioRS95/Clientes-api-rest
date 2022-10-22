package com.ilitc.springbootbackendapirest.controllers;

import com.ilitc.springbootbackendapirest.models.entity.Cliente;
import com.ilitc.springbootbackendapirest.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteActual = clienteService.findById(id);

        clienteActual.setNombres(cliente.getNombres());
        clienteActual.setApellidoPaterno(cliente.getApellidoPaterno());
        clienteActual.setApellidoMaterno(cliente.getApellidoMaterno());
        clienteActual.setDireccion(cliente.getDireccion());
        clienteActual.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteActual.setEmail(cliente.getEmail());
        clienteActual.setSexo(cliente.getSexo());

        return clienteService.save(clienteActual);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
