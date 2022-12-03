package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Contrat;
import tn.esprit._3cinfogl1.springbootfirstproject.Services.IContratService;

import java.util.List;

@RestController
@RequestMapping("contratRest")
public class ContratRestController {

    @Autowired
    private IContratService IContratRest;
@PostMapping("ajoutContrat")
    Contrat ajoutContrat(@RequestBody Contrat c){
        return IContratRest.addContrat(c);

    }
    @PutMapping("modifierContrat")
    Contrat modifierContrat(@RequestBody Contrat c){
        return IContratRest.updateContrat(c);
    }
    @DeleteMapping("supprimerContratobjet")
    void supprimerContrat(@RequestBody Contrat c){
        IContratRest.deleteContrat(c);
    }
    @DeleteMapping("supprimerContratid/{id}")
    void supprimerContrat(@PathVariable Long id){
        IContratRest.deleteContrat(id);
    }
    @GetMapping("findAllContrat")
    List<Contrat> findAllContrat(){
        return IContratRest.findAllContrat();
    }
    @GetMapping("findContartById")
    Contrat findContartById(@RequestParam Long id){//@RequestParam on ne met pas l'ID dans le mapping
      return  IContratRest.findContartById(id);
    }

}
