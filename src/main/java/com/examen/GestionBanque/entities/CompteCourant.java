package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	
private double agios;

public CompteCourant() {
	super();
	// TODO Auto-generated constructor stub
}

public CompteCourant(@NotNull String numCompte, @NotNull double solde, @NotNull Date dateCreation, boolean etat,
		double agios) {
	super(numCompte, solde, dateCreation, etat);
	this.agios = agios;
}

public double getAgios() {
	return agios;
}

public void setAgios(double agios) {
	this.agios = agios;
}



}
