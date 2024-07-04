package com.gambax.appcinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gambax.appcinema.model.User;
import com.gambax.appcinema.service.UserService;

/**
 * Rest controller per gestire le operazioni sugli utenti nel sistema cinema.
 * Gestisce le richieste HTTP per registrare e autenticare un utente.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Registra un nuovo utente.
	 *
	 * @param user L'utente da registrare.
	 * @return ResponseEntity contenente l'utente registrato e lo stato HTTP OK.
	 */
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User registeredUser = userService.registerUser(user);
		return ResponseEntity.ok(registeredUser);
	}

	/**
	 * Autentica un utente.
	 *
	 * @param user L'utente da autenticare.
	 * @return ResponseEntity contenente l'utente autenticato e lo stato HTTP OK,
	 *         oppure lo stato HTTP 401 con un messaggio di errore se
	 *         l'autenticazione fallisce.
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
		if (loggedInUser != null) {
			return ResponseEntity.ok(loggedInUser);
		} else {
			return ResponseEntity.status(401).body("Invalid username or password");
		}
	}
}
