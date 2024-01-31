package com.OneToMany.PublicacionesComentarios.controller;

import com.OneToMany.PublicacionesComentarios.entity.Publicacion;
import com.OneToMany.PublicacionesComentarios.excepciones.ResourceNotFoundException;
import com.OneToMany.PublicacionesComentarios.repository.PublicacionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublicacionController {
    @Autowired
    PublicacionRepository publicacionRepository;

    @GetMapping("/publicaciones")
    public Page<Publicacion> listarPublicaciones(Pageable pageable){
        return publicacionRepository.findAll(pageable);
    }

    @PostMapping("/publicaciones")
    public Publicacion crearPublicacion(@Valid @RequestBody Publicacion publicacion){
        return publicacionRepository.save(publicacion);
    }

    @PutMapping("/publicaciones/{id}")
    public Publicacion actualizarPublicacion( @PathVariable("id") Long id ,@Valid @RequestBody Publicacion publicacionRquest){
        return publicacionRepository.findById(id).map(publicacion1 -> {
            publicacion1.setTitulo(publicacionRquest.getTitulo());
            publicacion1.setDescripcion(publicacionRquest.getDescripcion());
            publicacion1.setContenido(publicacionRquest.getContenido());
            return publicacionRepository.save(publicacion1);
        }).orElseThrow(()->new ResourceNotFoundException("Publicacion con el Id: " + id + " no encontrado" ));
    }

    @DeleteMapping("/publicaciones/{id}")
    public ResponseEntity<?> eliminarPublicacion( @PathVariable("id") Long id){
        return publicacionRepository.findById(id).map(publicacion1 -> {
            publicacionRepository.delete(publicacion1);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Publicacion con el Id: " + id + " no encontrado" ));
    }
}
