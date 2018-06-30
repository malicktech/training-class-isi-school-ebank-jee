package com.examen.GestionBanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;

	@NotNull
	@Column(name = "Code", length = 20)
	private Long codeClient;

	@NotNull
	@Column(name = "Nom", length = 50)
	private String nomClient;

	@NotNull
	@Column(name = "Prenom", length = 50)
	private String prenomClient;

	@NotNull
	@Column(name = "Adresse", length = 50)
	private String adresseClient;

	@NotNull
	@Column(name = "Num_CIN", length = 20)
	private String cinClient;

	@NotNull
	@Column(name = "Tel", length = 20)
	private String telClient;

	@Column(name = "Salaire", length = 20)
	private Double salClient;

	@Column(name = "Profession", length = 50)
	private String professionClient;

	@Column(name = "Employeur", length = 20)
	private String employeur;

	@Column(name = "Raison_Social_Employe", length = 20)
	private String rsEmp;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	@OneToOne
	@MapsId
	private User users;

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Client() {
	}

	public Client(@NotNull Long codeClient, @NotNull String nomClient, @NotNull String prenomClient,
			@NotNull String adresseClient, @NotNull String cinClient, @NotNull String telClient, Double salClient,
			String professionClient, String employeur, String rsEmp) {
		super();
		this.codeClient = codeClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
		this.cinClient = cinClient;
		this.telClient = telClient;
		this.salClient = salClient;
		this.professionClient = professionClient;
		this.employeur = employeur;
		this.rsEmp = rsEmp;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public String getCinClient() {
		return cinClient;
	}

	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}

	public String getTelClient() {
		return telClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public Double getSalClient() {
		return salClient;
	}

	public void setSalClient(Double salClient) {
		this.salClient = salClient;
	}

	public String getProfessionClient() {
		return professionClient;
	}

	public void setProfessionClient(String professionClient) {
		this.professionClient = professionClient;
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

}
