package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/shop")
public class ShopController {

	
	@Autowired
	private ProdottoService prodottoService;
	
	
	@GetMapping
	public String getPage(Model model) {
		
		model.addAttribute("catalogo", prodottoService.getProdotti("prodotti"));
		
		return "shop";
	}
}
