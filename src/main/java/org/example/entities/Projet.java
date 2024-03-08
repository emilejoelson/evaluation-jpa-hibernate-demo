package org.example.entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "projet")
@NamedQueries({
        @NamedQuery(name = "persist_projet", query = "INSERT INTO Projet (titre, description, utilisateur) SELECT :titre, :description, u FROM Utilisateur u WHERE u.id = :utilisateur_id")
})
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private Set<Tache> taches;

    public  Projet(){

    }

    public Projet(String titre, String description, Utilisateur utilisateur, Set<Tache> taches) {
        this.titre = titre;
        this.description = description;
        this.utilisateur = utilisateur;
        this.taches = taches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Set<Tache> getTaches() {
        return taches;
    }

    public void setTaches(Set<Tache> taches) {
        this.taches = taches;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", utilisateur=" + utilisateur.getId() +
                ", taches=" + taches +
                '}';
    }
}
