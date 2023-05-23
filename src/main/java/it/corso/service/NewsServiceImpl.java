package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.NewsDao;
import it.corso.model.News;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Override
	public void registraNews(News news) {
		newsDao.save(news);

	}

	@Override
	public News getNewsById(int id) {
		
		return newsDao.findById(id).get();
	}

	@Override
	public List<News> getNews() {
		
		return (List<News>) newsDao.findAll();
	}

	@Override
	public void eliminaNews(News news) {
		newsDao.delete(news);

	}

}
