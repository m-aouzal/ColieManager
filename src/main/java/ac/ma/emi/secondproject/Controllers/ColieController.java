package ac.ma.emi.secondproject.Controllers;

import ac.ma.emi.secondproject.schemas.Colie;
import ac.ma.emi.secondproject.services.ColieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colies")
public class ColieController {

    private
    final ColieService colieService;

    @Autowired
    public ColieController(ColieService colieService) {
        this.colieService = colieService;
    }

    @GetMapping
    public List<Colie> getAllColies() {
        return colieService.getAllColies();
    }

    @GetMapping("/{id}")
    public Colie getColieById(@PathVariable("id") Long colieId) {
        return colieService.getColieById(colieId);
    }

    @PostMapping
    public Colie createColie(@RequestBody Colie newColie) {
        return colieService.createColie(newColie);
    }

    @PutMapping("/{id}")
    public Colie updateColie(@PathVariable("id") Long colieId, @RequestBody Colie ColieToUpdate) {
        return colieService.updateColie(colieId, ColieToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteColie(@PathVariable("id") Long colieId) {
        colieService.deleteColie(colieId);
    }
}