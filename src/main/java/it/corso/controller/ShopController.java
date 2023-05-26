package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.service.ProdottoService;
import it.corso.model.Prodotto;


@Controller
@RequestMapping("/shop")
public class ShopController {

	
	@Autowired
	private ProdottoService prodottoService;
	
	
	@GetMapping
	public String getPage(Model model) {
		
		List<Prodotto> catalogo = new ArrayList<>();
		
		for(Prodotto p:prodottoService.getProdottiAll()) {
			if (!(p.getCategoria().equals("biglietti")) && !(p.getCategoria().equals("abbonamenti"))) {
				catalogo.add(p);
			}
		}
		
		model.addAttribute("catalogo", catalogo);
		
		return "shop";
	}
	
	
}
