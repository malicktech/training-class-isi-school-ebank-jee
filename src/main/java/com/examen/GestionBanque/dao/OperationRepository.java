package com.examen.GestionBanque.dao;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.GestionBanque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
@Query("select o from Operation o where o.compte.code like :x order by o.dateOp desc")
public Page<Operation> listOperation(@Param("x")String codeCte,Pageable page);
}
