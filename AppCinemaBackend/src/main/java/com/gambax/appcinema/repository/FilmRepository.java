package com.gambax.appcinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gambax.appcinema.model.Film;
import com.gambax.appcinema.model.ids.FilmId;

/**
 * Repository per gestire le operazioni di accesso ai dati della tabella "film".
 * Estende JpaRepository per fornire metodi CRUD standard.
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, FilmId> {

	/**
	 * Trova un film per nome.
	 *
	 * @param nome Il nome del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	Optional<Film> findByNome(String nome);

	/**
	 * Trova un film per ID e nome.
	 *
	 * @param id   L'ID del film.
	 * @param nome Il nome del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	Optional<Film> findByIdAndNome(Long id, String nome);

	/**
	 * Trova un film per ID.
	 *
	 * @param id L'ID del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	Optional<Film> findById(Long id);
}
