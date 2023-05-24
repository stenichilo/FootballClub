package it.corso.service;

import java.util.List;

import it.corso.model.Prodotto;
import jakarta.servlet.http.HttpSession;

public interface ProdottoService {
	
	void registraProdotto(Object... datiProdotto);
	Prodotto getProdottoById(int id);
	List<Prodotto> getProdottiByCategoria(String categoria);
	void cancellaProdotto(Prodotto prodotto);
	void aggiungiACarrello(HttpSession session, int id);
	List<Prodotto> getProdottiAll();
	
}