package com.examen.GestionBanque.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.GestionBanque.dao.CompteRepository;
import com.examen.GestionBanque.entities.Compte;

@Service
@Transactional
public class CompteService {

	@Autowired
	private CompteRepository compteRepository;

	public Compte saveCompte(Compte compte) {
		return compteRepository.save(compte);
	}

}
