package com.tablasRelacionadas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Competeciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="quantity_price", columnDefinition = "varchar(200)")
    private Integer quantityPrice;
    @Column(name="start_price", columnDefinition = "DATE")
    private LocalDate starDate;
    @Column(name="end_date", columnDefinition = "DATE")
    private LocalDate endDate;

}
