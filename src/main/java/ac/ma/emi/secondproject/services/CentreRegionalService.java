package ac.ma.emi.secondproject.services;


import ac.ma.emi.secondproject.repositories.CentreRegionalRepository;
import ac.ma.emi.secondproject.schemas.CentreRegional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import ac.ma.emi.secondproject.repositories.CentreRegionalRepository;
import org.springframework.stereotype.Service;

@Service
public class CentreRegionalService {

    private final CentreRegionalRepository centreRegionalRepository;


    @Autowired
    public CentreRegionalService(CentreRegionalRepository centreRegionalRepository) {
        this.centreRegionalRepository = centreRegionalRepository;

    }

    public List<CentreRegional> getAllCentreRegionals() {
        return centreRegionalRepository.findAll();
    }

    public CentreRegional getCentreRegionalById(Long centreRegionalId) {
        return centreRegionalRepository.findById(centreRegionalId)
                .orElseThrow(() -> new IllegalArgumentException("CentreRegional not found"));
    }

    public CentreRegional createCentreRegional(CentreRegional newCentreRegional) {
        return centreRegionalRepository.save(newCentreRegional);
    }

    public CentreRegional updateCentreRegional(Long centreRegionalId, CentreRegional updatedCentreRegional) {

        updatedCentreRegional.setCentreRegionalId(centreRegionalId);
        return centreRegionalRepository.save(updatedCentreRegional);
    }

    public void deleteCentreRegional(Long centreRegionalId) {
        centreRegionalRepository.deleteById(centreRegionalId);
    }

}
