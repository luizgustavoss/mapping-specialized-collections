package com.example.mapping.dto;

import com.example.mapping.domain.Combustivel;
import com.example.mapping.domain.Piloto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MotocicletaDTO {

    private Long id;
    private Piloto piloto;
    private String marca;
    private String modelo;
    private int cilindradas;
    private Combustivel combustivel;
}
