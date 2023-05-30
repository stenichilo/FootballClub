package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.News;
import it.corso.model.Prodotto;
import it.corso.service.NewsService;
import it.corso.service.ProdottoService;
import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminReserved")
public class AdminReservedController {

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired
	private UtenteService utenteService;
	
	private Prodotto prodotto;
	
	private News news;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam(name="scheda", required = false) Integer scheda,
			@RequestParam(name="pi", required = false) String pi,
			@RequestParam(name="ni", required = false) String ni,
			@RequestParam(name="idProdotto", required = false) Integer idProdotto,
			@RequestParam(name="idNews", required = false) Integer idNews,
			HttpSession session) {
		
		if(session.getAttribute("admin") == null) {
			return "redirect:/login";
		}
		model.addAttribute("admin", session.getAttribute("admin"));
		model.addAttribute("utenti", utenteService.getUtenti());
		model.addAttribute("prodotti", prodottoService.getProdottiByCategoria("prodotti"));
		model.addAttribute("biglietti", prodottoService.getProdottiByCategoria("biglietti"));
		model.addAttribute("catalogo", prodottoService.getProdottiAll());
		model.addAttribute("novita", newsService.getAllNews());
		model.addAttribute("pi", pi != null);
		model.addAttribute("ni", ni != null);
		prodotto = idProdotto == null ? new Prodotto() : prodottoService.getProdottoById(idProdotto);
		news = idNews == null ? new News() : newsService.getNewsById(idNews);
		model.addAttribute("prodotto", prodotto);
		model.addAttribute("news", news);
		model.addAttribute("scheda", scheda);
		return "adminReserved";
	}
	
	
	@PostMapping("/registraProdotto")
	public String registraProdotto(@RequestParam("nome") String nome,
			@RequestParam("descrizione")String descrizione,
			@RequestParam("dettaglio")String dettaglio,
			@RequestParam("categoria")String categoria,
			@RequestParam(name="immagine", required = false)MultipartFile immagine,
			@RequestParam("prezzo") double prezzo
			) {
		prodottoService.registraProdotto(prodotto, nome, descrizione, dettaglio, categoria, immagine, prezzo);
		return "redirect:/adminReserved?scheda=2&pi";
	}
	
	
	@PostMapping("/registraNews")
	public String registraNews(@RequestParam("titolo") String titolo,
			@RequestParam("descrizione") String descrizione,
			@RequestParam(name="immagine", required = false) MultipartFile immagine) {
		newsService.registraNews(news, titolo, descrizione, immagine);
		return "redirect:/adminReserved?scheda=1&ni";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/eliminaNews")
	public String eliminaNews(@RequestParam("id") int id) {
		News news = newsService.getNewsById(id);
		newsService.eliminaNews(news);
		return "redirect:/adminReserved";
	}
	
	
	@GetMapping("/eliminaProdotto")
	public String eliminaProdotto(@RequestParam("id") int id) {
		Prodotto prodotto = prodottoService.getProdottoById(id);
		prodottoService.cancellaProdotto(prodotto);
		return "redirect:/adminReserved";
	}
}
