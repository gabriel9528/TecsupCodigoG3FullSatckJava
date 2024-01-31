package com.bidireccional.controller;

import com.bidireccional.entity.Biblioteca;
import com.bidireccional.repository.BibliotecaRepository;
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
@RequestMapping("/api/biblioteca")
public class bibliotecaController {

    @Autowired
    BibliotecaRepository bibliotecaRepository;

    //utiliza Pageable para manejar la paginación de los resultados de la consulta
    //, en lugar de devolver todos los resultados de la consulta de una vez,
    // se devolverá solo una página de resultados.
    //Pageable te permite manejar la paginación y ordenamiento de los resultados de tus consultas en Spring
    // de una manera fácil y estandarizada.
    @GetMapping
    public ResponseEntity<Page<Biblioteca>> listarBibliotecas(Pageable pageable){
        return ResponseEntity.ok(bibliotecaRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Biblioteca> crearBiblioteca(@Valid @RequestBody Biblioteca biblioteca){
        Biblioteca bibliotecaGuardada = bibliotecaRepository.save(biblioteca);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bibliotecaGuardada.getId()).toUri();
        return ResponseEntity.created(ubicacion).body(bibliotecaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> actualizarBiblioteca(@PathVariable("id") Integer id ,@Valid @RequestBody Biblioteca biblioteca){
        Optional<Biblioteca> bibliotecaEncontrada = bibliotecaRepository.findById(id);
        if(!bibliotecaEncontrada.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        biblioteca.setId(bibliotecaEncontrada.get().getId());
        bibliotecaRepository.save(biblioteca);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Biblioteca> deleteBiblioteca(@PathVariable("id") Integer id ){
        Optional<Biblioteca> bibliotecaEncontrada = bibliotecaRepository.findById(id);
        if(!bibliotecaEncontrada.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        bibliotecaRepository.delete(bibliotecaEncontrada.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> obtenerBibliotecaPorId(@PathVariable("id") Integer id ){
        Optional<Biblioteca> bibliotecaEncontrada = bibliotecaRepository.findById(id);
        if(!bibliotecaEncontrada.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(bibliotecaEncontrada.get());
    }
}
