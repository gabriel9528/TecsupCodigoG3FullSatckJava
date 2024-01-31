package com.tablasRelacionadasCRUD.repository;

import com.tablasRelacionadasCRUD.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
}
