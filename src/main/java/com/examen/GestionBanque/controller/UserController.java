package com.examen.GestionBanque.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examen.GestionBanque.configuration.security.RolesConstants;
import com.examen.GestionBanque.dao.ClientRepository;
import com.examen.GestionBanque.dao.EmployeRepository;
import com.examen.GestionBanque.entities.Client;
import com.examen.GestionBanque.entities.Employe;
import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	
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
	
	/*@GetMapping({ "/client/liste" })
	public String getClientsList(Model model) {
		List<Client> clients = clientRepository.findAll();
		model.addAttribute("clients", clients);
		return "client/liste";
	}*/
	
	@RequestMapping(value="/Client/liste")
	public ModelAndView liste() {
		
		List<Client> client = clientRepository.findAll();
		return new ModelAndView("/client/liste","liste_client",client
				);
		
	}

	@GetMapping({ "/employe/liste" })
	public String getEmployesList(Model model) {
		List<Employe> employes = employeRepository.findAll();
		model.addAttribute("employes", employes);
		return "employe/liste";
	}
	
	@GetMapping("/client/ajout")
	public String getAjoutClient(Model model) {
		User user = new User();
		user.setClient(new Client());
		model.addAttribute("user", user);
		return "client/ajout";
	}

	@PostMapping("/client/ajout")
	public String postAjoutClient(@Valid User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByEmail(user.getEmail());
		
		log.info("POST /client/ajout");
		
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"Un utilisateur est déja enregistré avec cette adresse mail. Utiliser un autre !");
		}
		if (bindingResult.hasErrors()) {
			return "client/ajout";
		} else {
			log.info(user.toString());
			log.info(user.getClient().toString());
			userService.saveUser(user, RolesConstants.CLIENT);
			model.addAttribute("successMessage", "Le client a été enregistré avec succé");
		}
		return "client/liste";
	}

}
