package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;

import tn.esprit._3cinfogl1.springbootfirstproject.Services.IEtudiantService;

import java.util.List;

   @RestController
  @RequestMapping("etudiantRest")
  public class EtudiantRestController {

       @Autowired
       private IEtudiantService IEtudiantRest;

      @PostMapping("jouterEtudiant")
     Etudiant jouterEtudiant(@RequestBody Etudiant etud) {
        return IEtudiantRest.addEtudiant(etud);
    }
     @PutMapping("modifierEtudiant")
     Etudiant modifierEtudiant(@RequestBody Etudiant etud) {

        return IEtudiantRest.updateEtudiant(etud);
    }
    @DeleteMapping("supprimerEtudiantobjet")
      void supprimerEtudiant(@RequestBody Etudiant etud) {
        IEtudiantRest.deleteEtudiant(etud);
    }
      @DeleteMapping("supprimerEtudiantid/{id}")
     void supprimerEtudiant(@PathVariable Long id) {
        IEtudiantRest.deleteEtudiant(id);
    }
    @GetMapping("findAllEtudiant")
     List<Etudiant> findAllEtudiant() {

        return (List<Etudiant>) IEtudiantRest.findAllEtudiant();
    }
    @GetMapping("findEtudiantById/{id}")
     Etudiant findEtudiantById(Long id) {

        return IEtudiantRest.findEtudiantById(id);
    }





}
