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
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int idEmp;

	@NotNull
	@Column(name = "Code_Employe", length = 20)
	private String CodeEmp;

	@NotNull
	@Column(name = "Prenom", length = 30)
	private String prenomEmp;

	@NotNull
	@Column(name = "nom", length = 30)
	private String nomEmp;

	@NotNull
	@Column(name = "Poste_Occuppé", length = 50)
	private String postEmp;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	@OneToOne
	@MapsId
	private User users;

	public Employe() {
	}

	public Employe(@NotNull String codeEmp, @NotNull String prenomEmp, @NotNull String nomEmp,
			@NotNull String postEmp) {
		super();
		CodeEmp = codeEmp;
		this.prenomEmp = prenomEmp;
		this.nomEmp = nomEmp;
		this.postEmp = postEmp;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getCodeEmp() {
		return CodeEmp;
	}

	public void setCodeEmp(String codeEmp) {
		CodeEmp = codeEmp;
	}

	public String getPrenomEmp() {
		return prenomEmp;
	}

	public void setPrenomEmp(String prenomEmp) {
		this.prenomEmp = prenomEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getPostEmp() {
		return postEmp;
	}

	public void setPostEmp(String postEmp) {
		this.postEmp = postEmp;
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

}
