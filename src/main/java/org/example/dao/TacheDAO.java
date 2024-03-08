package org.example.dao;

import org.example.entities.Projet;
import org.example.entities.Tache;

import java.util.List;

public interface TacheDAO {
    Tache findById(Long id);
    //Question 01
    List<Tache> rechercheAllTacheTriByASC();
    //Question 02
    void persistTacheUsingNamedQuery(Tache tache);
    //Question 03
    Tache addTacheToProjet(Tache tache);
    //Question 04
    void supprimerAllTasksOfProjet(Long projectId);
}
