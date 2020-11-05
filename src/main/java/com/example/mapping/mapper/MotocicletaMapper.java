package com.example.mapping.mapper;

import com.example.mapping.domain.Motocicleta;
import com.example.mapping.domain.Veiculo;
import com.example.mapping.dto.MotocicletaDTO;

public class MotocicletaMapper extends AbstractMapper<MotocicletaDTO, Veiculo> {
    @Override
    public MotocicletaDTO map(Veiculo veiculo) {

        Motocicleta motocicleta = (Motocicleta) veiculo;

        return MotocicletaDTO.builder()
                .id(motocicleta.getId())
                .marca(motocicleta.getMarca())
                .modelo(motocicleta.getModelo())
                .cilindradas(motocicleta.getCilindradas())
                .combustivel(motocicleta.getCombustivel())
                .build();
    }

}
