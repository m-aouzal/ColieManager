package ac.ma.emi.secondproject.services;


import ac.ma.emi.secondproject.schemas.CentreLocal;
import org.springframework.beans.factory.annotation.Autowired;
import ac.ma.emi.secondproject.repositories.CentreLocalRepository;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CentreLocalService {

    private final CentreLocalRepository CentreLocalRepository;


    @Autowired
    public CentreLocalService(CentreLocalRepository CentreLocalRepository) {
        this.CentreLocalRepository = CentreLocalRepository;

    }

    public List<CentreLocal> getAllCentreLocals() {
        return CentreLocalRepository.findAll();
    }

    public CentreLocal getCentreLocalById(Long CentreLocalId) {
        return CentreLocalRepository.findById(CentreLocalId)
                .orElseThrow(() -> new IllegalArgumentException("CentreLocal not found"));
    }

    public CentreLocal createCentreLocal(CentreLocal newCentreLocal) {
        return CentreLocalRepository.save(newCentreLocal);
    }

    public CentreLocal updateCentreLocal(Long CentreLocalId, CentreLocal updatedCentreLocal) {

        updatedCentreLocal.setCentreLocalId(CentreLocalId);
        return CentreLocalRepository.save(updatedCentreLocal);
    }

    public void deleteCentreLocal(Long CentreLocalId) {
        CentreLocalRepository.deleteById(CentreLocalId);
    }

}