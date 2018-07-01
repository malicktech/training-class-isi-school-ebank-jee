package com.examen.GestionBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.GestionBanque.entities.HistoriqueTaxe;


public interface HistoTaxeRepository extends JpaRepository<HistoriqueTaxe, Long> {
}
