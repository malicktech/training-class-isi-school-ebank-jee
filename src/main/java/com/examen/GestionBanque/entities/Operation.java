package com.examen.GestionBanque.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.examen.GestionBanque.enums.OperationStatus;
import com.examen.GestionBanque.enums.OperationType;
import com.examen.GestionBanque.enums.TransactionType;

@Entity
@Table(name = "operation")
public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private Instant date;

	@NotNull
	@Column(name = "montant_ht")
	private double montantHT;

	@NotNull
	@Column(name = "montant_ttc")
	private double montantTTC;

	@Column(name = "taxe_operation")
	private double taxeOperation;

	@Column(name = "taxe_sms")
	private double taxeSms;

	@Column(name = "raxe_releve")
	private double taxeReleve;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_operation")
	private OperationType typeOperation;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_transaction")
	private TransactionType typeTransaction;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_operation")
	private OperationStatus statusOperation;

	@ManyToOne
	@JoinColumn(name = "numero_compte")
	private Compte compte;

	@ManyToOne
	@JoinColumn(name = "code_employe")
	private Employe employe;

	/* Contructeurs */

	public Operation() {
	}
	
	public Operation(Compte compte) {
		this.compte = compte;
	}

	/* Getters & Setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public double getMontantHT() {
		return montantHT;
	}

	public void setMontantHT(double montantHT) {
		this.montantHT = montantHT;
	}

	public double getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(double montantTTC) {
		this.montantTTC = montantTTC;
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public double getTaxeOperation() {
		return taxeOperation;
	}

	public void setTaxeOperation(double taxeOperation) {
		this.taxeOperation = taxeOperation;
	}

	public OperationType getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(OperationType typeOperation) {
		this.typeOperation = typeOperation;
	}

	public TransactionType getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(TransactionType typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public OperationStatus getStatusOperation() {
		return statusOperation;
	}

	public void setStatusOperation(OperationStatus statusOperation) {
		this.statusOperation = statusOperation;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", description=" + description + ", date=" + date + ", montantHT=" + montantHT
				+ ", montanTTC=" + montantTTC + ", taxeOperation=" + taxeOperation + ", taxeSms=" + taxeSms
				+ ", taxeReleve=" + taxeReleve + ", typeOperation=" + typeOperation + ", typeTransaction="
				+ typeTransaction + "]";
	}

}
