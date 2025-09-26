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

import com.example.demo.entities.Sedia;
import com.example.demo.services.SediaService;

@RestController
@RequestMapping("/api")
public class SediaController {

	@Autowired
	private SediaService sediaService;
	
	@PostMapping("/sedie")
	public ResponseEntity<?> creaSedia(@RequestBody Sedia sedia) {
		sediaService.creaSedia(sedia);
		return ResponseEntity.ok("Sedia creata con successo");
	}
	
	@GetMapping("/sedie/{id}")
	public ResponseEntity<?> trovaSedia(@PathVariable Long id) {
		Sedia sedia = sediaService.cercaSedia(id);
		return ResponseEntity.ok("sedia: " + sedia.getCodice());
	}
	
	@DeleteMapping("/sedie/{id}")
	public ResponseEntity<?> eliminaSedia(@PathVariable Long id) {
		sediaService.eliminaSedia(id);
		return ResponseEntity.ok("Sedia eliminata con successo");
	}
}
