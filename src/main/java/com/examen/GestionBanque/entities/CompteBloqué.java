package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CB")
public class CompteBloqué extends Compte {

	private static final long serialVersionUID = 1L;

	private double fraisOuvCB;

	public CompteBloqué() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteBloqué(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat,
			double fraisOuvCB) {
		super(numCompte, solde, dateCreation, etat);
		this.fraisOuvCB = fraisOuvCB;
	}

	public double getFraisOuvCB() {
		return fraisOuvCB;
	}

	public void setFraisOuvCB(double fraisOuvCB) {
		this.fraisOuvCB = fraisOuvCB;
	}

}
