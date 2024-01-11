package ac.ma.emi.secondproject.schemas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CentrePostal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centrePostalId;

    private String nom;
    private int numero;
    private String rue;
    private String quartier;
    private String ville;

    public void deposerColis() {
    }

    public void determinerTrajet() {
    }


    @ManyToOne
    @JoinColumn(
            name = "centre_regional",
            nullable = true
    )
    private CentreRegional centreRegional;


    @OneToMany(mappedBy = "centrePostal",
            fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Facteur> facteurs = new ArrayList<>();

    public void addFacteur(Facteur facteur) {
        this.facteurs.add(facteur);
    }

    @OneToMany(mappedBy = "centrePostal",
            fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Habitant> habitants = new ArrayList<>();

    public void addHabitant(Habitant habitant) {
        this.habitants.add(habitant);
    }


    public CentrePostal(String nom, int numero, String rue, String quartier, String ville) {
        this.nom = nom;
        this.numero = numero;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
    }

    public CentrePostal(String nom) {
        this.nom = nom;
    }

    public CentrePostal() {
    }

    public Long getCentrePostalId() {
        return centrePostalId;
    }

    public void setCentrePostalId(Long centrePostalId) {
        this.centrePostalId = centrePostalId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentrePostal that = (CentrePostal) o;
        return numero == that.numero && Objects.equals(centrePostalId, that.centrePostalId) && Objects.equals(nom, that.nom) && Objects.equals(rue, that.rue) && Objects.equals(quartier, that.quartier) && Objects.equals(ville, that.ville);
    }

    public CentreRegional getCentreRegional() {
        return centreRegional;
    }

    public void setCentreRegional(CentreRegional centreRegional) {
        this.centreRegional = centreRegional;
    }

    @Override
    public int hashCode() {
        return Objects.hash(centrePostalId, nom, numero, rue, quartier, ville);
    }

    @Override
    public String toString() {
        return "CentrePostal{" +
                "centrePostalId=" + centrePostalId +
                ", nom='" + nom + '\'' +
                ", numero=" + numero +
                ", rue='" + rue + '\'' +
                ", quartier='" + quartier + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
