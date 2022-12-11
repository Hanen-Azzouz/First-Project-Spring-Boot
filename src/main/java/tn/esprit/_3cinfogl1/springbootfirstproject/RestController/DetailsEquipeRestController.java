package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.DetailsEquipe;
import tn.esprit._3cinfogl1.springbootfirstproject.Services.IDetailsEquipeService;

import java.util.List;

@RestController
 @RequestMapping("detailsEquipeRest")
 public class DetailsEquipeRestController {

     @Autowired
     private IDetailsEquipeService IDetailsequipeRest;

     @PostMapping("ajouterDetailsEquipe")
     DetailsEquipe ajouterDetailsEquipe(@RequestBody DetailsEquipe de) {
        return IDetailsequipeRest.addDetailsEquipe(de) ;
    }

    @PutMapping("modifierDetailsEquipe")
     DetailsEquipe modifierDetailsEquipe(@RequestBody DetailsEquipe de) {
        return IDetailsequipeRest.updateDetailsEquipe(de);
    }

    @DeleteMapping("supprimerDetailsEquipeobjet")
     void supprimerDetailsEquipe(@RequestBody DetailsEquipe de) {
        IDetailsequipeRest.deleteDetailsEquipe(de);
    }

   @DeleteMapping("supprimerDetailsEquipe/{id}")
     void supprimerDetailsEquipe(@PathVariable Long id) {

         IDetailsequipeRest.deleteDetailsEquipe(id);
    }

    @GetMapping("findAllDetailsEquipe")
       List<DetailsEquipe> findAllDetailsEquipe() {

        return (List<DetailsEquipe>) IDetailsequipeRest.findAllDetailsEquipe();
    }

     @GetMapping("findDetailsEquipeById/{id}")
     DetailsEquipe findDetailsEquipeById(@PathVariable Long id) {

         return IDetailsequipeRest.findDetailsEquipeById(id);
    }






}
