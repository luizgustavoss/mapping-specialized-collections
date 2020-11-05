package com.example.mapping.controller;

import com.example.mapping.domain.Ciclista;
import com.example.mapping.domain.Motociclista;
import com.example.mapping.domain.Piloto;
import com.example.mapping.dto.MotociclistaDTO;
import com.example.mapping.mapper.MotociclistaMapper;
import com.example.mapping.service.PilotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequiredArgsConstructor
public class CiclistaController {

    private final PilotoService service;

    @GetMapping("/ciclistas")
    @ResponseStatus(HttpStatus.OK)
    public Callable<List<Ciclista>> getCiclistas() {
        return () -> service.getCiclistas();
    }

    @GetMapping("/motociclistas")
    @ResponseStatus(HttpStatus.OK)
    public Callable<List<MotociclistaDTO>> getMotociclistas() {
        return () -> new MotociclistaMapper().map(service.getMotociclistas());
    }

    @GetMapping("/pilotos")
    @ResponseStatus(HttpStatus.OK)
    public Callable<List<Piloto>> getPilotos() {
        return () -> service.getPilotos();
    }
}
