package com.OneToOne.InstructorDetails.controller;

import com.OneToOne.InstructorDetails.entity.Instructor;
import com.OneToOne.InstructorDetails.excepciones.ResourceNotFoundException;
import com.OneToOne.InstructorDetails.repository.InstructorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    @Autowired
    InstructorRepository instructorRepository;

    @GetMapping("/instructores")
    public List<Instructor> listaInstructores(){
        return instructorRepository.findAll();
    }

    @GetMapping("/instructores/{id}")
    public ResponseEntity<Instructor> detallesInstructor(@PathVariable("id") Long id){
        Instructor instructor = instructorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Instructor con el ID: "+id + " no encontrado"));
       return ResponseEntity.ok().body(instructor);
    }

    @PostMapping("/instructores")
    public Instructor guardarInstructor(@Valid @RequestBody Instructor instructor){
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instructores/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable("id") Long id, @RequestBody Instructor instructor){
        Instructor instructor1 = instructorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Instructor con el ID: "+id + " no encontrado"));
        instructor1.setEmail(instructor.getEmail());
        Instructor instructorActualizado = instructorRepository.save(instructor1);
        return ResponseEntity.ok().body(instructorActualizado);
    }
    @DeleteMapping("/instructores/{id}")
    public Map<String, Boolean> eliminarInstructor(@PathVariable("id") Long id){
        Instructor instructor1 = instructorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Instructor con el ID: "+id + " no encontrado"));
        instructorRepository.delete(instructor1);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Instructor eliminado: "+id, Boolean.TRUE);
        return respuesta;
    }
}
