package ac.ma.emi.secondproject.Controllers;

import ac.ma.emi.secondproject.schemas.Habitant;
import ac.ma.emi.secondproject.services.HabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitants")
public class HabitantController {

    private
    final HabitantService habitantService;


    @Autowired
    public HabitantController(HabitantService habitantService) {
        this.habitantService = habitantService;
    }

    @GetMapping
    public List<Habitant> getAllHabitants() {
        return habitantService.getAllHabitants();
    }

    @GetMapping("/{id}")
    public Habitant getHabitantById(@PathVariable("id") Long habitantId) {
        return habitantService.getHabitantById(habitantId);
    }

    @PostMapping
    public Habitant createHabitant(@RequestBody Habitant newHabitant) {
        return habitantService.createHabitant(newHabitant);
    }

    @PutMapping("/{id}")
    public Habitant updateHabitant(@PathVariable("id") Long habitantId, @RequestBody Habitant HabitantToUpdate) {
        return habitantService.updateHabitant(habitantId, HabitantToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteHabitant(@PathVariable("id") Long habitantId) {
        habitantService.deleteHabitant(habitantId);
    }
}
