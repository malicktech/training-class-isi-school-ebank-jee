package com.examen.GestionBanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examen.GestionBanque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

	// PropertyReferenceException: No property findByCompteNumCompte found for type
	// Operation!
	Page<Operation> findByCompteNumCompteOrderByDateAsc(String numCompte, Pageable pageable);

	// @Query("select o from Operation o where o.compte.numCompte = ?1 order by
	// o.date")
	// public Page<Operation> FindByCompteOrderByDateOpQuery(String numCompte,
	// Pageable pageable);

}
