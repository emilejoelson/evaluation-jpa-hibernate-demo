package org.example.dao;

import org.example.entities.Projet;
import org.example.entities.Tache;

import java.util.List;

public interface ProjetDAO {
    Projet findById(Long id);
    //Question 01
    List<Projet> rechercheAllProjetTriByASC();
    //Question 02
    void persistProjectUsingNamedQuery(Projet projet);
    Projet ajouterProject(Projet projet);

}
