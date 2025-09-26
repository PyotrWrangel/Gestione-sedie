package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Sedia;
import com.example.demo.entities.Utente;
import com.example.demo.entities.UtenteSeduto;

public interface UtenteSedutoRepository extends JpaRepository <UtenteSeduto, Long> {
boolean existsByUtente(Utente utente);
boolean existsBySedia (Sedia sedia);

Optional<UtenteSeduto> findBySediaId(Long sediaId);
}
