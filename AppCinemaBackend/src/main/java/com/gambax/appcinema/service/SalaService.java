package com.gambax.appcinema.service;

import java.util.List;
import java.util.Optional;

import com.gambax.appcinema.model.Sala;

/**
 * Interfaccia per definire i metodi del servizio per gestire le operazioni
 * sulle sale.
 */
public interface SalaService {

	/**
	 * Salva una sala.
	 *
	 * @param sala La sala da salvare.
	 * @return La sala salvata.
	 */
	Sala saveSala(Sala sala);

	/**
	 * Recupera tutte le sale.
	 *
	 * @return Una lista di tutte le sale.
	 */
	List<Sala> getAllSale();

	/**
	 * Recupera una sala per ID e nome.
	 *
	 * @param id   L'ID della sala.
	 * @param nome Il nome della sala.
	 * @return Un Optional contenente la sala trovata, o vuoto se non trovata.
	 */
	Optional<Sala> getSalaById(Long id, String nome);

	/**
	 * Recupera una sala per nome.
	 *
	 * @param nome Il nome della sala.
	 * @return Un Optional contenente la sala trovata, o vuoto se non trovata.
	 */
	Optional<Sala> getSalaByNome(String nome);
}
