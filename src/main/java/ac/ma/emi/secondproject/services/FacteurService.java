package ac.ma.emi.secondproject.services;

import ac.ma.emi.secondproject.repositories.FacteurRepository;
import ac.ma.emi.secondproject.schemas.Facteur;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class FacteurService {

    private final FacteurRepository FacteurRepository;


    @Autowired
    public FacteurService(FacteurRepository FacteurRepository) {
        this.FacteurRepository = FacteurRepository;

    }

    public List<Facteur> getAllFacteurs() {
        return FacteurRepository.findAll();
    }

    public Facteur getFacteurById(Long FacteurId) {
        return FacteurRepository.findById(FacteurId)
                .orElseThrow(() -> new IllegalArgumentException("Facteur not found"));
    }

    public Facteur createFacteur(Facteur newFacteur) {
        return FacteurRepository.save(newFacteur);
    }

    public Facteur updateFacteur(Long FacteurId, Facteur updatedFacteur) {

        updatedFacteur.setFacteurId(FacteurId);
        return FacteurRepository.save(updatedFacteur);
    }

    public void deleteFacteur(Long FacteurId) {
        FacteurRepository.deleteById(FacteurId);
    }

}
