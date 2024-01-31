package com.tablasRelacionadasCRUD.controller;

import com.tablasRelacionadasCRUD.entity.Cliente;
import com.tablasRelacionadasCRUD.entity.Usuario;
import com.tablasRelacionadasCRUD.service.Client.ClienteService;
import com.tablasRelacionadasCRUD.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    UserService userService;

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cLiente){
        Usuario usuario = userService.getUserById(cLiente.getUser().getId()); // Implementa este método en tu UserService
        cLiente.setUser(usuario);

        // Guardar el cliente
        return clienteService.createClient(cLiente);
    }
}
