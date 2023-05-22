package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.News;

public interface NewsDao extends CrudRepository<News, Integer> {

}
