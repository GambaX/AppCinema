package com.gambax.appcinema.controller;

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

import com.gambax.appcinema.model.Sala;
import com.gambax.appcinema.service.SalaService;

/**
 * Rest controller per gestire le operazioni sulle sale nel sistema cinema.
 * Gestisce le richieste HTTP per salvare, recuperare una sala per nome e
 * recuperare una sala per ID.
 */
@RestController
@RequestMapping("/cinema")
@CrossOrigin("*")
public class SalaController {

	@Autowired
	private SalaService salaService;

	/**
	 * Salva una nuova sala.
	 *
	 * @param sala La sala da salvare.
	 * @return ResponseEntity contenente la sala salvata e lo stato HTTP OK.
	 */
	@PostMapping("/savesala")
	public ResponseEntity<Sala> saveSala(@RequestBody Sala sala) {
		Sala s = salaService.saveSala(sala);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	/**
	 * Recupera una sala per nome.
	 *
	 * @param nome Il nome della sala da recuperare.
	 * @return ResponseEntity contenente la sala trovata e lo stato HTTP OK, oppure
	 *         lo stato HTTP NOT FOUND se la sala non è trovata.
	 */
	@PostMapping("/salabynome")
	public ResponseEntity<Sala> getSalaByNome(@RequestBody String nome) {
		Optional<Sala> sala = salaService.getSalaByNome(nome);
		return sala.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Recupera una sala per ID e nome.
	 *
	 * @param payload Mappa contenente l'ID e il nome della sala da recuperare.
	 * @return ResponseEntity contenente la sala trovata e lo stato HTTP OK, oppure
	 *         lo stato HTTP NOT FOUND se la sala non è trovata.
	 */
	@PostMapping("/salabyid")
	public ResponseEntity<Sala> getSalaById(@RequestBody Map<String, Object> payload) {
		Long id = ((Number) payload.get("id")).longValue();
		String nome = (String) payload.get("nome");

		Optional<Sala> sala = salaService.getSalaById(id, nome);
		return sala.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
