package it.corso.service;


import jakarta.servlet.http.HttpSession;

public interface AdminService {
	
	
	
	boolean controlloLogin(HttpSession session, String username, String password);
}
