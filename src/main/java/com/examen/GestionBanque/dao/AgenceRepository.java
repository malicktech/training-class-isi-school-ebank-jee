package com.examen.GestionBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
	}

