package com.OneToMany.PublicacionesComentarios.repository;

import com.OneToMany.PublicacionesComentarios.entity.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    Page<Comentario> findByPublicacionId(Long publicacionId, Pageable pageable);
    Optional<Comentario> findByIdAndPublicacionId(Long comentarionId, Long publicacionId);
}
