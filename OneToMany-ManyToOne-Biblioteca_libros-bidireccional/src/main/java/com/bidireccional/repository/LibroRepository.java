package com.bidireccional.repository;

import com.bidireccional.entity.Biblioteca;
import com.bidireccional.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
