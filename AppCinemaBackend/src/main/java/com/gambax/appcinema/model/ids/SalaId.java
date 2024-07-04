package com.gambax.appcinema.model.ids;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe che rappresenta l'ID di una sala, composto da un ID univoco e un nome.
 * Implementa Serializable per permettere la serializzazione dell'oggetto.
 */
public class SalaId implements Serializable {
	private static final long serialVersionUID = -7115953672675422066L;
	private Long id;
	private String nome;

	/**
	 * Costruttore di default.
	 */
	public SalaId() {
	}

	/**
	 * Costruttore con parametri.
	 *
	 * @param id   L'ID della sala.
	 * @param nome Il nome della sala.
	 */
	public SalaId(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
		SalaId salaId = (SalaId) o;
		return Objects.equals(id, salaId.id) && Objects.equals(nome, salaId.nome);
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
