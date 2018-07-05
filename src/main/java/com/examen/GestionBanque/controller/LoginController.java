package com.examen.GestionBanque.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.examen.GestionBanque.configuration.security.RolesConstants;
import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.service.UserService;

@Controller
public class LoginController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	@GetMapping("/user/ajout")
	public String registration(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/ajout";
	}

	@PostMapping("/user/ajout")
	public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"Un utilisateur est déja enregistré avec cette adresse mail. Utiliser un autre !");
		}
		if (bindingResult.hasErrors()) {
			return "user/ajout";
		} else {
			userService.saveUser(user, RolesConstants.ADMIN);
			model.addAttribute("successMessage", "L'utilisateur a été enregistré avec succé");
			model.addAttribute("user", new User());
		}
		return "user/ajout";
	}

	@GetMapping("/admin/home")
	public String adminHome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addAttribute("userName",
				"Welcome " + user.getPrenom() + " " + user.getNom() + " (" + user.getEmail() + ")");
		model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
		model.addAttribute("user", user);
		return "admin/home";
	}

	@GetMapping("/client/home")
	public String clientHome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		log.debug("MIKE = " + user.toString());
		log.debug(user.getRoles().toString());
		model.addAttribute("userName",
				"Welcome " + user.getPrenom() + " " + user.getNom() + " (" + user.getEmail() + ")");
		model.addAttribute("adminMessage", "Content Available Only for Users with Client Role");
		model.addAttribute("user", user);
		return "client/home";
	}

}
