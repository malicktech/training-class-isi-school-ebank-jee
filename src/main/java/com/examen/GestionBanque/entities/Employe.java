package com.examen.GestionBanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.examen.GestionBanque.enumeration.EmployeType;

@Entity
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@NotNull
	@Column(name = "code", length = 20, unique = true)
	private String code;

	@NotNull
	@Column(name = "poste", length = 50)
	private String poste;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private EmployeType type;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
	private User user;

	/* Contructeurs */

	public Employe() {
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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public EmployeType getType() {
		return type;
	}

	public void setType(EmployeType type) {
		this.type = type;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User users) {
		this.user = users;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", code=" + code + ", poste=" + poste + ", comptes=" + comptes + ", user=" + user
				+ "]";
	}

}
