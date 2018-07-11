package com.examen.GestionBanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findBySalaireNotNull();
}
