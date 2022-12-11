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

      @PostMapping("ajouterEtudiant")
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
     Etudiant findEtudiantById(@PathVariable Long id) {

        return IEtudiantRest.findEtudiantById(id);
    }




    @GetMapping("findByIdEquipeAndSalle/{idequipe}/{salle}")
      List<Etudiant> findByIdEquipeAndSalle(@PathVariable Long idequipe,@PathVariable Integer salle){
          return  IEtudiantRest.findByIdEquipeAndSalle(idequipe,salle);
    }
       @GetMapping("findByIdEquipe/{idequipe}")

       List<Etudiant> findByIdEquipe(long id){
     return IEtudiantRest.findByIdEquipe(id);

       }

   @GetMapping("searchEtudiantByNomAndPrenomJpql/{nom}{prenom}")
       Etudiant searchEtudiantByNomAndPrenomJpql(@PathVariable String nom,@PathVariable String prenom)
   {
       return IEtudiantRest.searchEtudiantByNomEtPrenomJpql(nom,prenom);

   }
   @GetMapping("searchEtudiantByNomEtPrenomSql/{nom}/{prenom}")
       Etudiant searchEtudiantByNomEtPrenomSql(@PathVariable String nom,@PathVariable String prenom){
          return  IEtudiantRest.searchEtudiantByNomEtPrenomSql(nom,prenom);
       }

   @GetMapping("searchEtudiantByNomSql/{nom}")
   Etudiant searchEtudiantByNomSql(@RequestParam String nom){
          return IEtudiantRest.searchEtudiantByNomSql(nom);
   }
}
