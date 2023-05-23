package it.corso.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.UtenteDao;
import it.corso.model.Admin;
import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDao utenteDao;
	
	@Override
	public void registraUtente(Utente utente) {
		utenteDao.save(utente);

	}

	@Override
	public Utente getUtenteById(int id) {
		
		return utenteDao.findById(id).get();
	}

	@Override
	public List<Utente> getUtenti() {
	
		return (List<Utente>) utenteDao.findAll();
	}

	@Override
	public void eliminaUtente(Utente utente) {
		utenteDao.delete(utente);

	}

	@Override
	public Utente getUtenteByUsername(String username) {
		Optional<Utente> optional = utenteDao.findByUsername(username);
		if(optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}
	
	@Override
	public boolean controlloLogin(HttpSession session, String username, String password) {
		if(getUtenteByUsername(username) == null) {
			return false;
		} else {
			Utente utente = getUtenteByUsername(username);
			if (utente.getPassword().equals(password)){
				session.setAttribute("utente", utente);
				return true;
			} else {
				return false;
			}
		}
		
	}
	

}
