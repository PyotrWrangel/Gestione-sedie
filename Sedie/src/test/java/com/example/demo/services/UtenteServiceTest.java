package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Utente;
import com.example.demo.repositories.UtenteRepository;

@SpringBootTest
public class UtenteServiceTest {

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Test
	void testCreaUtente() {
		Utente nuovoUtente = new Utente("Giovanni");
		Utente utenteSalvato = utenteService.creaUtente(nuovoUtente);
		
		//controllo id e nome
		
		assertThat(utenteSalvato.getId()).isNotNull();
		assertThat(utenteSalvato.getNome()).isEqualTo("Giovanni");
	}
	
	@Test
	void testCercaUtente() {
		Utente nuovoUtente = new Utente("Matteo");
		Utente utenteSalvato = utenteService.creaUtente(nuovoUtente);
		
		Utente utenteDaTrovare = utenteService.cercaUtente(utenteSalvato.getId());
		
		assertThat(utenteDaTrovare.getNome()).isEqualTo("Matteo");
	}
	
	@Test
	void testeliminaUtente() {
		Utente nuovoUtente = new Utente("Marco");
		nuovoUtente = utenteRepository.save(nuovoUtente);
		
		//passo l'id da controllare
		
		Long id = nuovoUtente.getId();
		
		//verifico che l'id esista
		assertTrue(utenteRepository.existsById(id));
		
		//eliminazione dell'utente
		utenteService.eliminaUtente(id);
		
		//seconda verifica per accertare che non esista più
		assertFalse(utenteRepository.existsById(id));
	}
}
