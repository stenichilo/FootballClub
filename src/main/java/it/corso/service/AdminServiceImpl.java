package it.corso.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.AdminDao;
import it.corso.model.Admin;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin getAdminByUsername(String username) {
		Optional<Admin> optional = adminDao.findByUsername(username);
		if(optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
		
	}

	@Override
	public boolean controlloLogin(HttpSession session, String username, String password) {
		if(getAdminByUsername(username) == null) {
			return false;
		} else {
			Admin admin = getAdminByUsername(username);
			if (admin.getPassword().equals(password)){
				session.setAttribute("admin", admin);
				return true;
			} else {
				return false;
			}
		}
		
	}

}
