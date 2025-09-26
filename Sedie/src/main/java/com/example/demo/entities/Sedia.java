package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sedia")

public class Sedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codice", unique = true, columnDefinition = "varchar(255)")
	private String codice;

	public Sedia() {

	}

	public Sedia(String codice) {
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "Sedia{" + "id=" + id + "codice=" + codice + '}';
	}

}
	
