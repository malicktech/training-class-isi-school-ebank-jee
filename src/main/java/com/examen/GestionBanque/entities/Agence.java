package com.examen.GestionBanque.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "num_agence", length = 20)
	private String numAgence;

	@NotNull
	@Column(name = "region", length = 30)
	private String region;

	@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	/* Contructeurs */

	public Agence() {
	}

	public Agence(@NotNull String numAgence, @NotNull String region) {
		super();
		this.numAgence = numAgence;
		this.region = region;
	}

	/* Getters & Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(String numAgence) {
		this.numAgence = numAgence;
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

}
