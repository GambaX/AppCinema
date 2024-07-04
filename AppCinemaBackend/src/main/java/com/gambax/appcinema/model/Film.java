package com.gambax.appcinema.model;

import com.gambax.appcinema.model.ids.FilmId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta un film nel sistema cinema. Mappata come entità JPA
 * con la tabella "film" nel database.
 */
@Entity
@IdClass(FilmId.class)
@Table(name = "film")
public class Film {

	@Id
	private Long id;

	@Id
	private String nome;

	private String genere;
	private String regia;
	private int durata;
	private String coverUrl;

	/**
	 * Restituisce l'ID del film.
	 *
	 * @return L'ID del film.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID del film.
	 *
	 * @param id L'ID del film.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce il nome del film.
	 *
	 * @return Il nome del film.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome del film.
	 *
	 * @param nome Il nome del film.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il genere del film.
	 *
	 * @return Il genere del film.
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * Imposta il genere del film.
	 *
	 * @param genere Il genere del film.
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}

	/**
	 * Restituisce la regia del film.
	 *
	 * @return La regia del film.
	 */
	public String getRegia() {
		return regia;
	}

	/**
	 * Imposta la regia del film.
	 *
	 * @param regia La regia del film.
	 */
	public void setRegia(String regia) {
		this.regia = regia;
	}

	/**
	 * Restituisce la durata del film.
	 *
	 * @return La durata del film.
	 */
	public int getDurata() {
		return durata;
	}

	/**
	 * Imposta la durata del film.
	 *
	 * @param durata La durata del film.
	 */
	public void setDurata(int durata) {
		this.durata = durata;
	}

	/**
	 * Restituisce l'URL della copertina del film.
	 *
	 * @return L'URL della copertina del film.
	 */
	public String getCoverUrl() {
		return coverUrl;
	}

	/**
	 * Imposta l'URL della copertina del film.
	 *
	 * @param coverUrl L'URL della copertina del film.
	 */
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
}
