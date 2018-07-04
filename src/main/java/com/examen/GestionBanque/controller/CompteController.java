package com.examen.GestionBanque.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.GestionBanque.dao.AgenceRepository;
import com.examen.GestionBanque.dao.CompteRepository;
import com.examen.GestionBanque.dao.OperationRepository;
import com.examen.GestionBanque.dao.UserRepository;
import com.examen.GestionBanque.entities.Compte;
import com.examen.GestionBanque.entities.CompteBloque;
import com.examen.GestionBanque.entities.CompteCourant;
import com.examen.GestionBanque.entities.CompteEpargne;
import com.examen.GestionBanque.entities.Operation;
import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.service.CompteService;
import com.examen.GestionBanque.service.UserService;

@Controller
@RequestMapping("/compte")
public class CompteController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

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

	@Autowired
	private OperationRepository operationRepository;

	@RequestMapping(value = "/liste")
	public String liste(Model model) {
		List<Compte> comptes = compteRepository.findAll();
		model.addAttribute("comptes", comptes);
		return "compte/liste";
	}

	@RequestMapping(value = "/detail/{num}")
	public String detail(@PathVariable String num, Model model, Pageable pageable) {
		Optional<Compte> compte = compteRepository.findById(num);

		if (compte.isPresent()) {
			log.info(compte.toString());
			model.addAttribute("compte", compte.get());

			Page<Operation> operations = operationRepository
					.findByCompteNumCompteOrderByDateAsc(compte.get().getNumCompte(), pageable);
			model.addAttribute("operations", operations);
			
			Operation operation = new Operation();
			operation.setCompte(compte.get());
			model.addAttribute("operation", operation);
		}

		return "compte/detail";
	}

	@GetMapping("/ouverture")
	public String registration(Model model, String typeComte) {

		if (typeComte.equals("CE")) {
			CompteEpargne compte = new CompteEpargne();
			model.addAttribute("compte", compte);
		} else if (typeComte.equals("CC")) {
			model.addAttribute("compte", new CompteCourant());
		} else {
			CompteBloque compte = new CompteBloque();
			model.addAttribute("compte", compte);
		}

		model.addAttribute("users", userService.findAll());
		model.addAttribute("agences", agenceRepository.findAll());
		return "compte/ouverture";
	}

	@PostMapping("/ouverture")
	public String ajoutNouveauCompte(@Valid CompteCourant compte, Long idClient, String codeAgence,
			BindingResult bindingResult, Model model) {

		log.debug("Controller Service save Compte");
		log.debug("codeAgence =" + codeAgence + "/ idClient =" + idClient);
		log.debug(compte.toString());

		if (bindingResult.hasErrors()) {
			return "compte/ouverture";
		} else {
			compte.setAgence(agenceRepository.getOne(codeAgence));
			compte.setClient(userRepository.getOne(idClient).getClient());
			compte.setDateCreation(new Date());
			Compte compteEnregistre = compteService.saveCompte(compte);

			model.addAttribute("successMessage", "le compte a été créer avec succés");
			model.addAttribute("compte", compteEnregistre);
		}
		return "compte/detail";
	}

}
