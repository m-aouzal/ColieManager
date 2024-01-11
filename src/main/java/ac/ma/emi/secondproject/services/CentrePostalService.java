package ac.ma.emi.secondproject.services;


import ac.ma.emi.secondproject.schemas.CentrePostal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import ac.ma.emi.secondproject.repositories.CentrePostalRepository;
import org.springframework.stereotype.Service;

@Service
public class CentrePostalService {

    private final CentrePostalRepository CentrePostalRepository;


    @Autowired
    public CentrePostalService(CentrePostalRepository CentrePostalRepository) {
        this.CentrePostalRepository = CentrePostalRepository;

    }

    public List<CentrePostal> getAllCentrePostals() {
        return CentrePostalRepository.findAll();
    }

    public CentrePostal getCentrePostalById(Long CentrePostalId) {
        return CentrePostalRepository.findById(CentrePostalId)
                .orElseThrow(() -> new IllegalArgumentException("CentrePostal not found"));
    }

    public CentrePostal createCentrePostal(CentrePostal newCentrePostal) {
        return CentrePostalRepository.save(newCentrePostal);
    }

    public CentrePostal updateCentrePostal(Long CentrePostalId, CentrePostal updatedCentrePostal) {

        updatedCentrePostal.setCentrePostalId(CentrePostalId);
        return CentrePostalRepository.save(updatedCentrePostal);
    }

    public void deleteCentrePostal(Long CentrePostalId) {
        CentrePostalRepository.deleteById(CentrePostalId);
    }

}