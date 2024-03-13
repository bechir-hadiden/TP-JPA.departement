package com.bechir.test;

import com.bechir.dao.DepartementDao;
import com.bechir.entities.Departement;

public class DepartementTest {
	public static void main(String[] args) {
		Departement c = new Departement();
		Departement c2 = new Departement();
		
		c.setNOM_departement("Departement informatique");
		c.setNb_employee(23);
		c2.setNOM_departement("Departement gestion");
		c2.setNb_employee(23);
		DepartementDao depDao = new DepartementDao();


		depDao.ajouter(c);
		System.out.println("Appel de la méthode listerTous");
		for (Departement cl : depDao.listerTous())
			System.out.println(cl.getID_departement() + " " + cl.getNOM_departement()+ " "+ cl.getNb_employee());
		System.out.println("Appel de la méthode listerParNom");
		for (Departement cl : depDao.listerParNom("Depa"))
			System.out.println(cl.getID_departement() + " " + cl.getNOM_departement()+ " "+ cl.getNb_employee());

		
		 Departement departementAModifier = depDao.listerParNom("Departement gestion").get(0);

	        // Modification du département récupéré
	        if (departementAModifier != null) {
	            departementAModifier.setNOM_departement("Departement Informatique");
	            depDao.modifier(departementAModifier);
	            System.out.println("Département modifié avec succès");
	        } else {
	            System.out.println("Département avec le nom spécifié non trouvé");
	        }

	        
	        System.out.println("Appel de la méthode listerTous après modification :");
	        for (Departement cl : depDao.listerTous())
	            System.out.println(cl.getID_departement() + " " + cl.getNOM_departement() + " " + cl.getNb_employee());
	        
		
	        
		depDao.supprimer(c);
		 Departement departementTrouve = depDao.trouverParID(c.getID_departement());

		    // Vérifier si le département a été trouvé
		    if (departementTrouve != null) {
		        System.out.println("Département trouvé : " + departementTrouve.getID_departement() + " " + departementTrouve.getNOM_departement());
		    } else {
		        System.out.println("Département non trouvé.");
		    }

	}
	}


