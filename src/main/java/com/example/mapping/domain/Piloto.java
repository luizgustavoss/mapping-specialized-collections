package com.example.mapping.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name="piloto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_piloto",
        discriminatorType = DiscriminatorType.STRING)
public class Piloto {

    @Id
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("piloto")
    private List<Veiculo> veiculos;
}
