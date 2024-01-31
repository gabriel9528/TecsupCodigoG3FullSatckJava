package com.OneToMany.PublicacionesComentarios.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

//@EntityListeners(AuditingEntityListener.class) -> se utiliza para especificar una clase de escucha de eventos
// de auditoría que manejará automáticamente la actualización de las fechas de creación y actualización
// cada vez que se realice una operación de persistencia en una entidad que extiende

//los campos fechaCreacion y fechaActualizacion no deben incluirse en la representación JSON de la entidad
// durante la serialización. Además, permite que los métodos de acceso (getters) a estos campos se serialicen
// si están presentes.
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"fechaCreacion", "fechaActualizacion"},
                       allowGetters = true )
public abstract class AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @CreatedDate
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false)
    @LastModifiedDate
    private Date fechaActualizacion;

    //getters and setters

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
