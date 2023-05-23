package it.corso.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corso.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {

	@Query(value="SELECT * FROM admin WHERE username=:desc", nativeQuery = true)
	Optional<Admin> findByUsername(@Param("desc") String username);
}
