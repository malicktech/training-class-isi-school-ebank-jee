package com.examen.GestionBanque.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Agence {

	@Id
	@Column(name = "code", length = 20, unique = true)
	private String code;

	@Column(name = "nom", length = 50)
	private String nom;

	@NotNull
	@Column(name = "region", length = 50)
	private String region;

	@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	/* Contructeurs */

	public Agence() {
	}

	public Agence(@NotNull String numAgence, @NotNull String region) {
		super();
		this.code = numAgence;
		this.region = region;
	}

	/* Getters & Setters */

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return "Agence [code=" + code + ", nom=" + nom + ", region=" + region + ", comptes=" + comptes + "]";
	}

}
