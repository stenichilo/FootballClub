package it.corso.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.OrdineDao;
import it.corso.dao.UtenteDao;
import it.corso.model.Ordine;
import it.corso.model.Prodotto;
import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

@Service
public class OrdineServiceImpl implements OrdineService {

	
	@Autowired
	private OrdineDao ordineDao;
	
	@Autowired
	private UtenteDao utenteDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public void registraOrdine(HttpSession session) {
		Ordine ordine = new Ordine();
		ordine.setData(LocalDate.now());
		Utente utente = utenteDao.findById(((Utente)session.getAttribute("utente")).getId()).get();
		ordine.setUtente(utente);
		ordine.setProdotti((List<Prodotto>) session.getAttribute("carrello"));
		double importo = 0;
		for (Prodotto p:ordine.getProdotti()) {
			importo+=p.getPrezzo();
		}
		ordine.setImporto(importo);
		ordineDao.save(ordine);

	}

	@Override
	public Ordine getOrdineById(int id) {

		return ordineDao.findById(id).get();
	}

	@Override
	public List<Ordine> getOrdini() {
		
		return (List<Ordine>) ordineDao.findAll();
	}

	@Override
	public void eliminaOrdine(Ordine ordine) {
		ordineDao.delete(ordine);

	}

}
