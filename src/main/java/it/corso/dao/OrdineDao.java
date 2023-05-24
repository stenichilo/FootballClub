package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Ordine;
import it.corso.model.Utente;

import java.util.List;


public interface OrdineDao extends CrudRepository<Ordine, Integer>{

	List<Ordine> findByUtente(Utente utente);
}
