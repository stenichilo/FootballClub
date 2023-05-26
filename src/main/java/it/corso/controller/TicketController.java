package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private ProdottoService prodottoService;

	@GetMapping
	public String getPage(Model model) {

		List<Prodotto> biglietti = new ArrayList<>();
		List<Prodotto> abbonamenti = new ArrayList<>();

		for (Prodotto p : prodottoService.getProdottiAll()) {
			if (p.getCategoria().equals("biglietti")) {
				biglietti.add(p);
			} else if (p.getCategoria().equals("abbonamenti")) {
				abbonamenti.add(p);
			}
		}
		model.addAttribute("abbonamenti", abbonamenti);
		model.addAttribute("biglietti", biglietti);

		return "ticket";
	}
}
