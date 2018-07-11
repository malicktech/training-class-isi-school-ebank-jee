package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CB")
public class CompteBloque extends Compte {

	private static final long serialVersionUID = 1L;

	/* Contructeurs */

	public CompteBloque() {
		super();
	}

	public CompteBloque(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat) {
		super(numCompte, solde, dateCreation, etat);
	}

}
