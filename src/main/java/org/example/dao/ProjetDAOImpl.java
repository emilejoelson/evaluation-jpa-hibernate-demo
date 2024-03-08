package org.example.dao;

import org.example.entities.Projet;
import org.example.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjetDAOImpl implements  ProjetDAO{
    @PersistenceContext
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    @Override
    public Projet findById(Long id) {
        return null;
    }

    @Override
    public List<Projet> rechercheAllProjetTriByASC() {
        TypedQuery<Projet> query = entityManager.createQuery("Select p FROM Projet p ORDER BY p.id ASC ",Projet.class);
        List<Projet>  allProjects = query.getResultList();
        return  allProjects;
    }

    @Override
    public void persistProjectUsingNamedQuery(Projet projet) {
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery("persist_projet")
                .setParameter("titre", projet.getTitre())
                .setParameter("description", projet.getDescription())
                .setParameter("utilisateur_id", projet.getUtilisateur().getId())
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public Projet ajouterProject(Projet projet) {
        entityManager.getTransaction().begin();
        entityManager.persist(projet);
        entityManager.getTransaction().commit();
        return projet;
    }

}
