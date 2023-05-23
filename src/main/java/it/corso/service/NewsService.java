package it.corso.service;

import java.util.List;

import it.corso.model.News;

public interface NewsService {

	void registraNews(News news, Object...datiNews);
	News getNewsById(int id);
	List<News> getOrdini();
	void eliminaNews(News news);
}
