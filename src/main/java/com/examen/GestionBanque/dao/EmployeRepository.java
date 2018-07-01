package com.examen.GestionBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
