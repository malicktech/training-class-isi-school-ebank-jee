package com.examen.GestionBanque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examen.GestionBanque.dao.AgenceRepository;
import com.examen.GestionBanque.entities.Agence;

@Controller
public class AgenceController {

	@Autowired
	private AgenceRepository agenceRepository;

	@RequestMapping(value = "/agence/liste")
	public String liste(Model model) {
		List<Agence> agences = agenceRepository.findAll();
		model.addAttribute("agences", agences);
		return "agence/liste";
	}

	@RequestMapping(value = "/agence/ajout")
	public String getAjout(Model model) {
		model.addAttribute("agence", new Agence());
		// pour le chargement du formulaire d'ajout : add.html
		return "agence/ajout";
	}

	@PostMapping(value = "/agence/ajout")
	public String postAjout(@Valid Agence agence, BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			return "agence/ajout";
		} else {
			// insertion dans la base des données venant du formulaire
			Agence agenceEnregsitre = agenceRepository.save(agence);
			attributes.addFlashAttribute("successMessage",
					"l'agence " + agenceEnregsitre.getCode() + " a été ajoutée avec succés");
		}
		// Redirection vers la page d'affichage agences
		return "redirect:" + "/agence/liste";
	}

}
