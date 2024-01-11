package ac.ma.emi.secondproject.schemas;


import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.Objects;

import static jakarta.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy = JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personneId ;

    private String nom;
    private String prenom;
    private String rue;
    private String quartier;
    private String ville;

    public Personne(String nom, String prenom, String rue, String quartier, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Long getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Long personneId) {
        this.personneId = personneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(personneId, personne.personneId) && Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(rue, personne.rue) && Objects.equals(quartier, personne.quartier) && Objects.equals(ville, personne.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personneId, nom, prenom, rue, quartier, ville);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "personneId=" + personneId +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", rue='" + rue + '\'' +
                ", quartier='" + quartier + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}

