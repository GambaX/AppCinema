package com.gambax.appcinema.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gambax.appcinema.model.Film;
import com.gambax.appcinema.model.Programmazione;
import com.gambax.appcinema.model.Sala;
import com.gambax.appcinema.repository.FilmRepository;
import com.gambax.appcinema.repository.ProgrammazioneRepository;
import com.gambax.appcinema.repository.SalaRepository;
import com.gambax.appcinema.service.ProgrammazioneService;

/**
 * Implementazione del servizio per gestire le operazioni sulle programmazioni.
 */
@Service
public class ProgrammazioneServiceImpl implements ProgrammazioneService {

	@Autowired
	private ProgrammazioneRepository programmazioneRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private SalaRepository salaRepository;

	/**
	 * Salva una programmazione nel repository.
	 *
	 * @param programmazione La programmazione da salvare.
	 * @return La programmazione salvata.
	 */
	@Override
	public Programmazione saveProgrammazione(Programmazione programmazione) {
		return programmazioneRepository.save(programmazione);
	}

	/**
	 * Recupera tutte le programmazioni dal repository.
	 *
	 * @return Una lista di tutte le programmazioni.
	 */
	@Override
	public List<Programmazione> getAllProgrammazioni() {
		return programmazioneRepository.findAll();
	}

	/**
	 * Recupera una programmazione per ID.
	 *
	 * @param id L'ID della programmazione.
	 * @return Un Optional contenente la programmazione trovata, o vuoto se non
	 *         trovata.
	 */
	@Override
	public Optional<Programmazione> getProgrammazioneById(Long id) {
		return programmazioneRepository.findById(id);
	}

	/**
	 * Salva le programmazioni da un file Excel.
	 *
	 * @param file Il file Excel contenente le programmazioni.
	 * @throws IOException Se si verifica un errore durante la lettura del file.
	 */
	@Override
	public void saveProgrammazioneFromFile(MultipartFile file) throws IOException {
		List<Programmazione> programmazioni = new ArrayList<>();

		try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				if (row.getRowNum() == 0) {
					continue; // Salta l'intestazione
				}

				Programmazione programmazione = new Programmazione();

				if (row.getCell(0).getCellType() == CellType.STRING) {
					programmazione.setDataInizio(LocalDate.parse(row.getCell(0).getStringCellValue()));
				} else {
					programmazione.setDataInizio(row.getCell(0).getLocalDateTimeCellValue().toLocalDate());
				}

				if (row.getCell(1).getCellType() == CellType.STRING) {
					programmazione.setDataFine(LocalDate.parse(row.getCell(1).getStringCellValue()));
				} else {
					programmazione.setDataFine(row.getCell(1).getLocalDateTimeCellValue().toLocalDate());
				}

				String filmNome = row.getCell(2).getStringCellValue();
				Optional<Film> filmOptional = filmRepository.findByNome(filmNome);
				Film film = filmOptional.orElseGet(() -> {
					Film newFilm = new Film();
					newFilm.setId(generateNewFilmId());
					newFilm.setNome(filmNome);
					newFilm.setRegia(row.getCell(3).getStringCellValue());
					newFilm.setDurata((int) row.getCell(4).getNumericCellValue());
					newFilm.setGenere(row.getCell(5).getStringCellValue());
					newFilm.setCoverUrl(row.getCell(6).getStringCellValue());
					return filmRepository.save(newFilm);
				});

				String salaNome = row.getCell(7).getStringCellValue();
				Sala sala = salaRepository.findByNome(salaNome)
						.orElseThrow(() -> new IllegalArgumentException("Sala non trovata: " + salaNome));

				programmazione.setFilmId(film.getId());
				programmazione.setSalaId(sala.getId());
				programmazione.setSalaNome(salaNome);
				programmazione.setFilmNome(filmNome);

				programmazioni.add(programmazione);
			}
		}

		programmazioneRepository.saveAll(programmazioni);
	}

	/**
	 * Genera un nuovo ID per un film.
	 *
	 * @return Un nuovo ID per un film.
	 */
	private Long generateNewFilmId() {
		return filmRepository.findAll().stream().mapToLong(Film::getId).max().orElse(0L) + 1;
	}

	/**
	 * Recupera tutte le programmazioni per il nome del film.
	 *
	 * @param filmNome Il nome del film.
	 * @return Una lista di programmazioni per il film specificato.
	 */
	@Override
	public List<Programmazione> getProgrammazioniByFilmNome(String filmNome) {
		return programmazioneRepository.findByFilmNome(filmNome);
	}
}
