package com.examen.GestionBanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.GestionBanque.dao.ClientRepository;
import com.examen.GestionBanque.dao.EmployeRepository;
import com.examen.GestionBanque.entities.Client;
import com.examen.GestionBanque.entities.Employe;
import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ClientRepository clientRepository; 
	
	@Autowired
	private EmployeRepository employeRepository;

	@GetMapping({ "/liste" })
	public String getUsersList(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/liste";
	}
	
	@GetMapping({ "/client/liste" })
	public String getClientsList(Model model) {
		List<Client> clients = clientRepository.findAll();
		model.addAttribute("clients", clients);
		return "client/liste";
	}
	
	@GetMapping({ "/employe/liste" })
	public String getEmployesList(Model model) {
		List<Employe> employes = employeRepository.findAll();
		model.addAttribute("employes", employes);
		return "employe/liste";
	}

}
