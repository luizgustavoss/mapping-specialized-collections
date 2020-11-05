package com.example.mapping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="veiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_piloto")
    private Piloto piloto;

    private String marca;

    private String modelo;
}
