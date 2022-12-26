package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Universite;
import tn.esprit._3cinfogl1.springbootfirstproject.Services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("universiteRest")
public class UniversiteRestController {

    @Autowired
    private IUniversiteService IUniversiteRest;

    @PostMapping("ajouterUniversite")
    Universite ajouterUniversite(@RequestBody Universite u) {
        return IUniversiteRest.addUniversite(u);
    }

    @PutMapping("modifierUniversite")
    Universite modifierUniversite(@RequestBody Universite u) {

        return IUniversiteRest.updateUniversite(u);
    }

    @DeleteMapping("supprimerUniversiteobjet")
    void supprimerUniversite(@RequestBody Universite u) {

        IUniversiteRest.deleteUniversite(u);
    }

    @DeleteMapping("supprimerUniversiteid/{id}")
    void supprimerUniversite(@PathVariable long id) {

        IUniversiteRest.deleteUniversite(id);
    }

    @GetMapping("findAllUniversite")
    List<Universite> findAllUniversite() {

        return (List<Universite>) IUniversiteRest.findAllUniversite();
    }

    @GetMapping("findUniversiteById/{id}")
    Universite findUniversiteById(@PathVariable long id) {

        return IUniversiteRest.findUniversiteById(id);
    }

    @PutMapping("affecterDepartementToUniversite")
    void affecterDepartementToUniversite(@RequestParam Integer universiteId , @RequestParam Integer departementId) {
        IUniversiteRest.assignUniversiteToDepartement(universiteId,departementId);

    }
}



