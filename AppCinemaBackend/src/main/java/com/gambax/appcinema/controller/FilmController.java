package com.gambax.appcinema.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gambax.appcinema.model.Film;
import com.gambax.appcinema.model.ids.FilmId;
import com.gambax.appcinema.service.FilmService;

/**
 * Rest controller per gestire le operazioni sui film nel sistema cinema.
 * Gestisce le richieste HTTP per salvare, recuperare tutti i film, recuperare
 * un film per ID e recuperare un film per nome.
 */
@RestController
@RequestMapping("/cinema")
@CrossOrigin("*")
public class FilmController {

	@Autowired
	public FilmService filmService;

	/**
	 * Salva un nuovo film.
	 *
	 * @param film Il film da salvare.
	 * @return ResponseEntity contenente il film salvato e lo stato HTTP OK.
	 */
	@PostMapping("/savefilm")
	public ResponseEntity<Film> saveFilm(@RequestBody Film film) {
		Film f = filmService.saveFilm(film);
		return new ResponseEntity<Film>(f, HttpStatus.OK);
	}

	/**
	 * Recupera tutti i film.
	 *
	 * @return ResponseEntity contenente la lista di tutti i film e lo stato HTTP
	 *         OK.
	 */
	@PostMapping("/allfilms")
	public ResponseEntity<List<Film>> getAllFilms() {
		List<Film> films = filmService.getAllFilms();
		return new ResponseEntity<>(films, HttpStatus.OK);
	}

	/**
	 * Recupera un film per ID.
	 *
	 * @param filmId L'ID del film da recuperare.
	 * @return ResponseEntity contenente il film trovato e lo stato HTTP OK, oppure
	 *         lo stato HTTP NOT FOUND se il film non è trovato.
	 */
	@PostMapping("/filmbyid")
	public ResponseEntity<Film> getFilmById(@RequestBody FilmId filmId) {
		Optional<Film> film;
		if (filmId.getNome() == null) {
			film = filmService.getFilmById(filmId.getId());
		} else {
			film = filmService.getFilmById(filmId.getId(), filmId.getNome());
		}
		return film.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Recupera un film per nome.
	 *
	 * @param payload Mappa contenente il nome del film da recuperare.
	 * @return ResponseEntity contenente il film trovato e lo stato HTTP OK, oppure
	 *         lo stato HTTP NOT FOUND se il film non è trovato.
	 */
	@PostMapping("/filmbynome")
	public ResponseEntity<Film> getFilmByNome(@RequestBody Map<String, String> payload) {
		String nome = payload.get("nome");
		Optional<Film> film = filmService.getFilmByNome(nome);
		return film.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
