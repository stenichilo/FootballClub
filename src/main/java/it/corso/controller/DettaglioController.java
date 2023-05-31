package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Admin;
import it.corso.model.Utente;
import it.corso.service.ProdottoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

	@Autowired
	private ProdottoService prodottoService;
	
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam("id") int id, 
			@RequestParam(name="pa", required = false) String pa, HttpSession session) {
		model.addAttribute("prodotto", prodottoService.getProdottoById(id));
		model.addAttribute("pa", pa != null);
		if(session.getAttribute("utente") != null) {
			Utente utente = (Utente) session.getAttribute("utente");
			model.addAttribute("utente", utente);
		}
		
		if(session.getAttribute("admin") != null) {
			Admin admin = (Admin) session.getAttribute("admin");
			model.addAttribute("admin", admin);
		}
		return "dettaglio";
	}
	
	
	@GetMapping("/aggiungi")
	public String aggiungiACarrello(HttpSession session, @RequestParam("id") int id) {
		prodottoService.aggiungiACarrello(session, id);
		return "redirect:/dettaglio?id="+id+"&pa";
	}
}
