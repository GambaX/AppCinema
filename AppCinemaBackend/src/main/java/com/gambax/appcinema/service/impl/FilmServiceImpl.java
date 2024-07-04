package com.gambax.appcinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gambax.appcinema.model.Film;
import com.gambax.appcinema.model.ids.FilmId;
import com.gambax.appcinema.repository.FilmRepository;
import com.gambax.appcinema.service.FilmService;

/**
 * Implementazione del servizio per gestire le operazioni sui film.
 */
@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;

	/**
	 * Salva un film nel repository.
	 *
	 * @param film Il film da salvare.
	 * @return Il film salvato.
	 */
	@Override
	public Film saveFilm(Film film) {
		return filmRepository.save(film);
	}

	/**
	 * Recupera tutti i film dal repository.
	 *
	 * @return Una lista di tutti i film.
	 */
	@Override
	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	/**
	 * Recupera un film per ID e nome.
	 *
	 * @param id   L'ID del film.
	 * @param nome Il nome del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	@Override
	public Optional<Film> getFilmById(Long id, String nome) {
		return filmRepository.findById(new FilmId(id, nome));
	}

	/**
	 * Recupera un film per nome.
	 *
	 * @param nome Il nome del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	@Override
	public Optional<Film> getFilmByNome(String nome) {
		return filmRepository.findByNome(nome);
	}

	/**
	 * Recupera un film per ID.
	 *
	 * @param id L'ID del film.
	 * @return Un Optional contenente il film trovato, o vuoto se non trovato.
	 */
	@Override
	public Optional<Film> getFilmById(Long id) {
		return filmRepository.findById(id);
	}
}
