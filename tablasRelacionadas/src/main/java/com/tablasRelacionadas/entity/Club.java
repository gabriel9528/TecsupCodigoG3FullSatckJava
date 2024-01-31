package com.tablasRelacionadas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(targetEntity = Couch.class, cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_couch")
    private Couch couch;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> playerList;

    @ManyToOne(targetEntity = FootbalAsociation.class)
    private FootbalAsociation footbalAsociation;

    @ManyToMany(targetEntity = Club.class, fetch = FetchType.LAZY)
    private List<Competeciones> listacompeticiones;
}
