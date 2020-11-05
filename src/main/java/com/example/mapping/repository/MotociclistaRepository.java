package com.example.mapping.repository;

import com.example.mapping.domain.Motociclista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotociclistaRepository extends JpaRepository<Motociclista, Long> {
}
