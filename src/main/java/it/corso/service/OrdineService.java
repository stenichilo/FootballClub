package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;

public interface OrdineService {

	public void registraOrdine(Ordine ordine);
	Ordine getOrdineById(int id);
	List<Ordine> getOrdini();
	void eliminaOrdine(Ordine ordine);
	
	
	
}
