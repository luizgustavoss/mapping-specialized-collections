package com.example.mapping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity(name="motocicleta")
public class Motocicleta extends Veiculo {

    private int cilindradas;

    @Enumerated(EnumType.STRING)
    private Combustivel combustivel;
}
