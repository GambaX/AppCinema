package com.gambax.appcinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gambax.appcinema.model.User;
import com.gambax.appcinema.repository.UserRepository;

/**
 * Servizio per gestire le operazioni sugli utenti.
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Registra un nuovo utente. Attualmente la password non viene criptata, ma
	 * viene salvata in chiaro. Implementazione della criptazione TODO.
	 *
	 * @param user L'utente da registrare.
	 * @return L'utente registrato.
	 */
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * Autentica un utente.
	 *
	 * @param username Il nome utente dell'utente.
	 * @param password La password dell'utente.
	 * @return L'utente autenticato se le credenziali sono corrette, altrimenti
	 *         null.
	 */
	public User loginUser(String username, String password) {
		User user = userRepository.findByUsername(username).orElse(null);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
