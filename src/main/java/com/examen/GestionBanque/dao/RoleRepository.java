package com.examen.GestionBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.GestionBanque.entities.Role;

/**
 * Spring Data JPA repository for the Authority entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}