package com.examen.GestionBanque.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examen.GestionBanque.dao.AgenceRepository;
import com.examen.GestionBanque.dao.CompteRepository;
import com.examen.GestionBanque.dao.UserRepository;
import com.examen.GestionBanque.entities.Compte;
import com.examen.GestionBanque.entities.CompteBloque;
import com.examen.GestionBanque.entities.CompteCourant;
import com.examen.GestionBanque.entities.CompteEpargne;
import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.service.CompteService;
import com.examen.GestionBanque.service.UserService;

@Controller
@RequestMapping("/compte")
public class CompteController {

	@Autowired
	private CompteService compteService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private AgenceRepository agenceRepository;

	@Autowired
	private CompteRepository compteRepository;

	@RequestMapping(value = "/liste")
	public String liste(Model model) {
		List<Compte> comptes = compteRepository.findAll();
		model.addAttribute("comptes", comptes);
		return "compte/liste";
	}

	@GetMapping("/ouverture")
	public String registration(Model model, String typeComte) {

		if (typeComte.equals("CE")) {
			CompteEpargne compte = new CompteEpargne();
			model.addAttribute("compte", compte);
		} else if (typeComte.equals("CC")) {
			CompteCourant compte = new CompteCourant();
			model.addAttribute("compte", compte);
		} else {
			CompteBloque compte = new CompteBloque();
			model.addAttribute("compte", compte);
		}

		model.addAttribute("users", userService.findAll());
		model.addAttribute("agences", agenceRepository.findAll());
		return "compte/ouverture";
	}

	@PostMapping("/ouverture")
	public String createNewUser(@Valid CompteCourant compte, Long idClient, Long idAgence, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "compte/ouverture";
		} else {
			compte.setAgence(agenceRepository.getOne(idAgence));
			compte.setClient(userRepository.getOne(idClient).getClient());

			compte.setDateCreation(new Date());
			Compte compteEnregistre = compteService.saveCompte(compte);

			model.addAttribute("successMessage", "User has been registered successfully");
			model.addAttribute("compte", compteEnregistre);
			model.addAttribute("user", new User());
		}
		return "compte/consultation";
	}

}
