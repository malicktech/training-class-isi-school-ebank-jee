package com.examen.GestionBanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.Employe;
import com.examen.GestionBanque.enums.EmployeType;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

	List<Employe> findByType(EmployeType type);

}
