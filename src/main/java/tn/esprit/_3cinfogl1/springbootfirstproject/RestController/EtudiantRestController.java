package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Niveau;
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
     void supprimerEtudiant(@PathVariable long id) {

          IEtudiantRest.deleteEtudiant(id);
    }
    @GetMapping("findAllEtudiant")
     List<Etudiant> findAllEtudiant() {

        return (List<Etudiant>) IEtudiantRest.findAllEtudiant();
    }
    @GetMapping("findEtudiantById/{id}")
     Etudiant findEtudiantById(@PathVariable long id) {

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

   @GetMapping("searchEtudiantByNomAndPrenomJpql/{nom}/{prenom}")
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
          @GetMapping("searchEtudiantByLevelParamSQL")
       Etudiant searchEtudiantByLevelParamSQL( @RequestParam Niveau niveau){
          return IEtudiantRest.searchEtudiantByLevelParamSQL(niveau);
          }

   @DeleteMapping("deleteEtudiantByNomEtPrenomJPQL")
       void deleteEtudiantByNomEtPrenomJPQL(@RequestParam String nom,@RequestParam String prenom){
          IEtudiantRest.deleteEtudiantByNomEtPrenomJPQL(nom,prenom);
   }
       @DeleteMapping("deleteEtudiantByNomEtPrenomSQL")
       void deleteEtudiantByNomEtPrenomSQL(@RequestParam String nom,@RequestParam String prenom){
           IEtudiantRest.deleteEtudiantByNomEtPrenomSQL(nom,prenom);
       }




   @PutMapping("affecteretudiantdepartement")
       void affecterEtudiantDepartement(@RequestParam Integer etudiantId, @RequestParam Integer departementId){

          IEtudiantRest.assignEtudiantToDepartement(etudiantId,departementId);

   }
   @PostMapping("addAndAssignEtudiantToEquipeAndContract")
       Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Integer idContrat, Integer
               idEquipe)
   {
       return  IEtudiantRest.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);

   }



   }
