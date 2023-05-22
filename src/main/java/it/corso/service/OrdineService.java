package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;

public interface OrdineService {

	void registraOrdine(Ordine ordine, Object...datiOrdine);
	Ordine getOrdineById(int id);
	List<Ordine> getOrdini();
	void eliminaOrdine(Ordine ordine);
	
	
	
}
