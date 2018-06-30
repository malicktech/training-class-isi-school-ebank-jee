package com.examen.GestionBanque.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class HistoriqueTaxe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idHisto;

	@NotNull
	@Column(name = "Date", length = 20)
	private Date dateHisto;

	@NotNull
	@Column(name = "Montant_Taxe", length = 20)
	private Double MontantT;

	@ManyToOne
	@JoinColumn(name = "Numero_Compte")
	private Compte compte;

}
