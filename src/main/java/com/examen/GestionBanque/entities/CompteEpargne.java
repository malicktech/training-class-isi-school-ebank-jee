package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private static final long serialVersionUID = 1L;

	@Column(name = "frais_ouverture_ce")
	private double fraisOuvEp;

	/* Contructeurs */

	public CompteEpargne() {
	}

	public CompteEpargne(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat,
			double fraisOuvEp) {
		super(numCompte, solde, dateCreation, etat);
		this.fraisOuvEp = fraisOuvEp;
	}

	/* Getters & Setters */

	public double getFraisOuvEp() {
		return fraisOuvEp;
	}

	public void setFraisOuvEp(double fraisOuvEp) {
		this.fraisOuvEp = fraisOuvEp;
	}

}
