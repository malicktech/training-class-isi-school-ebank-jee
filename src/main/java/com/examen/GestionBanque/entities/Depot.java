package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Depot extends Operation {

	public Depot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depot(Long numOp, Date dateOp, double montantop, double taxeOp, double taxeSms, double taxeReleve) {
		super(numOp, dateOp, montantop, taxeOp, taxeSms, taxeReleve);
		// TODO Auto-generated constructor stub
	}

}
