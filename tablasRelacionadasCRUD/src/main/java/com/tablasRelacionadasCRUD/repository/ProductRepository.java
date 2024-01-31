package com.tablasRelacionadasCRUD.repository;

import com.tablasRelacionadasCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
