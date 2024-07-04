package com.gambax.appcinema.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gambax.appcinema.model.Programmazione;
import com.gambax.appcinema.service.ProgrammazioneService;

/**
 * Rest controller per gestire le operazioni sulle programmazioni nel sistema
 * cinema. Gestisce le richieste HTTP per salvare, recuperare tutte le
 * programmazioni, recuperare una programmazione per ID, caricare un file di
 * programmazione e recuperare programmazioni per nome del film.
 */
@RestController
@RequestMapping("/cinema")
@CrossOrigin("*")
public class ProgrammazioneController {

	@Autowired
	private ProgrammazioneService programmazioneService;

	/**
	 * Salva una nuova programmazione.
	 *
	 * @param programmazione La programmazione da salvare.
	 * @return ResponseEntity contenente la programmazione salvata e lo stato HTTP
	 *         OK.
	 */
	@PostMapping("/saveprogrammazione")
	public ResponseEntity<Programmazione> saveProgrammazione(@RequestBody Programmazione programmazione) {
		Programmazione savedProgrammazione = programmazioneService.saveProgrammazione(programmazione);
		return new ResponseEntity<>(savedProgrammazione, HttpStatus.OK);
	}

	/**
	 * Recupera tutte le programmazioni.
	 *
	 * @return ResponseEntity contenente la lista di tutte le programmazioni e lo
	 *         stato HTTP OK.
	 */
	@GetMapping("/allprogrammazioni")
	public ResponseEntity<List<Programmazione>> getAllProgrammazioni() {
		List<Programmazione> programmazioni = programmazioneService.getAllProgrammazioni();
		return new ResponseEntity<>(programmazioni, HttpStatus.OK);
	}

	/**
	 * Recupera una programmazione per ID.
	 *
	 * @param id L'ID della programmazione da recuperare.
	 * @return ResponseEntity contenente la programmazione trovata e lo stato HTTP
	 *         OK, oppure lo stato HTTP NOT FOUND se la programmazione non è
	 *         trovata.
	 */
	@PostMapping("/programmazionebyid")
	public ResponseEntity<Programmazione> getProgrammazioneById(@RequestBody Long id) {
		Optional<Programmazione> programmazione = programmazioneService.getProgrammazioneById(id);
		return programmazione.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Carica un file di programmazione.
	 *
	 * @param file Il file di programmazione da caricare.
	 * @return ResponseEntity contenente lo stato HTTP OK se il caricamento è
	 *         riuscito, oppure lo stato HTTP INTERNAL SERVER ERROR in caso di
	 *         errore.
	 */
	@PostMapping("/uploadprogrammazione")
	public ResponseEntity<Void> uploadProgrammazioneFile(@RequestParam("file") MultipartFile file) {
		try {
			programmazioneService.saveProgrammazioneFromFile(file);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Recupera programmazioni per nome del film.
	 *
	 * @param filmNome Il nome del film per cui recuperare le programmazioni.
	 * @return Lista di programmazioni per il film specificato.
	 */
	@GetMapping("/programmazionefilm")
	public List<Programmazione> getProgrammazioniByFilmNome(@RequestParam String filmNome) {
		return programmazioneService.getProgrammazioniByFilmNome(filmNome);
	}
}
