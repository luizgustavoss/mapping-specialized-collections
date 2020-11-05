package com.example.mapping.mapper;

import com.example.mapping.domain.Motociclista;
import com.example.mapping.dto.MotociclistaDTO;

public class MotociclistaMapper extends AbstractMapper<MotociclistaDTO, Motociclista> {

    @Override
    public MotociclistaDTO map(Motociclista motociclista) {
        return MotociclistaDTO.builder()
                .id(motociclista.getId())
                .nome(motociclista.getNome())
                .motocicletas(new MotocicletaMapper().map(motociclista.getVeiculos()))
                .build();
    }
}
