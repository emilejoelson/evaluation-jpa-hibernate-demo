package org.example.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
@NamedQueries({
        @NamedQuery(name = "persist_utilisateur", query = "INSERT INTO Utilisateur (nom, email) SELECT :nom, :email FROM Utilisateur")
})
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Set<Projet> projets;
    public  Utilisateur(){

    }

    public Utilisateur(String nom, String email, Set<Projet> projets) {
        this.nom = nom;
        this.email = email;
        this.projets = projets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Projet> getProjets() {
        return projets;
    }

    public void setProjets(Set<Projet> projets) {
        this.projets = projets;
    }
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", projets=" + projets +
                '}';
    }
}

