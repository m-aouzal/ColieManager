package ac.ma.emi.secondproject.Controllers;

import ac.ma.emi.secondproject.schemas.Facteur;
import ac.ma.emi.secondproject.services.FacteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Facteurs")
public class FacteurController {

    private
    final FacteurService facteurService;

    @Autowired
    public FacteurController(FacteurService facteurService) {
        this.facteurService = facteurService;
    }

    @GetMapping
    public List<Facteur> getAllFacteurs() {
        return facteurService.getAllFacteurs();
    }

    @GetMapping("/{id}")
    public Facteur getFacteurById(@PathVariable("id") Long facteurId) {
        return facteurService.getFacteurById(facteurId);
    }

    @PostMapping
    public Facteur createFacteur(@RequestBody Facteur newFacteur) {
        return facteurService.createFacteur(newFacteur);
    }

    @PutMapping("/{id}")
    public Facteur updateFacteur(@PathVariable("id") Long facteurId, @RequestBody Facteur FacteurToUpdate) {
        return facteurService.updateFacteur(facteurId, FacteurToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteFacteur(@PathVariable("id") Long facteurId) {
        facteurService.deleteFacteur(facteurId);
    }
}