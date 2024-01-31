package com.tablasRelacionadasCRUD.controller;

import com.tablasRelacionadasCRUD.entity.Cliente;
import com.tablasRelacionadasCRUD.entity.Product;
import com.tablasRelacionadasCRUD.entity.Usuario;
import com.tablasRelacionadasCRUD.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
