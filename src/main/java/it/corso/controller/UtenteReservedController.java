package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.model.Utente;
import it.corso.service.OrdineService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/utenteReserved")
public class UtenteReservedController {

	@Autowired
	private OrdineService ordineService;
	
	
	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam(name="oa", required = false) String oa) {
		model.addAttribute("utente", session.getAttribute("utente"));
		model.addAttribute("ordini", ordineService.getOrdineByUtente((Utente) session.getAttribute("utente")));
		model.addAttribute("carrello", session.getAttribute("carrello"));
		model.addAttribute("oa", oa);
	return "utenteReserved";
	}
	
	
	@GetMapping("/inviaOrdine")
	public String inviaOrdine(HttpSession session) {
		ordineService.registraOrdine(session);
		List<Prodotto> carrello = (List<Prodotto>) session.getAttribute("carrello");
		carrello.clear();
		session.setAttribute("carrello", carrello);
		return "redirect:/utenteReserved?oa";
	}
}
