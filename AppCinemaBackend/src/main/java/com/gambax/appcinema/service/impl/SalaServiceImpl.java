package com.gambax.appcinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gambax.appcinema.model.Sala;
import com.gambax.appcinema.model.ids.SalaId;
import com.gambax.appcinema.repository.SalaRepository;
import com.gambax.appcinema.service.SalaService;

/**
 * Implementazione del servizio per gestire le operazioni sulle sale.
 */
@Service
public class SalaServiceImpl implements SalaService {

	@Autowired
	private SalaRepository salaRepository;

	/**
	 * Salva una sala nel repository.
	 *
	 * @param sala La sala da salvare.
	 * @return La sala salvata.
	 */
	@Override
	public Sala saveSala(Sala sala) {
		return salaRepository.save(sala);
	}

	/**
	 * Recupera tutte le sale dal repository.
	 *
	 * @return Una lista di tutte le sale.
	 */
	@Override
	public List<Sala> getAllSale() {
		return salaRepository.findAll();
	}

	/**
	 * Recupera una sala per ID e nome.
	 *
	 * @param id   L'ID della sala.
	 * @param nome Il nome della sala.
	 * @return Un Optional contenente la sala trovata, o vuoto se non trovata.
	 */
	@Override
	public Optional<Sala> getSalaById(Long id, String nome) {
		if (nome == null || nome.isEmpty()) {
			return salaRepository.findById(id);
		}
		return salaRepository.findById(new SalaId(id, nome));
	}

	/**
	 * Recupera una sala per nome.
	 *
	 * @param nome Il nome della sala.
	 * @return Un Optional contenente la sala trovata, o vuoto se non trovata.
	 */
	@Override
	public Optional<Sala> getSalaByNome(String nome) {
		return salaRepository.findByNome(nome);
	}
}
