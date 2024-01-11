package ac.ma.emi.secondproject.Controllers;

import ac.ma.emi.secondproject.schemas.CentreRegional;
import ac.ma.emi.secondproject.services.CentreRegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centreRegionals")
public class CentreRegionalController {

    private
    final CentreRegionalService centreRegionalService;

    @Autowired
    public CentreRegionalController(CentreRegionalService centreRegionalService) {
        this.centreRegionalService = centreRegionalService;
    }

    @GetMapping
    public List<CentreRegional> getAllCentreRegionals() {
        return centreRegionalService.getAllCentreRegionals();
    }

    @GetMapping("/{id}")
    public CentreRegional getCentreRegionalById(@PathVariable("id") Long centreRegionalId) {
        return centreRegionalService.getCentreRegionalById(centreRegionalId);
    }

    @PostMapping
    public CentreRegional createCentreRegional(@RequestBody CentreRegional newCentreRegional) {
        return centreRegionalService.createCentreRegional(newCentreRegional);
    }

    @PutMapping("/{id}")
    public CentreRegional updateCentreRegional(@PathVariable("id") Long centreRegionalId, @RequestBody CentreRegional CentreRegionalToUpdate) {
        return centreRegionalService.updateCentreRegional(centreRegionalId, CentreRegionalToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteCentreRegional(@PathVariable("id") Long centreRegionalId) {
        centreRegionalService.deleteCentreRegional(centreRegionalId);
    }
}
