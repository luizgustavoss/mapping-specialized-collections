package com.example.mapping.repository;

import com.example.mapping.domain.Ciclista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiclistaRepository extends JpaRepository<Ciclista, Long> {
}
