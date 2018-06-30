package com.examen.GestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Long numOp, Date dateOp, double montantop, double taxeOp, double taxeSms, double taxeReleve) {
		super(numOp, dateOp, montantop, taxeOp, taxeSms, taxeReleve);
		// TODO Auto-generated constructor stub
	}

	
		
}
