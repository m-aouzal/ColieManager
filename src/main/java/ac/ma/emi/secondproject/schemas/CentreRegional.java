package ac.ma.emi.secondproject.schemas;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy = JOINED)
public class CentreRegional extends CentrePostal{
    public CentreRegional(String nom, int numero, String rue, String quartier, String ville) {
        super(nom, numero, rue, quartier, ville);
    }

    public CentreRegional(String nom) {
        super(nom);
    }

    public CentreRegional() {
    }

    @OneToMany(mappedBy = "centreRegional",
            fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CentrePostal> centrePostals = new ArrayList<>();

    public void addCentrePostal(CentrePostal centrePostal) {
        this.centrePostals.add(centrePostal);}

    public void setCentreRegionalId(long Id) {
        super.setCentrePostalId(Id);
    }

    public List<CentrePostal> getCentrePostals() {
        return centrePostals;
    }

    public void setCentrePostals(List<CentrePostal> centrePostals) {
        this.centrePostals = centrePostals;
    }
}
