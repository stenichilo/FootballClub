package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;
import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

public interface OrdineService {

	public void registraOrdine(HttpSession session);
	Ordine getOrdineById(int id);
	List<Ordine> getOrdini();
	void eliminaOrdine(Ordine ordine);
	List<Ordine> getOrdineByUtente(Utente utente);
	
	
}
