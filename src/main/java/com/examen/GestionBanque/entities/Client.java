package com.examen.GestionBanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@NotNull
	@Column(name = "code", length = 20)
	private String code;

	@NotNull
	@Column(name = "adresse", length = 50)
	private String adresse;

	@NotNull
	@Column(name = "num_cin", length = 20)
	private String numCin;

	@NotNull
	@Column(name = "telephone", length = 20)
	private String telephone;

	@Column(name = "salaire", length = 20)
	private Double salaire;

	@Column(name = "profession", length = 50)
	private String profession;

	@Column(name = "employeur", length = 20)
	private String employeur;

	@Column(name = "raison_social_employe", length = 20)
	private String rsEmp;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	@OneToOne
	@MapsId
	private User users;

	/* Contructeurs */

	public Client() {
	}

	/* Getters & Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumCin() {
		return numCin;
	}

	public void setNumCin(String numCin) {
		this.numCin = numCin;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEmployeur() {
		return employeur;
	}

	public void setEmployeur(String employeur) {
		this.employeur = employeur;
	}

	public String getRsEmp() {
		return rsEmp;
	}

	public void setRsEmp(String rsEmp) {
		this.rsEmp = rsEmp;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", code=" + code + ", adresse=" + adresse + ", numCin=" + numCin + ", telephone="
				+ telephone + ", salaire=" + salaire + ", profession=" + profession + ", employeur=" + employeur
				+ ", rsEmp=" + rsEmp + ", comptes=" + comptes + ", users=" + users + "]";
	}

}
