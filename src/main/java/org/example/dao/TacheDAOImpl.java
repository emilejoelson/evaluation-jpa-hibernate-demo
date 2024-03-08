package org.example.dao;

import org.example.entities.Projet;
import org.example.entities.Tache;
import org.example.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class TacheDAOImpl implements  TacheDAO{
    @PersistenceContext
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    @Override
    public Tache findById(Long id) {
        return null;
    }

    @Override
    public List<Tache> rechercheAllTacheTriByASC() {
        TypedQuery<Tache> query = entityManager.createQuery("Select t FROM Tache t ORDER BY t.id ASC ",Tache.class);
        List<Tache>  allTaches = query.getResultList();
        return  allTaches;
    }

    @Override
    public void persistTacheUsingNamedQuery(Tache tache) {
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery("persist_tache")
                .setParameter("titre", tache.getTitre())
                .setParameter("description", tache.getDescription())
                .setParameter("projet_id", tache.getProjet().getId())
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public Tache addTacheToProjet( Tache tache) {
        entityManager.getTransaction().begin();
        entityManager.persist(tache);
        entityManager.getTransaction().commit();
        return tache;
    }


    @Override
    public void supprimerAllTasksOfProjet(Long projectId) {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM Tache t WHERE t.projet.id = :projectId")
                    .setParameter("projectId", projectId)
                    .executeUpdate();

            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }
}

