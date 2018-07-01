package com.examen.GestionBanque.dao;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.GestionBanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
@Query("select c from Compte c where c.client.idClient=:x")
public Page<Compte> listComptes(@Param("x")Long codeCte,Pageable page);

}
