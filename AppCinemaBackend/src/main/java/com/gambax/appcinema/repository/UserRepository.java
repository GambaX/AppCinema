package com.gambax.appcinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gambax.appcinema.model.User;

/**
 * Repository per gestire le operazioni di accesso ai dati della tabella
 * "users". Estende JpaRepository per fornire metodi CRUD standard.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Trova un utente per nome utente.
	 *
	 * @param username Il nome utente dell'utente.
	 * @return Un Optional contenente l'utente trovato, o vuoto se non trovato.
	 */
	Optional<User> findByUsername(String username);
}
