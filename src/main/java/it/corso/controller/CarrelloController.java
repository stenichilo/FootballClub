package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Ordine;
import it.corso.model.Prodotto;
import it.corso.service.OrdineService;
import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/carrello")
public class CarrelloController {
	
	@Autowired
	private OrdineService ordineService;

	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam(name="oa", required = false) String oa) {
		List<Prodotto> carrello = session.getAttribute("carrello") == null ? new ArrayList<>()
				: (List<Prodotto>) session.getAttribute("carrello");

		model.addAttribute("carrello", carrello);
		model.addAttribute("oa", oa != null);
		return "carrello";
	}
	
	
	@GetMapping("/creaOrdine")
	public String creaOrdine(HttpSession session) {
		ordineService.registraOrdine(session);
		return "redirect:/carrello?oa";
	}
	
}
