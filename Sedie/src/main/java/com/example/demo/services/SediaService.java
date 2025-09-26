package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Sedia;
import com.example.demo.repositories.SediaRepository;

@Service
public class SediaService {

	@Autowired
	private SediaRepository sediaRepository;
	
	public Sedia creaSedia(Sedia sedia) {
		Sedia nuovaSedia = new Sedia(sedia.getCodice());
		sediaRepository.save(nuovaSedia);
		return nuovaSedia;
	}
	
	public Sedia cercaSedia(Long id) {
		Sedia sedia = sediaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
		"Errore 404 nessun utente trovato con id: "	+ id	
		));
		
		return sedia;
	}
	
	public Sedia eliminaSedia(Long id) {
		 Sedia sedia = sediaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Impossibile eliminare la sedia con id: " + id
				));
		 sediaRepository.deleteById(id);
		 return sedia;
	}
}
