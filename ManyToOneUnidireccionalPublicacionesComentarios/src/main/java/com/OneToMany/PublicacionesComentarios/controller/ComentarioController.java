package com.OneToMany.PublicacionesComentarios.controller;

import com.OneToMany.PublicacionesComentarios.entity.Comentario;
import com.OneToMany.PublicacionesComentarios.excepciones.ResourceNotFoundException;
import com.OneToMany.PublicacionesComentarios.repository.ComentarioRepository;
import com.OneToMany.PublicacionesComentarios.repository.PublicacionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComentarioController {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    PublicacionRepository publicacionRepository;

    @GetMapping("/publicaciones/{id}/comentarios")
    public Page<Comentario> listarComentariosPorPublicacion(@PathVariable("id") Long id, Pageable pageable){
        return comentarioRepository.findByPublicacionId(id, pageable);
    }

    @PostMapping("/publicaciones/{id}/comentarios")
    public Comentario guardarComentario(@PathVariable("id") Long id, @Valid @RequestBody Comentario comentario){
        return publicacionRepository.findById(id).map(publicacion -> {
            comentario.setPublicacion(publicacion);
            return comentarioRepository.save(comentario);
        }).orElseThrow(()-> new ResourceNotFoundException("Publicacion con el Id: " + id + " no encontrado" ));
    }

    @PutMapping("/publicaciones/{publicacionesId}/comentarios/{comentariosId}")
    public Comentario actualizarComentario(@PathVariable("publicacionesId") Long publicacionesId, @PathVariable("comentariosId") Long comentariosId, @Valid @RequestBody Comentario comentarioRequest){
        if(!publicacionRepository.existsById(publicacionesId)){
            throw new ResourceNotFoundException("Publicacion con el Id: " + publicacionesId + " no encontrado" );
        }
        return comentarioRepository.findById(comentariosId).map(comentario -> {
            comentario.setTexto(comentarioRequest.getTexto());
            return comentarioRepository.save(comentario);
        }).orElseThrow(()-> new ResourceNotFoundException("Comentario con el Id: " + comentariosId + " no encontrado" ));
    }

    @DeleteMapping("/publicaciones/{publicacionesId}/comentarios/{comentariosId}")
    public ResponseEntity<?> eliminarComentario(@PathVariable("publicacionesId") Long publicacionesId, @PathVariable("comentariosId") Long comentariosId){
        return comentarioRepository.findByIdAndPublicacionId(comentariosId ,publicacionesId).map(comentario -> {
            comentarioRepository.delete(comentario);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Comentario con el Id: " + comentariosId + " no encontrado, y Publicacion con el ID: " + publicacionesId + " no encontrado"));
    }

}
