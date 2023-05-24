package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Prodotto;
import java.util.List;


public interface ProdottoDao extends CrudRepository<Prodotto, Integer>{

	List<Prodotto> findByCategoria(String categoria);
}
