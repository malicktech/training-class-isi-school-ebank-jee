package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private static final long serialVersionUID = 1L;

	/* Contructeurs */

	public CompteCourant() {
		super();
	}

	public CompteCourant(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat) {
		super(numCompte, solde, dateCreation, etat);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
