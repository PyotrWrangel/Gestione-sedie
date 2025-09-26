package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenteSeduto")
public class UtenteSeduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "utente_id", nullable = false, referencedColumnName = "id")
	private Utente utente;

	@OneToOne
	@JoinColumn(name = "sedia_id", nullable = false, referencedColumnName = "id")
	private Sedia sedia;

	public UtenteSeduto() {

	}

	public UtenteSeduto(Utente utente, Sedia sedia) {
		this.sedia = sedia;
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Sedia getSedia() {
		return sedia;
	}

	public void setSedia(Sedia sedia) {
		this.sedia = sedia;
	}

	@Override
	public String toString() {
		return "UtenteSeduto{" + "id=" + id + ", utente=" + utente + '\'' + ", sedia=" + sedia + '}';
	}

}

