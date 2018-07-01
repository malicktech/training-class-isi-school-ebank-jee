package com.examen.GestionBanque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Operation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOp;

	@Column(name = "Numero_Operation")
	private Long numOp;

	@Column(name = "Date_Operation")
	private Date dateOp;

	@Column(name = "Montant_Operation")
	private double montantop;

	@Column(name = "Taxe_Operation")
	private double taxeOp;

	@Column(name = "Taxe_Sms")
	private double taxeSms;

	@Column(name = "Taxe_Relevé")
	private double taxeReleve;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "Numero_Compte")
	private Compte compte;

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(Long numOp, Date dateOp, double montantop, double taxeOp, double taxeSms, double taxeReleve) {
		super();
		this.numOp = numOp;
		this.dateOp = dateOp;
		this.montantop = montantop;
		this.taxeOp = taxeOp;
		this.taxeSms = taxeSms;
		this.taxeReleve = taxeReleve;
	}

	public int getIdOp() {
		return idOp;
	}

	public void setIdOp(int idOp) {
		this.idOp = idOp;
	}

	public Long getNumOp() {
		return numOp;
	}

	public void setNumOp(Long numOp) {
		this.numOp = numOp;
	}

	public Date getDateOp() {
		return dateOp;
	}

	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}

	public double getMontantop() {
		return montantop;
	}

	public void setMontantop(double montantop) {
		this.montantop = montantop;
	}

	public double getTaxeOp() {
		return taxeOp;
	}

	public void setTaxeOp(double taxeOp) {
		this.taxeOp = taxeOp;
	}

	public double getTaxeSms() {
		return taxeSms;
	}

	public void setTaxeSms(double taxeSms) {
		this.taxeSms = taxeSms;
	}

	public double getTaxeReleve() {
		return taxeReleve;
	}

	public void setTaxeReleve(double taxeReleve) {
		this.taxeReleve = taxeReleve;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
