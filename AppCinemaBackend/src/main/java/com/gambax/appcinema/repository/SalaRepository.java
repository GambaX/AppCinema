package com.gambax.appcinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gambax.appcinema.model.Sala;
import com.gambax.appcinema.model.ids.SalaId;

/**
 * Repository per gestire le operazioni di accesso ai dati della tabella "sala".
 * Estende JpaRepository per fornire metodi CRUD standard.
 */
public interface SalaRepository extends JpaRepository<Sala, SalaId> {

	/**
	 * Trova una sala per ID.
	 *
	 * @param id L'ID della sala.
	 * @return Un Optional contenente la sala trovata, o vuoto se non trovata.
	 */
	Optional<Sala> findById(Long id);

	/**
	 * Trova una sala per nome.
	 *
	 * @param nome Il nome della sala.
	 * @return Un Optional contenente la sala trovata, o vuoto se non trovata.
	 */
	Optional<Sala> findByNome(String nome);
}
