package com.OneToMany.PublicacionesComentarios.repository;

import com.OneToMany.PublicacionesComentarios.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
