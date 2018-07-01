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
	private int id;

	@NotNull
	@Column(name = "code", length = 20)
	private String code;

	@NotNull
	@Column(name = "poste", length = 50)
	private String poste;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	@OneToOne
	@MapsId
	private User users;

	public Employe() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
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
