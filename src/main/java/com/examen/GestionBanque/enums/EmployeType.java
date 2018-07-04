package com.examen.GestionBanque.enums;

public enum EmployeType {
	
	CAISSIERE("caissière"),
	RESPONSABLE_COMPTE("responsable des comptes");
	
	private final String name;

	EmployeType(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
	
}
