package org.example.entities;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "tache")
@NamedQueries({
        @NamedQuery(name = "persist_tache", query = "INSERT INTO Tache (titre, description, projet) SELECT :titre, :description, p FROM Projet p WHERE p.id = :projet_id")
})
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

    public  Tache(){

    }

    public Tache(String titre, String description, Projet projet) {
        this.titre = titre;
        this.description = description;
        this.projet = projet;
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

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", projet=" + projet.getId() +
                '}';
    }
}
