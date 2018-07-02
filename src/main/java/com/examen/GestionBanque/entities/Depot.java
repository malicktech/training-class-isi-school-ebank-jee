package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("depot")
public class Depot extends Operation {

	private static final long serialVersionUID = 1L;

	public Depot() {
	}

	public Depot(Long numOp, Date dateOp, double montantop, double taxeOp, double taxeSms, double taxeReleve) {
		super(numOp, dateOp, montantop, taxeOp, taxeSms, taxeReleve);
	}

}
