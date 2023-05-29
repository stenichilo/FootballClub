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
import it.corso.model.Prodotto;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ProdottoService prodottoService;

	@GetMapping
	public String getPage(Model model, 
			@RequestParam(name = "categoria", required = false) String categoria,
			@RequestParam(name = "min", required = false) Double min,
			@RequestParam(name = "max", required = false) Double max) {

		List<Prodotto> catalogo = categoria == null ? new ArrayList<>()
				: prodottoService.getProdottiByCategoria(categoria);

		if (categoria == null) {
			for (Prodotto p : prodottoService.getProdottiAll()) {
				if (!(p.getCategoria().equals("biglietti")) && !(p.getCategoria().equals("abbonamenti"))) {
					catalogo.add(p);
				}
			}
		}

		if (min != null) {
			for (Prodotto p : catalogo) {
				if (p.getPrezzo() < min) {
					catalogo.remove(p);
				}
			}
		}

		if (max != null) {
			for (Prodotto p : catalogo) {
				if (p.getPrezzo() > max) {
					catalogo.remove(p);
				}
			}

		}

		model.addAttribute("catalogo", catalogo);

		return "shop";
	}

}
