package com.examen.GestionBanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

	// Recupérer la liste des comtpes d'un client
	List<Compte> findByClientId(Long idClient);
	
	// Pour le virement, Récupèrer la liste des comptes sauf le compte d'origne
	List<Compte> findByNumCompteIsNot(String numCompte);

}
