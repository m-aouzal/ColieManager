package ac.ma.emi.secondproject.Controllers;

import ac.ma.emi.secondproject.schemas.CentreLocal;
import ac.ma.emi.secondproject.services.CentreLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centreLocals")
public class CentreLocalController {

    private
    final CentreLocalService centreLocalService;

    @Autowired
    public CentreLocalController(CentreLocalService centreLocalService) {
        this.centreLocalService = centreLocalService;
    }

    @GetMapping
    public List<CentreLocal> getAllCentreLocals() {
        return centreLocalService.getAllCentreLocals();
    }

    @GetMapping("/{id}")
    public CentreLocal getCentreLocalById(@PathVariable("id") Long centreLocalId) {
        return centreLocalService.getCentreLocalById(centreLocalId);
    }

    @PostMapping
    public CentreLocal createCentreLocal(@RequestBody CentreLocal newCentreLocal) {
        return centreLocalService.createCentreLocal(newCentreLocal);
    }

    @PutMapping("/{id}")
    public CentreLocal updateCentreLocal(@PathVariable("id") Long centreLocalId, @RequestBody CentreLocal CentreLocalToUpdate) {
        return centreLocalService.updateCentreLocal(centreLocalId, CentreLocalToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteCentreLocal(@PathVariable("id") Long centreLocalId) {
        centreLocalService.deleteCentreLocal(centreLocalId);
    }
}