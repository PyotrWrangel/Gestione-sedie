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

import com.example.demo.dto.FaiSedereRequest;
import com.example.demo.entities.UtenteSeduto;
import com.example.demo.services.UtenteSedutoService;

@RestController
@RequestMapping("/api")
public class UtenteSedutoController {

	@Autowired
	private UtenteSedutoService utenteSedutoService;
	
	@PostMapping("/seduti")
	public ResponseEntity<?>  faiSedereUtente(@RequestBody FaiSedereRequest request) {
		UtenteSeduto result = utenteSedutoService.faiSedere(request.getUtenteId(), request.getSediaId());
		
		return ResponseEntity.ok("L'utente " + result.getUtente().getId() + "si è seduto sulla sedia " + result.getSedia().getId());
	}
	
	@GetMapping("/seduti/{id}")
	public ResponseEntity<?>  recuperaAssociazione(@PathVariable Long id) {
		UtenteSeduto result = utenteSedutoService.getSeduti(id);
		return ResponseEntity.ok("Recupero" + result);
	}
	
	@GetMapping("/seduti/by-sedia/{sediaId}")
	public ResponseEntity<?> utenteSeduto(@PathVariable Long sediaId) {
	 UtenteSeduto result = utenteSedutoService.getSedutiBySedia(sediaId);
	 return ResponseEntity.ok("Nella sedia con id: " + sediaId + " è seduto l'utente con id: " + result.getUtente().getId());
	}
	
	@DeleteMapping("/seduti/{id}")
	public ResponseEntity<?>  faiAlzareUtente(@PathVariable Long id) {
		utenteSedutoService.alzati(id);
		return ResponseEntity.ok("l'utente con id " + id + " si è alzato");
	}
}
