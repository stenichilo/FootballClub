package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;
import jakarta.servlet.http.HttpSession;

public interface OrdineService {

	public void registraOrdine(HttpSession session);
	Ordine getOrdineById(int id);
	List<Ordine> getOrdini();
	void eliminaOrdine(Ordine ordine);
	
	
	
}
