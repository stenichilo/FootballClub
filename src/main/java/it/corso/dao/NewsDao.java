package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.News;

public interface NewsDao extends CrudRepository<News, Integer> {

	@Query(value="SELECT * FROM news ORDER BY id desc LIMIT 4", nativeQuery = true)
	List<News> getNews();
}
