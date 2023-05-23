package it.corso.service;

import java.util.List;

import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

public interface UtenteService {
	
	void registraUtente(Utente utente);
	Utente getUtenteById(int id);
	List<Utente> getUtenti();
	void eliminaUtente(Utente utente);
	Utente getUtenteByUsername(String username);
	boolean controlloLogin(HttpSession session, String username, String password);

}
