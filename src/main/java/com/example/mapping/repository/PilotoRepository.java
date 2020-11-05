package com.example.mapping.repository;

import com.example.mapping.domain.Ciclista;
import com.example.mapping.domain.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Long> {
}
