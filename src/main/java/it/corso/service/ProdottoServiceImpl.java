package it.corso.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.dao.ProdottoDao;
import it.corso.model.Prodotto;


@Service
public class ProdottoServiceImpl implements ProdottoService {
	
	
	@Autowired
	private ProdottoDao prodottoDao;

	@Override
	public void registraProdotto(Object... datiProdotto) {
		Prodotto prodotto = new Prodotto();
		String nome = (String) datiProdotto[0];
		String descrizione = (String) datiProdotto[1];
		String categoria = (String) datiProdotto[2];
		MultipartFile immagine = (MultipartFile) datiProdotto[3];
		double prezzo = (double) datiProdotto[4];
		prodotto.setNome(nome);
		prodotto.setDescrizione(descrizione);
		prodotto.setCategoria(categoria);
		if(immagine!=null && !immagine.isEmpty()) {
			try {
				String contentType = immagine.getContentType();
				prodotto.setImmagine("data:" + contentType + ";base64,"+ Base64.getEncoder().encodeToString(immagine.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		prodotto.setPrezzo(prezzo);
		prodottoDao.save(prodotto);
	}
	

	@Override
	public Prodotto getProdottoById(int id) {
		
		return prodottoDao.findById(id).get();
	}

	@Override
	public List<Prodotto> getProdotti(String categoria) {
		
		return (List<Prodotto>) prodottoDao.findByCategoria(categoria);
	}

	@Override
	public void cancellaProdotto(Prodotto prodotto) {
		prodottoDao.delete(prodotto);

	}

}
