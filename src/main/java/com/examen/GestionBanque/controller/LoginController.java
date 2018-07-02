package com.examen.GestionBanque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}

	@PostMapping("/registration")
	public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"Un utilisateur est déja enregistré avec cette adresse mail. Utiliser un autre !");
		}
		if (bindingResult.hasErrors()) {
			return "registration";
		} else {
			userService.saveUser(user);
			model.addAttribute("successMessage", "L'utilisateur a été enregistré avec succé");
			model.addAttribute("user", new User());
		}
		return "registration";
	}

	@GetMapping("/admin/home")
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addAttribute("user", user);
		return "admin/home";
	}

}
