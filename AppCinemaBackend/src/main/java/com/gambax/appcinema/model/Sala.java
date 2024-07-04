package com.gambax.appcinema.model;

import com.gambax.appcinema.model.ids.SalaId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta una sala cinematografica. Mappata come entità JPA con
 * la tabella "sala" nel database.
 */
@Entity
@IdClass(SalaId.class)
@Table(name = "sala")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Id
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private int capienza;

	@Column(name = "flag_imax", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean flagImax = false;

	/**
	 * Costruttore di default.
	 */
	public Sala() {
	}

	/**
	 * Costruttore con parametri.
	 *
	 * @param nome     Il nome della sala.
	 * @param capienza La capienza della sala.
	 * @param flagImax Indica se la sala supporta IMAX.
	 */
	public Sala(String nome, Integer capienza, Boolean flagImax) {
		this.nome = nome;
		this.capienza = capienza;
		this.flagImax = flagImax;
	}

	/**
	 * Restituisce l'ID della sala.
	 *
	 * @return L'ID della sala.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID della sala.
	 *
	 * @param id L'ID della sala.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce il nome della sala.
	 *
	 * @return Il nome della sala.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome della sala.
	 *
	 * @param nome Il nome della sala.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce la capienza della sala.
	 *
	 * @return La capienza della sala.
	 */
	public Integer getCapienza() {
		return capienza;
	}

	/**
	 * Imposta la capienza della sala.
	 *
	 * @param capienza La capienza della sala.
	 */
	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	/**
	 * Restituisce se la sala supporta IMAX.
	 *
	 * @return true se la sala supporta IMAX, altrimenti false.
	 */
	public Boolean getFlagImax() {
		return flagImax;
	}

	/**
	 * Imposta se la sala supporta IMAX.
	 *
	 * @param flagImax true se la sala supporta IMAX, altrimenti false.
	 */
	public void setFlagImax(Boolean flagImax) {
		this.flagImax = flagImax;
	}
}
