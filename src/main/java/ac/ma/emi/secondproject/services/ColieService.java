package ac.ma.emi.secondproject.services;

import ac.ma.emi.secondproject.repositories.ColieRepository;
import ac.ma.emi.secondproject.schemas.Colie;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;
@Service public class ColieService
{

private final ColieRepository ColieRepository;


    @Autowired public ColieService(ColieRepository ColieRepository)
    {
        this.ColieRepository = ColieRepository;

    }

public
    List<Colie> getAllColies()
    {
        return ColieRepository.findAll();
    }

public
    Colie getColieById(Long ColieId)
    {
        return ColieRepository.findById(ColieId)
            .orElseThrow(()->new IllegalArgumentException("Colie not found"));
    }

public
    Colie createColie(Colie newColie)
    {
        return ColieRepository.save(newColie);
    }

public
    Colie updateColie(Long ColieId, Colie updatedColie)
    {

        updatedColie.setColieId(ColieId);
        return ColieRepository.save(updatedColie);
    }

public
    void deleteColie(Long ColieId)
    {
        ColieRepository.deleteById(ColieId);
    }

}