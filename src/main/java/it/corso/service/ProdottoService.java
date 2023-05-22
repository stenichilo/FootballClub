package it.corso.service;

import java.util.List;

import it.corso.model.Prodotto;

public interface ProdottoService {
	
	void registraProdotto(Object... datiProdotto);
	Prodotto getProdottoById(int id);
	List<Prodotto> getProdotti();
	void cancellaProdotto(Prodotto prodotto);
	
}