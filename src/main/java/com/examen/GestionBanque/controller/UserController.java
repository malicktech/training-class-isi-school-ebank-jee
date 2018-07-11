package com.examen.GestionBanque.controller;

import java.util.Arrays;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examen.GestionBanque.configuration.security.RolesConstants;
import com.examen.GestionBanque.dao.ClientRepository;
import com.examen.GestionBanque.dao.EmployeRepository;
import com.examen.GestionBanque.entities.Client;
import com.examen.GestionBanque.entities.Employe;
import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.enums.EmployeType;
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

	/**
	 * Retourne la liste complète des utilisateurs : admin + client + employé
	 */
	@GetMapping({ "/liste" })
	public String getUsersList(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/liste";
	}

	/**
	 * Retourne la liste des clients uniquement
	 */
	@GetMapping({ "/client/liste" })
	public String getClientsList(Model model) {
		List<Client> clients = clientRepository.findAll();
		model.addAttribute("clients", clients);
		return "client/liste";
	}

	/**
	 * Retourne la liste des Eployés uniquement
	 */
	@GetMapping({ "/employe/liste" })
	public String getEmployesList(Model model) {
		List<Employe> employes = employeRepository.findAll();
		model.addAttribute("employes", employes);
		return "employe/liste";
	}

	/**
	 * Affiche le formulaire d'ajout d'un nouveau client
	 */
	@GetMapping("/client/ajout")
	public String getAjoutClient(Model model) {
		User user = new User();
		user.setClient(new Client());
		model.addAttribute("user", user);
		return "client/ajout";
	}

	/**
	 * Enregistre le nouveau client
	 */
	@PostMapping("/client/ajout")
	public String postAjoutClient(@Valid User user, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
		User userExists = userService.findUserByEmail(user.getEmail());

		log.info("POST /client/ajout");

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"Un utilisateur est déja enregistré avec cette adresse mail. Utiliser un autre !");
		}
		if (bindingResult.hasErrors()) {
			log.info(bindingResult.toString());
			return "client/ajout";
		} else {
			log.info(user.toString());
			log.info(user.getClient().toString());
			User clientEnregsitre = userService.saveUser(user, RolesConstants.CLIENT);
			attributes.addFlashAttribute("successMessage",
					"le client " + clientEnregsitre.getClient().getCode() + " a été enregistré avec succés");
		}
		return "redirect:" + "/user/client/liste";
	}
	
	
	/**
	 * Affiche le formulaire d'ajout d'un nouveau employe
	 */
	@GetMapping("/employe/ajout")
	public String getAjoutEmployet(Model model) {
		User user = new User();
		model.addAttribute("typeEmployes",
				Arrays.asList(EmployeType.CAISSIERE, EmployeType.RESPONSABLE_COMPTE));
		user.setEmploye(new Employe());
		model.addAttribute("user", user);
		return "employe/ajout";
	}

	/**
	 * Enregistre un nouveau employe
	 */
	@PostMapping("/employe/ajout")
	public String postAjoutEmploye(@Valid User user, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
		User userExists = userService.findUserByEmail(user.getEmail());

		log.info("POST /employe/ajout");

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"Un utilisateur est déja enregistré avec cette adresse mail. Utiliser un autre !");
		}
		if (bindingResult.hasErrors()) {
			log.info(bindingResult.toString());
			return "employe/ajout";
		} else {
			User employeEnregsitre;
			if (user.getEmploye().getType().equals(EmployeType.CAISSIERE)) {
				employeEnregsitre = userService.saveUser(user, RolesConstants.CAISSIERE);
			} else {
				employeEnregsitre = userService.saveUser(user, RolesConstants.RESPONSABLE_COMPTE);
			}
			attributes.addFlashAttribute("successMessage",
					"l'employe " + employeEnregsitre.getEmploye().getCode() + " a été enregistré avec succés");
		}
		return "redirect:" + "/user/employe/liste";
	}


}
