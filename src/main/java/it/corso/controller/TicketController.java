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
import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private ProdottoService prodottoService;

	@GetMapping
	public String getPage(Model model,
			@RequestParam(name="min", required = false) Double min,
			@RequestParam(name="max", required = false) Double max) {

		List<Prodotto> biglietti = new ArrayList<>();
		List<Prodotto> abbonamenti = new ArrayList<>();

		for (Prodotto p : prodottoService.getProdottiAll()) {
			if (p.getCategoria().equals("biglietti")) {
				biglietti.add(p);
			} else if (p.getCategoria().equals("abbonamenti")) {
				abbonamenti.add(p);
			}
		}
		
		if(min != null) {
			for(Prodotto p : abbonamenti) {
				if(p.getPrezzo()<min) {
					abbonamenti.remove(p);
				}
			}
			for(Prodotto p : biglietti) {
				if(p.getPrezzo()<min) {
					biglietti.remove(p);
				}
			}
		}
		
		if(max != null) {
			for(Prodotto p : abbonamenti) {
				if(p.getPrezzo()>max) {
					abbonamenti.remove(p);
				}
			}
			for(Prodotto p : biglietti) {
				if(p.getPrezzo()>max) {
					biglietti.remove(p);
				}
			}
		}

		
		model.addAttribute("abbonamenti", abbonamenti);
		model.addAttribute("biglietti", biglietti);

		return "ticket";
	}
}
