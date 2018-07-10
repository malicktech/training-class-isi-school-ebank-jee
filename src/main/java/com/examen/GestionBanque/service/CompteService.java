package com.examen.GestionBanque.service;

import java.time.Instant;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.GestionBanque.dao.AgenceRepository;
import com.examen.GestionBanque.dao.CompteRepository;
import com.examen.GestionBanque.dao.EmployeRepository;
import com.examen.GestionBanque.dao.OperationRepository;
import com.examen.GestionBanque.dao.UserRepository;
import com.examen.GestionBanque.entities.Compte;
import com.examen.GestionBanque.entities.Operation;
import com.examen.GestionBanque.enums.OperationStatus;
import com.examen.GestionBanque.enums.OperationType;
import com.examen.GestionBanque.enums.TransactionType;

@Service
@Transactional
public class CompteService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	public Compte saveCompte(Compte compte) {
		return compteRepository.save(compte);
	}

	public Compte executionVirementSurCompteDestinataire(String numCompteDestinataire, String numCompteEmeteur,
			Double montantHT) {
		log.info("Virement de " + montantHT + " du compte " + numCompteDestinataire + " vers le compte numéro "
				+ numCompteEmeteur);

		// Récupération du compte destinarie
		Compte compte = compteRepository.findById(numCompteDestinataire).get();

		// Enregsitrement de l'opération virement sur le compte destinateire
		Operation operation = new Operation(compte);
		operation.setDate(Instant.now());
		operation.setMontantHT(montantHT);
		operation.setMontantTTC(operation.getMontantHT());
		operation.setTypeOperation(OperationType.VIREMENT);
		operation.setTypeTransaction(TransactionType.CREDIT);
		operation.setStatusOperation(OperationStatus.EXECUTEE);
		operation.setNumCompteEmeteurVirement(numCompteEmeteur);
		operation.setCompte(compte);

		// Enregsitrement de l'opération
		Operation operationEnregsitree = operationRepository.save(operation);
		// Mis à jour solde compte
		compte.setSolde(compte.getSolde() + operation.getMontantTTC());
		Compte compteEnregistre = compteRepository.save(compte);
		
		return compteEnregistre;
	}
}
