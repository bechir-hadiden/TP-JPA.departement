package com.bechir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bechir.entities.Departement;
import com.bechir.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class DepartementDao {
	private EntityManager entityManager = JPAutil.getEntityManager("ProjectJPA.dep");

//méthode ajouter d'une entité à la bd
	public void ajouter(Departement c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);
		tx.commit();

	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Departement c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();

	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Departement c) {
	    EntityTransaction tx = entityManager.getTransaction();
	    try {
	        tx.begin();
	        c = entityManager.merge(c); // Assurez-vous que c est dans l'état géré
	        entityManager.remove(c);
	        tx.commit();
	    } catch (Exception e) {
	        if (tx.isActive()) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    }
	}


//méthode Consulter d'une entité à partir de la bd
	public Departement consulter(Departement c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Departement> listerTous() {
		List<Departement> clients = entityManager.createQuery("select c from Departement c").getResultList();
		return clients;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Departement> listerParNom(String nom) {
		List<Departement> Departements = entityManager.createQuery("select c from Departement c where c.NOM_departement like :pnom")
				.setParameter("pnom", "%" + nom + "%").getResultList();
		return Departements;
	}
	
	// Dans votre classe DepartementDao

	public Departement trouverParID(Long ID_departement) {
	    try {
	        return entityManager.find(Departement.class, ID_departement);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}