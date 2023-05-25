package it.corso.service;

import java.util.List;

import it.corso.model.News;

public interface NewsService {

	public void registraNews(News news, Object... dati);
	News getNewsById(int id);
	List<News> getNews();
	void eliminaNews(News news);
}
