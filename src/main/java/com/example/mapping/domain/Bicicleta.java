package com.example.mapping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name="bicicleta")
public class Bicicleta extends Veiculo {

    private int marchas;

    private int aro;
}
