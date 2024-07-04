package com.gambax.appcinema.service;

import java.util.List;
import java.util.Optional;

import com.gambax.appcinema.model.Film;

/**
 * Interfaccia per definire i metodi del servizio per gestire le operazioni sui
 * film.
 */
public interface FilmService {

	/**
	 * Salva un film.
	 *
	 * @param film Il film da salvare.
	 * @return Il film salvato.
	 */
	Film saveFilm(Film film);

	/**
	 * Recupera tutti i film.
	 *
	 * @return Una lista di tutti i film.
	 */
	List<Film> getAllFilms();

	/**
	 * Recupera un film per ID e nome.
	 *
	 * @param id   L'ID del film.
	 * @param nome Il nome del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	Optional<Film> getFilmById(Long id, String nome);

	/**
	 * Recupera un film per ID.
	 *
	 * @param id L'ID del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	Optional<Film> getFilmById(Long id);

	/**
	 * Recupera un film per nome.
	 *
	 * @param nome Il nome del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	Optional<Film> getFilmByNome(String nome);
}
