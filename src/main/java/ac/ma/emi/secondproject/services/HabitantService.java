package ac.ma.emi.secondproject.services;

import ac.ma.emi.secondproject.repositories.HabitantRepository;
import ac.ma.emi.secondproject.schemas.Habitant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class HabitantService {

    private final HabitantRepository HabitantRepository;


    @Autowired
    public HabitantService(HabitantRepository HabitantRepository) {
        this.HabitantRepository = HabitantRepository;

    }

    public List<Habitant> getAllHabitants() {
        return HabitantRepository.findAll();
    }

    public Habitant getHabitantById(Long HabitantId) {
        return HabitantRepository.findById(HabitantId)
                .orElseThrow(() -> new IllegalArgumentException("Habitant not found"));
    }

    public Habitant createHabitant(Habitant newHabitant) {
        return HabitantRepository.save(newHabitant);
    }

    public Habitant updateHabitant(Long HabitantId, Habitant updatedHabitant) {

        updatedHabitant.setHabitantId(HabitantId);
        return HabitantRepository.save(updatedHabitant);
    }

    public void deleteHabitant(Long HabitantId) {
        HabitantRepository.deleteById(HabitantId);
    }

}