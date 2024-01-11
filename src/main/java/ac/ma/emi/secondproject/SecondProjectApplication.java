package ac.ma.emi.secondproject;

import ac.ma.emi.secondproject.repositories.CentreLocalRepository;
import ac.ma.emi.secondproject.repositories.ColieRepository;
import ac.ma.emi.secondproject.repositories.FacteurRepository;
import ac.ma.emi.secondproject.repositories.HabitantRepository;
import ac.ma.emi.secondproject.schemas.CentreLocal;
import ac.ma.emi.secondproject.schemas.Colie;
import ac.ma.emi.secondproject.schemas.Facteur;
import ac.ma.emi.secondproject.schemas.Habitant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecondProjectApplication.class, args);
    }


    @Autowired
    HabitantRepository habitantRepository;
    @Autowired
    CentreLocalRepository centreLocalRepository;
    @Autowired
    ColieRepository colieRepository;
    @Autowired
    FacteurRepository facteurRepository;

    @Override
    public void run(String... args) throws Exception {


        CentreLocal centreLocal = new CentreLocal("centreCasa");
        this.centreLocalRepository.save(centreLocal);

        Habitant habitant1 = new Habitant("mohamed", "aouzal");
        Habitant habitant2 = new Habitant("yassine", "Bentayfor");
// Save habitant1 and habitant2 before referencing them in Colie
        this.habitantRepository.save(habitant1);
        this.habitantRepository.save(habitant2);

        Colie colie = new Colie(123);
        colie.setHabitantEmetteur(habitant2);
        colie.setHabitantDestinataire(habitant1);

// Save colie before adding it to habitants
        this.colieRepository.save(colie);

// Update habitants with colie references
        habitant1.addColieEmi(colie);
        habitant2.addColieEnvoye(colie);

// Save habitants after updating their collections
        this.habitantRepository.save(habitant1);
        this.habitantRepository.save(habitant2);

        Facteur facteur = new Facteur(/* properties for facteur */);
        facteur.setCentrePostal(centreLocal);
        facteur.setColie(colie);

// Save facteur after setting colie reference
        this.facteurRepository.save(facteur);
    }
}
