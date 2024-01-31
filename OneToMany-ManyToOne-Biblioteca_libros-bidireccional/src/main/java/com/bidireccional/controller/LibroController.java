package com.bidireccional.controller;

import com.bidireccional.entity.Biblioteca;
import com.bidireccional.entity.Libro;
import com.bidireccional.repository.BibliotecaRepository;
import com.bidireccional.repository.LibroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    LibroRepository libroRepository;
    @Autowired
    BibliotecaRepository bibliotecaRepository;

    @GetMapping
    public ResponseEntity<Page<Libro>> listarLibros(Pageable pageable){
        return ResponseEntity.ok(libroRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody Libro libro){
        Optional<Biblioteca> bibliotecaEncontrada = bibliotecaRepository.findById(libro.getBiblioteca().getId());
        if(!bibliotecaEncontrada.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        libro.setBiblioteca(bibliotecaEncontrada.get());
        Libro libroGuardado = libroRepository.save(libro);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(libroGuardado.getId()).toUri();
        return ResponseEntity.created(ubicacion).body(libroGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> actualizarLibro(@PathVariable("id") Integer id , @Valid @RequestBody Libro libro){
        Optional<Biblioteca> bibliotecaEncontrada = bibliotecaRepository.findById(libro.getBiblioteca().getId());
        if(!bibliotecaEncontrada.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Libro> libroEncontrado = libroRepository.findById(libro.getId());
        if(!libroEncontrado.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        libro.setBiblioteca(bibliotecaEncontrada.get());
        libro.setId(libroEncontrado.get().getId());
        libroRepository.save(libro);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable("id") Integer id ){
        Optional<Libro> libroEncontrado = libroRepository.findById(id);
        if(!libroEncontrado.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(libroEncontrado.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> eliminarLibro(@PathVariable("id") Integer id){
        Optional<Libro> libroEncontrado = libroRepository.findById(id);
        if(!libroEncontrado.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        libroRepository.delete(libroEncontrado.get());
        return ResponseEntity.noContent().build();
    }
}
