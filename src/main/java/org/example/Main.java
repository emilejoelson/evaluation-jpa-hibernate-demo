package org.example;

import org.example.dao.ProjetDAOImpl;
import org.example.dao.TacheDAOImpl;
import org.example.dao.UtilisateurDAOImpl;
import org.example.entities.Projet;
import org.example.entities.Tache;
import org.example.entities.Utilisateur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjetDAOImpl projetDAO = new ProjetDAOImpl();
        TacheDAOImpl tacheDAO = new TacheDAOImpl();
        UtilisateurDAOImpl utilisateurDAO = new UtilisateurDAOImpl();

        Utilisateur u1 = new Utilisateur("Emmile","emile@gmail.com", new HashSet<>());
        Projet p1 = new Projet("Projet01", "Description01", u1, new HashSet<>());
        Projet p2 = new Projet("Projet02", "Description02", u1, new HashSet<>());
        Projet p3 = new Projet("Projet03", "Description03", u1, new HashSet<>());
        Projet p4 = new Projet("Projet04", "Description04", u1, new HashSet<>());
        Projet p5 = new Projet("Projet05", "Description05", u1, new HashSet<>());

        Utilisateur u2 = new Utilisateur("Joelson","joelson@gmail.com", new HashSet<>());
        Projet p11 = new Projet("Projet011", "Description011", u2, new HashSet<>());
        Projet p21 = new Projet("Projet021", "Description021", u2, new HashSet<>());
        Projet p31 = new Projet("Projet031", "Description031", u2, new HashSet<>());
        Projet p41 = new Projet("Projet041", "Description041", u2, new HashSet<>());
        Projet p51 = new Projet("Projet051", "Description051", u2, new HashSet<>());

        Utilisateur u3 = new Utilisateur("Hicham","hicham@gmail.com", new HashSet<>());
        Projet ph = new Projet("ProjetHicham", "DescriptionHicham", u3, new HashSet<>());

        Tache t1 = new Tache("Titre01","Description01",p1);
        Tache t2 = new Tache("Titre02","Description02",p1);
        Tache t3 = new Tache("Titre03","Description03",p1);

        Tache t11 = new Tache("Titre011","Description011",p2);
        Tache t21 = new Tache("Titre021","Description021",p2);
        Tache t31 = new Tache("Titre031","Description031",p2);

        Tache t111 = new Tache("Titre0111","Description0111",p3);
        Tache t211 = new Tache("Titre0211","Description0211",p3);
        Tache t311 = new Tache("Titre0311","Description0311",p3);

        Tache th = new Tache("Titre0111","Description0111",ph);

        System.out.println("\n\n::::::::::Ajout::::::::::::::::::::::::::");
        utilisateurDAO.ajoutterUlisateur(u1);
        utilisateurDAO.ajoutterUlisateur(u2);
        utilisateurDAO.ajoutterUlisateur(u3);

        projetDAO.ajouterProject(p1);
        projetDAO.ajouterProject(p2);
        projetDAO.ajouterProject(p3);
        projetDAO.ajouterProject(p4);
        projetDAO.ajouterProject(p5);

        projetDAO.ajouterProject(p11);
        projetDAO.ajouterProject(p21);
        projetDAO.ajouterProject(p31);
        projetDAO.ajouterProject(p41);
        projetDAO.ajouterProject(p51);
        projetDAO.ajouterProject(ph);

        tacheDAO.addTacheToProjet(t1);
        tacheDAO.addTacheToProjet(t2);
        tacheDAO.addTacheToProjet(t3);

        tacheDAO.addTacheToProjet(t11);
        tacheDAO.addTacheToProjet(t21);
        tacheDAO.addTacheToProjet(t31);

        tacheDAO.addTacheToProjet(t111);
        tacheDAO.addTacheToProjet(t211);
        tacheDAO.addTacheToProjet(t311);
        tacheDAO.addTacheToProjet(th);

        System.out.println("\n\n:::::::::::::::::::Rechercher() pour toutes les entités avec un tri asc by ID.\n:::::::::::::::::::::::::::::");
        List<Utilisateur> allUlisateurs = utilisateurDAO.rechercheAllUtilisateurTriByASC();
        for(Utilisateur u : allUlisateurs){
            System.out.println(u);
        }
        System.out.println("\n");
        List<Projet> allProjets = projetDAO.rechercheAllProjetTriByASC();
        for(Projet p : allProjets){
            System.out.println(p);
        }
        System.out.println("\n");
        List<Tache> allTaches = tacheDAO.rechercheAllTacheTriByASC();
        for(Tache t : allTaches){
            System.out.println(t);
        }
      /*
        System.out.println("\n\n:::::::::::::::::::persister un projet en utilisant une requête nommé..\n:::::::::::::::::::::::::::::");
        Utilisateur utilisateur = new Utilisateur("Milly", "milly@example.com", new HashSet<>());
        utilisateurDAO.persistUtilisateurUsingNamedQuery(utilisateur);
        System.out.println("Utilisateur persisted: " + utilisateur);

        Projet projet = new Projet("Projet A", "Description de  Projet A", utilisateur, new HashSet<>());
        projetDAO.persistProjectUsingNamedQuery(projet);
        System.out.println("Projet persisted: " + projet);

        Tache tache = new Tache("Tache 1", "Description de tache  1", projet);
        tacheDAO.persistTacheUsingNamedQuery(tache);
        System.out.println("Tache persisted: " + tache);*/

        System.out.println("\n\n:::::::::::::::::::supprimer tous les tâches liées à un projet en lui passant en paramètre l’identifiant du projet..\n:::::::::::::::::::::::::::::");
        tacheDAO.supprimerAllTasksOfProjet(2L);
        System.out.println("\n");
        List<Tache> allTachesAfterSuppresionTache = tacheDAO.rechercheAllTacheTriByASC();
        for(Tache ta : allTachesAfterSuppresionTache){
            System.out.println(ta);
        }

       System.out.println("\n\n:::::::::::::::::::la suppression d’un utilisateur..\n:::::::::::::::::::::::::::::");

       /* utilisateurDAO.supprimerUtilisateur(3L);
        System.out.println("\n");
        List<Utilisateur> allUtilisateursAfterSuppresion = utilisateurDAO.rechercheAllUtilisateurTriByASC();
        for(Tache ua : allTachesAfterSuppresionTache){
            System.out.println(ua);
        }*/
    }
}