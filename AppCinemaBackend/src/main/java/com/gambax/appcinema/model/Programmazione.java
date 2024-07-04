package com.gambax.appcinema.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta una programmazione di un film in una sala. Mappata
 * come entità JPA con la tabella "programmazione" nel database.
 */
@Entity
@Table(name = "programmazione")
public class Programmazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataInizio;
	private LocalDate dataFine;
	private Long filmId;
	private Long salaId;
	private String filmNome;
	private String salaNome;

	/**
	 * Restituisce l'ID della programmazione.
	 *
	 * @return L'ID della programmazione.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID della programmazione.
	 *
	 * @param id L'ID della programmazione.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce la data di inizio della programmazione.
	 *
	 * @return La data di inizio della programmazione.
	 */
	public LocalDate getDataInizio() {
		return dataInizio;
	}

	/**
	 * Imposta la data di inizio della programmazione.
	 *
	 * @param dataInizio La data di inizio della programmazione.
	 */
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	/**
	 * Restituisce la data di fine della programmazione.
	 *
	 * @return La data di fine della programmazione.
	 */
	public LocalDate getDataFine() {
		return dataFine;
	}

	/**
	 * Imposta la data di fine della programmazione.
	 *
	 * @param dataFine La data di fine della programmazione.
	 */
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	/**
	 * Restituisce l'ID del film associato alla programmazione.
	 *
	 * @return L'ID del film associato alla programmazione.
	 */
	public Long getFilmId() {
		return filmId;
	}

	/**
	 * Imposta l'ID del film associato alla programmazione.
	 *
	 * @param filmId L'ID del film associato alla programmazione.
	 */
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	/**
	 * Restituisce l'ID della sala associata alla programmazione.
	 *
	 * @return L'ID della sala associata alla programmazione.
	 */
	public Long getSalaId() {
		return salaId;
	}

	/**
	 * Imposta l'ID della sala associata alla programmazione.
	 *
	 * @param salaId L'ID della sala associata alla programmazione.
	 */
	public void setSalaId(Long salaId) {
		this.salaId = salaId;
	}

	/**
	 * Restituisce il nome del film associato alla programmazione.
	 *
	 * @return Il nome del film associato alla programmazione.
	 */
	public String getFilmNome() {
		return filmNome;
	}

	/**
	 * Imposta il nome del film associato alla programmazione.
	 *
	 * @param filmNome Il nome del film associato alla programmazione.
	 */
	public void setFilmNome(String filmNome) {
		this.filmNome = filmNome;
	}

	/**
	 * Restituisce il nome della sala associata alla programmazione.
	 *
	 * @return Il nome della sala associata alla programmazione.
	 */
	public String getSalaNome() {
		return salaNome;
	}

	/**
	 * Imposta il nome della sala associata alla programmazione.
	 *
	 * @param salaNome Il nome della sala associata alla programmazione.
	 */
	public void setSalaNome(String salaNome) {
		this.salaNome = salaNome;
	}
}
