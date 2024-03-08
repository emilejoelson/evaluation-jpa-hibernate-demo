package org.example.dao;

import org.example.entities.Projet;
import org.example.entities.Utilisateur;
import org.example.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class UtilisateurDAOImpl implements  UtilisateurDAO{
    @PersistenceContext
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public List<Utilisateur> rechercheAllUtilisateurTriByASC() {
        TypedQuery<Utilisateur> query = entityManager.createQuery("Select u FROM Utilisateur u ORDER BY u.id ASC ",Utilisateur.class);
        List<Utilisateur>  allUtilisateurs = query.getResultList();
        return  allUtilisateurs;
    }

    @Override
    public void persistUtilisateurUsingNamedQuery(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery("persist_utilisateur")
                .setParameter("nom", utilisateur.getNom())
                .setParameter("email", utilisateur.getEmail())
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public Utilisateur ajoutterUlisateur(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
        return utilisateur;
    }

    @Override
    public void supprimerUtilisateur(Long id) {
        try {
            entityManager.getTransaction().begin();
            Utilisateur utilisateur = entityManager.find(Utilisateur.class, id);
            if (utilisateur != null) {
                entityManager.remove(utilisateur);
                System.out.println("Supression avec succès.");
            } else {
                System.out.println("Echec de supression avec id : " + id);
            }
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }
}
