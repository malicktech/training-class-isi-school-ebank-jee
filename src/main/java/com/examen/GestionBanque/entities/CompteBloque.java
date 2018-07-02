package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CB")
public class CompteBloque extends Compte {

	private static final long serialVersionUID = 1L;

	@Column(name = "frais_ouverture_cb")
	private double fraisOuvCB;

	/* Contructeurs */

	public CompteBloque() {
		super();
	}

	public CompteBloque(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat,
			double fraisOuvCB) {
		super(numCompte, solde, dateCreation, etat);
		this.fraisOuvCB = fraisOuvCB;
	}

	/* Getters & Setters */

	public double getFraisOuvCB() {
		return fraisOuvCB;
	}

	public void setFraisOuvCB(double fraisOuvCB) {
		this.fraisOuvCB = fraisOuvCB;
	}

}
