package com.examen.GestionBanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

	// Page<Operation> FindByCompteIdOrderByDateOp(Long compteId, Pageable page);

}
