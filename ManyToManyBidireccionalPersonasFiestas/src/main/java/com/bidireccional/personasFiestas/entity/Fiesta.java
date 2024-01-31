package com.bidireccional.personasFiestas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="fiestas")
public class Fiesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fiesta_id")
    private Long id;

    private String ubicacion;

    @Column(name = "fiesta_fecha")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fecha;

    @ManyToMany
    @JoinTable(name = "personas_fiestas",
        joinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"),
        inverseJoinColumns = @JoinColumn(name="persona_id", referencedColumnName = "persona_id"))
    private Set<Persona> listaPersonas = new HashSet<>();

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(Set<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public Fiesta() {
        super();
    }
}
