package com.tablasRelacionadasCRUD.controller;

import com.tablasRelacionadasCRUD.entity.Usuario;
import com.tablasRelacionadasCRUD.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario){
        return userService.createUser(usuario);
    }
}
