package ac.ma.emi.secondproject.schemas;

import jakarta.persistence.*;

import static jakarta.persistence.InheritanceType.JOINED;

@Entity
public class Facteur extends Personne{


    @ManyToOne
    @JoinColumn(
            name = "centre_postal"

    )
    private CentrePostal centrePostal;


    @ManyToOne
    @JoinColumn(
            name = "colie"
    )
    private Colie colie;
    public Facteur(String nom, String prenom, String rue, String quartier, String ville) {
        super(nom, prenom, rue, quartier, ville);
    }

    public Facteur(String nom, String prenom) {
        super(nom, prenom);
    }

    public Facteur() {
    }

    public CentrePostal getCentrePostal() {
        return centrePostal;
    }

    public void setCentrePostal(CentrePostal centrePostal) {
        this.centrePostal = centrePostal;
    }
    public Colie getColie() {
        return colie;
    }

    public void setColie(Colie colie) {
        this.colie = colie;
    }

    public void setFacteurId(long Id){
        super.setPersonneId(Id);
    }
}
