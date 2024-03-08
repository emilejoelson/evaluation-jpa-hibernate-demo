package org.example.dao;

import org.example.entities.Utilisateur;

import java.util.List;

public interface UtilisateurDAO {
    //Question 01
    List<Utilisateur> rechercheAllUtilisateurTriByASC();
    //Question 02
    void persistUtilisateurUsingNamedQuery(Utilisateur utilisateur);
    Utilisateur ajoutterUlisateur(Utilisateur utilisateur);
    //Question 05
    void supprimerUtilisateur(Long id);
}
