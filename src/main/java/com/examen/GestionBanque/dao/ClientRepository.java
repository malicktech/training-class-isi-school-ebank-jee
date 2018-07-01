package com.examen.GestionBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
