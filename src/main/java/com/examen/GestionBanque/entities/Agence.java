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
	private int idAgence ;
	
	@NotNull
	@Column(name = "Numero_Agence", length = 20)
	private String numAgence ;
	
	@NotNull
	@Column(name = "Region", length = 30)
	private String region;
	
	@OneToMany(mappedBy="agence",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agence(@NotNull String numAgence, @NotNull String region) {
		super();
		this.numAgence = numAgence;
		this.region = region;
	}
	
	
}
