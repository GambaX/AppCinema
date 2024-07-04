package com.gambax.appcinema.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.gambax.appcinema.model.Programmazione;

/**
 * Interfaccia per definire i metodi del servizio per gestire le operazioni
 * sulle programmazioni.
 */
public interface ProgrammazioneService {

	/**
	 * Salva una programmazione.
	 *
	 * @param programmazione La programmazione da salvare.
	 * @return La programmazione salvata.
	 */
	Programmazione saveProgrammazione(Programmazione programmazione);

	/**
	 * Recupera tutte le programmazioni.
	 *
	 * @return Una lista di tutte le programmazioni.
	 */
	List<Programmazione> getAllProgrammazioni();

	/**
	 * Recupera una programmazione per ID.
	 *
	 * @param id L'ID della programmazione.
	 * @return Un Optional contenente la programmazione trovata, o vuoto se non
	 *         trovata.
	 */
	Optional<Programmazione> getProgrammazioneById(Long id);

	/**
	 * Salva le programmazioni da un file Excel.
	 *
	 * @param file Il file Excel contenente le programmazioni.
	 * @throws IOException Se si verifica un errore durante la lettura del file.
	 */
	void saveProgrammazioneFromFile(MultipartFile file) throws IOException;

	/**
	 * Recupera tutte le programmazioni per il nome del film.
	 *
	 * @param filmNome Il nome del film.
	 * @return Una lista di programmazioni per il film specificato.
	 */
	List<Programmazione> getProgrammazioniByFilmNome(String filmNome);
}
