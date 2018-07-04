package com.examen.GestionBanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examen.GestionBanque.dao.AgenceRepository;
import com.examen.GestionBanque.entities.Agence;
import com.examen.GestionBanque.service.AgenceService;

@Controller
public class AgenceController {
	
	@Autowired
	private AgenceService agenceService;
	
	@Autowired
	private AgenceRepository agenceRepository;
	
	@RequestMapping(value="/Agence/liste")
	public ModelAndView liste() {
		List<Agence> agences = agenceRepository.findAll();
		
		return new ModelAndView("agence/liste", "liste_agences", agences);
	}
	
	@RequestMapping(value="/Agence/ajout")
	public String add() {
		return "agence/add";//pour le chargement du formulaire d'ajout : add.html
	}
	
	@RequestMapping(value="/Agence/add")
	public String add(String nom, String region) {
		//insertion dans la base des données venant du formulaire
		Agence agence = new Agence();
		agence.setNom(nom);
		agence.setRegion(region);
		agenceRepository.save(agence);
		//Redirection vers la page d'affichage : liste.html
		return "redirect:/Agence/liste";
	}
	

}
