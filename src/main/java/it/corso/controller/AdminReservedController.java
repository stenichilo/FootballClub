package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.service.AdminService;
import it.corso.service.ProdottoService;
import it.corso.service.UtenteService;

@Controller
@RequestMapping("/adminReserved")
public class AdminReservedController {

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping
	public String getPage(Model model) {
		model.addAttribute("utenti", utenteService.getUtenti());
		model.addAttribute("prodotti", prodottoService.getProdotti());
		return "adminReserved";
	}
	
	
	@PostMapping("/registraProdotto")
	public String registraProdotto(@RequestParam("nome") String nome,
			@RequestParam("descrizione")String descrizione,
			@RequestParam("categoria")String categoria,
			@RequestParam(name="immagine", required = false)MultipartFile immagine,
			@RequestParam("prezzo") double prezzo
			) {
		prodottoService.registraProdotto(nome, descrizione, categoria, immagine, prezzo);
		return "redirect:/adminReserved";
	}
	
}
