package com.examen.GestionBanque.service;

import org.springframework.stereotype.Service;

import com.examen.GestionBanque.dao.CompteRepository;
import com.examen.GestionBanque.entities.CompteCourant;

@Service
public class CompteService {

	private CompteRepository compteRepository;

	public CompteCourant saveCompte(CompteCourant compte) {
		System.out.println(compte);
		System.out.println(compte.getClient());
		System.out.println(compte.getAgence());
		return compteRepository.save(compte);
	}

}
