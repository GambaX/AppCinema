package com.gambax.appcinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta un utente nel sistema cinema. Mappata come entità JPA
 * con la tabella "users" nel database.
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;

	/**
	 * Restituisce l'ID dell'utente.
	 *
	 * @return L'ID dell'utente.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID dell'utente.
	 *
	 * @param id L'ID dell'utente.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce il nome utente dell'utente.
	 *
	 * @return Il nome utente dell'utente.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Imposta il nome utente dell'utente.
	 *
	 * @param username Il nome utente dell'utente.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Restituisce la password dell'utente.
	 *
	 * @return La password dell'utente.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Imposta la password dell'utente.
	 *
	 * @param password La password dell'utente.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Restituisce una rappresentazione in formato stringa dell'utente.
	 *
	 * @return Una stringa che rappresenta l'utente.
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
