package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double fraisOuvEp;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat,
			double fraisOuvEp) {
		super(numCompte, solde, dateCreation, etat);
		this.fraisOuvEp = fraisOuvEp;
	}

	public double getFraisOuvEp() {
		return fraisOuvEp;
	}

	public void setFraisOuvEp(double fraisOuvEp) {
		this.fraisOuvEp = fraisOuvEp;
	}

}
