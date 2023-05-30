package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/contatti")
public class ContattiController {

	@GetMapping
	public String getPage(HttpSession session, Model model) {
		model.addAttribute("utente", session.getAttribute("utente") != null);
		model.addAttribute("admin", session.getAttribute("admin") != null);
		return "contatti";
	}
}
