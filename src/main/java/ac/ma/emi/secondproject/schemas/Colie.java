package ac.ma.emi.secondproject.schemas;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Colie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colieId;

    private long numero;
    private Date dateDepot;
    private Date dateReception;

    @ManyToOne
    @JoinColumn(
            name = "habitant_emetteur"
    )
    private Habitant habitantEmetteur;

    @ManyToOne
    @JoinColumn(
            name = "habitant_destinataire"
    )
    private Habitant habitantDestinataire;

    @ManyToOne
    @JoinColumn(
            name = "facteur"
    )
    private Facteur facteur;

    @ManyToMany
    @JoinTable(
            name = "coli_centrePostal",
            joinColumns = @JoinColumn(
                    name = "coli"

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "centre_Postal"

            )
    )
    private List<CentrePostal> centrePostals = new ArrayList<>();

    public void addCentrePostal(CentrePostal centrePostal){
        this.centrePostals.add(centrePostal);
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Habitant getHabitantEmetteur() {
        return habitantEmetteur;
    }

    public void setHabitantEmetteur(Habitant habitantEmetteur) {
        this.habitantEmetteur = habitantEmetteur;
    }

    public Habitant getHabitantDestinataire() {
        return habitantDestinataire;
    }

    public void setHabitantDestinataire(Habitant habitantDestinataire) {
        this.habitantDestinataire = habitantDestinataire;
    }

    public Facteur getFacteur() {
        return facteur;
    }

    public void setFacteur(Facteur facteur) {
        this.facteur = facteur;
    }

    public List<CentrePostal> getCentrePostals() {
        return centrePostals;
    }

    public void setCentrePostals(List<CentrePostal> centrePostals) {
        this.centrePostals = centrePostals;
    }

    public Long getColieId() {
        return colieId;
    }

    public void setColieId(Long colieId) {
        this.colieId = colieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colie colie = (Colie) o;
        return numero == colie.numero && Objects.equals(colieId, colie.colieId) && Objects.equals(dateDepot, colie.dateDepot) && Objects.equals(dateReception, colie.dateReception) && Objects.equals(habitantEmetteur, colie.habitantEmetteur) && Objects.equals(habitantDestinataire, colie.habitantDestinataire) && Objects.equals(facteur, colie.facteur) && Objects.equals(centrePostals, colie.centrePostals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colieId, numero, dateDepot, dateReception, habitantEmetteur, habitantDestinataire, facteur, centrePostals);
    }

    @Override
    public String toString() {
        return "Colie{" +
                "colieId=" + colieId +
                ", numero=" + numero +
                ", dateDepot=" + dateDepot +
                ", dateReception=" + dateReception +
                ", habitantEmetteur=" + habitantEmetteur +
                ", habitantDestinataire=" + habitantDestinataire +
                ", facteur=" + facteur +
                ", centrePostals=" + centrePostals +
                '}';
    }

    public Colie(long numero) {
        this.numero = numero;
    }

    public Colie() {
    }

    public Colie(Long colieId, long numero, Date dateDepot, Date dateReception, Habitant habitantEmetteur, Habitant habitantDestinataire, Facteur facteur, List<CentrePostal> centrePostals) {
        this.colieId = colieId;
        this.numero = numero;
        this.dateDepot = dateDepot;
        this.dateReception = dateReception;
        this.habitantEmetteur = habitantEmetteur;
        this.habitantDestinataire = habitantDestinataire;
        this.facteur = facteur;
        this.centrePostals = centrePostals;
    }

}

