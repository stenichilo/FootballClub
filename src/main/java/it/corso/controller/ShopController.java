package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.ProdottoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop")
public class ShopController {

	
	@Autowired
	private ProdottoService prodottoService;
	
	
	@GetMapping
	public String getPage(Model model) {
		
		model.addAttribute("catalogo", prodottoService.getProdottiByCategoria("prodotti"));
		
		return "shop";
	}
	
	
}
