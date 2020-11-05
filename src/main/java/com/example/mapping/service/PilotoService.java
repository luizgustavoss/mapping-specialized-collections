package com.example.mapping.service;

import com.example.mapping.domain.Ciclista;
import com.example.mapping.domain.Motociclista;
import com.example.mapping.domain.Piloto;
import com.example.mapping.repository.CiclistaRepository;
import com.example.mapping.repository.MotociclistaRepository;
import com.example.mapping.repository.PilotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PilotoService {

    private final CiclistaRepository ciclistaRepository;
    private final MotociclistaRepository motociclistaRepository;
    private final PilotoRepository pilotoRepository;


    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Ciclista> getCiclistas(){
        return ciclistaRepository.findAll();
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Motociclista> getMotociclistas(){
        return motociclistaRepository.findAll();
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Piloto> getPilotos(){
        return pilotoRepository.findAll();
    }
}
