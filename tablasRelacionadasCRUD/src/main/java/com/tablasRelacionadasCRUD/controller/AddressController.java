package com.tablasRelacionadasCRUD.controller;

import com.tablasRelacionadasCRUD.entity.Address;
import com.tablasRelacionadasCRUD.entity.Usuario;
import com.tablasRelacionadasCRUD.service.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direcciones")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    public Address createUser(@RequestBody Address address){
        return addressService.createAddress(address);
    }

}
