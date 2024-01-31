package com.OneToOne.InstructorDetails.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detalle")
public class InstructorDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "canal_youtube")
    private String canalYoutube;
    @Column(name = "pasa_tiempo")
    private String pasaTiempo;

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanalYoutube() {
        return canalYoutube;
    }

    public void setCanalYoutube(String canalYoutube) {
        this.canalYoutube = canalYoutube;
    }

    public String getPasaTiempo() {
        return pasaTiempo;
    }

    public void setPasaTiempo(String pasaTiempo) {
        this.pasaTiempo = pasaTiempo;
    }
}
