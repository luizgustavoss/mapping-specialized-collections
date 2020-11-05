package com.example.mapping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MotociclistaDTO {

    private Long id;
    private String nome;
    private List<MotocicletaDTO> motocicletas;
}
