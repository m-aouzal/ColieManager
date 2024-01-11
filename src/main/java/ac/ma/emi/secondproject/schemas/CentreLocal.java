package ac.ma.emi.secondproject.schemas;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import static jakarta.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy = JOINED)
public class CentreLocal extends CentrePostal {
    public CentreLocal(String nom, int numero, String rue, String quartier, String ville) {
        super(nom, numero, rue, quartier, ville);
    }

    public void setCentreLocalId(long Id) {
        super.setCentrePostalId(Id);
    }
    public CentreLocal(String nom) {
        super(nom);
    }

    public CentreLocal() {
    }
}
