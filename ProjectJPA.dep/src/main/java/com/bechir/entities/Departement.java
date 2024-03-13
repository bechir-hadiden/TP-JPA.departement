package com.bechir.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Departement implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	//pour autoincrement
	private Long ID_departement;
	private String NOM_departement;
	private int Nb_employee;
	

	public Long getID_departement() {
		return ID_departement;
	}
	public void setID_departement(Long iD_departement) {
		ID_departement = iD_departement;
	}
	public String getNOM_departement() {
		return NOM_departement;
	}
	public void setNOM_departement(String nOM_departement) {
		NOM_departement = nOM_departement;
	}
	public double getNb_employee() {
		return Nb_employee;
	}
	public void setNb_employee(int nb_employee) {
		Nb_employee = nb_employee;
	}
}
