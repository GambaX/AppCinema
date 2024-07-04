package com.gambax.appcinema.model.ids;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe che rappresenta l'ID di un film, composto da un ID univoco e un nome.
 * Implementa Serializable per permettere la serializzazione dell'oggetto.
 */
public class FilmId implements Serializable {
	private static final long serialVersionUID = -7115953672675422066L;
	private Long id;
	private String nome;

	/**
	 * Costruttore di default.
	 */
	public FilmId() {
	}

	/**
	 * Costruttore con parametri.
	 *
	 * @param id   L'ID del film.
	 * @param nome Il nome del film.
	 */
	public FilmId(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

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
	 * Compara questo oggetto con un altro per verificare l'uguaglianza.
	 *
	 * @param o L'oggetto da comparare.
	 * @return true se gli oggetti sono uguali, altrimenti false.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FilmId filmId = (FilmId) o;
		return Objects.equals(id, filmId.id) && Objects.equals(nome, filmId.nome);
	}

	/**
	 * Restituisce l'hash code di questo oggetto.
	 *
	 * @return L'hash code dell'oggetto.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}
}
