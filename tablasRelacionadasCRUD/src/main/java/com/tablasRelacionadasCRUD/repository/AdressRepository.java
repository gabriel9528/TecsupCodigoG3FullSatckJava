package com.tablasRelacionadasCRUD.repository;

import com.tablasRelacionadasCRUD.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address, Long> {
}
