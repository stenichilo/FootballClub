package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.AdminService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public String getPage(@RequestParam(name="le", required = false) String le) {
		
		return "indexProva";
	}
	
	@PostMapping
	public String login(
			HttpSession session, 
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		if (adminService.controlloLogin(session, username, password)) {
			return "redirect:/provaReserved";
		} else {
			return "redirect:/?le";
		}
		
	}
}
