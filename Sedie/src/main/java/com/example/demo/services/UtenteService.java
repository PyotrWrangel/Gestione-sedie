package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Utente;
import com.example.demo.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;


//CREAZIONE UTENTE

public Utente creaUtente(Utente utente) {
	Utente nuovoUtente = new Utente(utente.getNome());
	
	utenteRepository.save(nuovoUtente);
	return nuovoUtente;
}

//visualizza utente

public Utente cercaUtente(Long id) {
	Utente utente = utenteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
			"Errore 404 nessun utente trovato con id: " + id
			));
	
	return utente;
}

public void eliminaUtente(Long id) {
	if (utenteRepository.existsById(id)) {
		utenteRepository.deleteById(id);
	} else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Nessun utente trovato con id " + id);
	}
	
}

}
