package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Utente;
import it.corso.service.AdminService;
import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UtenteService utenteService;
	
	
	
	@GetMapping
	public String getPage() {
		
		return "login";
	}
	
	
	@PostMapping("/check")
	public String loginAdmin(HttpSession session,
			 @RequestParam("username") String username,
			 @RequestParam("password") String password) {
		if (adminService.controlloLogin(session, username, password)) {
			return "redirect:/adminReserved";
		} else if (utenteService.controlloLogin(session, username, password)) {
			return "redirect:/utenteReserved";
		} else {
			return "redirect:/le";
		}
		
	}
	
	@PostMapping("/registrazione")
	public String registraUtente(@Valid @ModelAttribute("utente") Utente utente, BindingResult result) {
		
		if(result.hasErrors()) {
			return "index";
		}
		utenteService.registraUtente(utente);
		return "redirect:/";
	}
}
