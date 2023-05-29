package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.service.OrdineService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/utenteReserved")
public class UtenteReservedController {

	@Autowired
	private OrdineService ordineService;
	
	
	
	@GetMapping
	public String getPage(Model model, 
			HttpSession session, 
			@RequestParam(name="oa", required = false) String oa
			) {
		
		// condizione per verificare se l'utente è loggato, se non loggato rimanda a pagina di login
		if(session.getAttribute("utente") == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("utente", session.getAttribute("utente"));
		model.addAttribute("carrello", session.getAttribute("carrello"));
		model.addAttribute("oa", oa != null);
	return "utenteReserved";
	}
	
	
	@GetMapping("/inviaOrdine")
	public String inviaOrdine(HttpSession session) {
		ordineService.registraOrdine(session);
		session.setAttribute("carrello", new ArrayList<Prodotto>());
		return "redirect:/utenteReserved?oa";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/eliminaDaCarrello")
	public String eliminaDaCarrello(@RequestParam("id") int id,
			HttpSession session) {
		List<Prodotto> carrello = (List<Prodotto>) session.getAttribute("carrello");
		for(Prodotto p:carrello) {
			if(p.getId()==id) {
				carrello.remove(p);
				break;
			}
		}
		session.setAttribute("carrello", carrello);
		return "redirect:/utenteReserved";
	}
	
}
