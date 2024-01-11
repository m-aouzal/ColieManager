package ac.ma.emi.secondproject.schemas;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;

import static jakarta.persistence.InheritanceType.JOINED;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Habitant extends Personne {

    @ManyToOne
    @JoinColumn(
            name = "centre_postal"
    )
    private CentrePostal centrePostal;

    @OneToMany(mappedBy = "habitantEmetteur",
            fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Colie> coliesEmis = new ArrayList<>();

    public void addColieEmi(Colie colieEmi) {
        this.coliesEmis.add(colieEmi);
    }

    @OneToMany(mappedBy = "habitantDestinataire",
            fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Colie> coliesEnvoyes = new ArrayList<>();

    public void addColieEnvoye(Colie colieEnvoye) {
        this.coliesEnvoyes.add(colieEnvoye);
    }
    public Habitant(String nom, String prenom, String rue, String quartier, String ville) {
        super(nom, prenom, rue, quartier, ville);
    }



    public Habitant(String nom, String prenom, CentrePostal centrePostal, List<Colie> coliesEmis, List<Colie> coliesEnvoyes) {
        super(nom, prenom);
        this.centrePostal = centrePostal;
        this.coliesEmis = coliesEmis;
        this.coliesEnvoyes = coliesEnvoyes;
    }

    public Habitant(CentrePostal centrePostal, List<Colie> coliesEmis, List<Colie> coliesEnvoyes) {
        this.centrePostal = centrePostal;
        this.coliesEmis = coliesEmis;
        this.coliesEnvoyes = coliesEnvoyes;
    }

    public Habitant(String nom, String prenom) {
        super(nom, prenom);
    }

    public Habitant() {
    }

    public void setHabitantId(long Id) {
        super.setPersonneId(Id);
    }

    public CentrePostal getCentrePostal() {
        return centrePostal;
    }

    public void setCentrePostal(CentrePostal centrePostal) {
        this.centrePostal = centrePostal;
    }
}
