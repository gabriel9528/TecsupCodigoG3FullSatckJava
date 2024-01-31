package com.tablasRelacionadasCRUD.service.Product;

import com.tablasRelacionadasCRUD.entity.Product;
import com.tablasRelacionadasCRUD.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
