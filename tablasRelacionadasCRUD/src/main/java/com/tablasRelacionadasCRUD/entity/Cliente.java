package com.tablasRelacionadasCRUD.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Address> listaddress;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="client_product",
            joinColumns = {
                    @JoinColumn(name="fk_client")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_product")
            }
    )
    private List<Product> listProducts;

}
