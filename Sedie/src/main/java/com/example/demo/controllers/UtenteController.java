package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Utente;
import com.example.demo.services.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	
	@PostMapping("/utenti")
	public ResponseEntity<?> aggiuntiUtente(@RequestBody Utente utente) {
		try {
			utenteService.creaUtente(utente);
			return ResponseEntity.ok("utente creato con successo");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("errore durante la creazione dell'utente");
		}
	}
	
	@GetMapping("/utenti/{id}")
	public ResponseEntity<?> getUtente(@PathVariable Long id) {
		try {
			Utente utente = utenteService.cercaUtente(id);
			
			return ResponseEntity.ok("utente: " + utente.getNome());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Errore nel recupero del profilo: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/utenti/{id}")
	public ResponseEntity<?> deleteUtente(@PathVariable Long id) {
			utenteService.eliminaUtente(id);
			
			return ResponseEntity.ok("Utente eliminato con successo");
	}
}


