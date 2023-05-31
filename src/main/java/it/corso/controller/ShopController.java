package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.ProdottoService;
import jakarta.servlet.http.HttpSession;
import it.corso.model.Admin;
import it.corso.model.Prodotto;
import it.corso.model.Utente;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ProdottoService prodottoService;

	@GetMapping
	public String getPage(Model model, 
			@RequestParam(name = "categoria", required = false) String categoria,
			@RequestParam(name = "min", required = false) Double min,
			@RequestParam(name = "max", required = false) Double max,
			HttpSession session) {

		List<Prodotto> catalogo = categoria== null || categoria.isEmpty() ? new ArrayList<>()
				: prodottoService.getProdottiByCategoria(categoria);

		if (categoria== null || categoria.isEmpty()) {
			for (Prodotto p : prodottoService.getProdottiAll()) {
				if (!(p.getCategoria().equals("biglietti")) && !(p.getCategoria().equals("abbonamenti"))) {
					catalogo.add(p);
				}
			}
		}

		if (min != null) {
			catalogo.removeIf(k -> k.getPrezzo() < min);
		}

		if (max != null) {
			catalogo.removeIf(k -> k.getPrezzo() > max);
		}
		if(session.getAttribute("utente") != null) {
			Utente utente = (Utente) session.getAttribute("utente");
			model.addAttribute("utente", utente);
		}
		
		if(session.getAttribute("admin") != null) {
			Admin admin = (Admin) session.getAttribute("admin");
			model.addAttribute("admin", admin);
		}
		model.addAttribute("catalogo", catalogo);
		model.addAttribute("noResult", catalogo.isEmpty());
		
		return "shop";
	}

}
