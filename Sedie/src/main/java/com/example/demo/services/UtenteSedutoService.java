package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Sedia;
import com.example.demo.entities.Utente;
import com.example.demo.entities.UtenteSeduto;
import com.example.demo.repositories.SediaRepository;
import com.example.demo.repositories.UtenteRepository;
import com.example.demo.repositories.UtenteSedutoRepository;

@Service
public class UtenteSedutoService {

	@Autowired
	private UtenteSedutoRepository utenteSedutoRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired SediaRepository sediaRepository;
	
	//FAI SEDERE UTENTE
	
	public UtenteSeduto faiSedere(Long utenteId, Long sediaId) {
		Utente utente = utenteRepository.findById(utenteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato"));
		
		Sedia sedia = sediaRepository.findById(sediaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sedia non trovata"));
		
		if (utenteSedutoRepository.existsByUtente(utente)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Utente già seduto");
		} else if (utenteSedutoRepository.existsBySedia(sedia)) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Sedia già occupata");
			} else {
			UtenteSeduto utenteDaSedere = new UtenteSeduto(utente, sedia);

			utenteSedutoRepository.save(utenteDaSedere);
			
			return utenteDaSedere;
		}
	}
	
	public UtenteSeduto getSeduti(Long id) {
		UtenteSeduto utenteSeduto = utenteSedutoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Nessuna associazione trovata con id " + id
				));
		return utenteSeduto;
	}
	
	public UtenteSeduto getSedutiBySedia(Long sediaId) {
		return utenteSedutoRepository.findBySediaId(sediaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Errore 404 nessun utente è seduto su questa sedia: "));
	}
	
	public void alzati(Long id) {
		if (utenteSedutoRepository.existsById(id)) {
			utenteSedutoRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Nessun utente trovato con id" + id);
		}
	}
}
