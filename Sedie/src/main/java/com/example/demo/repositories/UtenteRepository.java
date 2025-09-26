package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	//verify user already get chair
	//boolean existsByChair(Utente seduto);
}
