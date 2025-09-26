package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Sedia;
import com.example.demo.repositories.SediaRepository;


@SpringBootTest
public class SediaServiceTest {

	@Autowired
	private SediaService sediaService;
	
	@Autowired
	private SediaRepository sediaRepository;
	
	
	
	@Test
	void testCreaSedia() {
		Sedia nuovaSedia = new Sedia("00001");
		Sedia sediaSalvata = sediaService.creaSedia(nuovaSedia);
		
		//controllo id e codice
		
		assertThat(sediaSalvata.getId()).isNotNull();
		assertThat(sediaSalvata.getCodice()).isEqualTo("00001");
	}
	
	@Test
	void testCercaSedia() {
		Sedia nuovaSedia = new Sedia("00002");
		Sedia sediaSalvata = sediaService.creaSedia(nuovaSedia);
		
		Sedia sediaDaTrovare = sediaService.cercaSedia(sediaSalvata.getId());
		
		assertThat(sediaDaTrovare.getCodice()).isEqualTo("00002");
	}
	
	@Test
	void testEliminaSedia() {
		Sedia nuovaSedia = new Sedia("00003");
		nuovaSedia = sediaRepository.save(nuovaSedia);
		
		Long id = nuovaSedia.getId();
		
		assertTrue(sediaRepository.existsById(id));
		
		sediaService.eliminaSedia(id);
		
		assertFalse(sediaRepository.existsById(id));
	}
}
