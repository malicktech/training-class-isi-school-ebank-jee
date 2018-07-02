package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private static final long serialVersionUID = 1L;

	@Column(name = "agios")
	private double agios;

	/* Contructeurs */
	
	public CompteCourant() {
		super();
	}

	public CompteCourant(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat,
			double agios) {
		super(numCompte, solde, dateCreation, etat);
		this.agios = agios;
	}

	/* Getters & Setters */
	
	public double getAgios() {
		return agios;
	}

	public void setAgios(double agios) {
		this.agios = agios;
	}

}
