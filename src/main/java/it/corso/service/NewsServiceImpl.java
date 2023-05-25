package it.corso.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import it.corso.dao.NewsDao;
import it.corso.model.News;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Override
	public void registraNews(News news, Object... dati) {
		String titolo = (String) dati[0];
		String descrizione = (String) dati[1];
		MultipartFile immagine = (MultipartFile) dati[2];
		news.setTitolo(titolo);
		news.setDescrizione(descrizione);
		if(immagine!=null && !immagine.isEmpty()) {
			try {
				String contentType = immagine.getContentType();
				news.setImmagine("data:" + contentType + ";base64,"+ Base64.getEncoder().encodeToString(immagine.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// registrazione del libro
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
