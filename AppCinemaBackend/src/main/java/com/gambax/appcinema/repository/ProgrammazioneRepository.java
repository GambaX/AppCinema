package com.gambax.appcinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gambax.appcinema.model.Programmazione;

/**
 * Repository per gestire le operazioni di accesso ai dati della tabella
 * "programmazione". Estende JpaRepository per fornire metodi CRUD standard.
 */
@Repository
public interface ProgrammazioneRepository extends JpaRepository<Programmazione, Long> {

	/**
	 * Trova tutte le programmazioni per il nome del film.
	 *
	 * @param filmNome Il nome del film.
	 * @return Una lista di programmazioni per il film specificato.
	 */
	List<Programmazione> findByFilmNome(String filmNome);
}
