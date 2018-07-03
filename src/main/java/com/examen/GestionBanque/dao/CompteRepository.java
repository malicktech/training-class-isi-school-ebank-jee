package com.examen.GestionBanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

	// Recupérer la liste des comtpes d'un client
	public Page<Compte> findByClientId(Long idClient, Pageable pageable);

}
