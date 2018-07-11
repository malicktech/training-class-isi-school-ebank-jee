package com.examen.GestionBanque.service;

import java.time.Instant;
import java.util.Date;

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

	public Compte saveCompteAvecFrais(Compte compte, OperationType type) {

		compte.setDateCreation(new Date());
		Compte compteEnregistre = compteRepository.save(compte);

		// Enregsitrement de l'opération sur le compte pour l'ajout frais d'ouverture et
		// agios en foction du type de compte
		Operation operation = new Operation(compte);
		operation.setDate(Instant.now());

		if (type.equals(OperationType.AGIOS)) {
			operation.setTypeOperation(OperationType.AGIOS);
			operation.setMontantHT(getTaxeAgios());
		}
		if (type.equals(OperationType.FRAIS_OUVERTURE)) {
			operation.setTypeOperation(OperationType.FRAIS_OUVERTURE);
			operation.setMontantHT(getTaxeOuvertureCompte());
		}

		operation.setMontantTTC(operation.getMontantHT());
		operation.setTypeTransaction(TransactionType.DEBIT);
		operation.setStatusOperation(OperationStatus.EXECUTEE);
		operation.setCompte(compteEnregistre);

		// Enregsitrement de l'opération
		Operation operationEnregsitree = operationRepository.save(operation);

		// Mis à jour solde compte
		log.error("solde = " + (compte.getSolde() - operation.getMontantTTC()));
		compte.setSolde(compte.getSolde() - operation.getMontantTTC());
		return compteRepository.save(compte);
	}

	/**
	 * Retourne le montant de la taxe si l'option sms est choisie
	 */
	public double getMontantTaxeSms() {
		return 5;
	}

	/**
	 * Retourne le montant taxé pour chaque opération
	 */
	public double getTaxeOperation() {
		return 10;
	}

	/**
	 * Retourne le montant taxé pour les frais ouverture
	 */
	public double getTaxeOuvertureCompte() {
		return 8;
	}

	/**
	 * Retourne le montant taxé pour les frais ouverture
	 */
	public double getTaxeAgios() {
		return 6;
	}
}
