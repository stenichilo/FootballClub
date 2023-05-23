package it.corso.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import it.corso.model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Integer>{

	@Query(value="SELECT * FROM utenti WHERE username=:desc", nativeQuery = true)
	Utente findByUsernameAndPassword(String username, String password);
}
