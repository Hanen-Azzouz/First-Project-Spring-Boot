package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Equipe;
import tn.esprit._3cinfogl1.springbootfirstproject.Services.IEquipeService;

import java.util.List;

@RestController
    @RequestMapping("equipeRest")
   public class EquipeRestController {
        @Autowired
        private IEquipeService IEquipeRest;

   @PostMapping("ajouterEquipe")
     Equipe ajouterEquipe(@RequestBody Equipe eq) {
        return IEquipeRest.addEquipe(eq);
    }

    @PutMapping("modifierEquipe")
     Equipe modifierEquipe(@RequestBody Equipe eq) {

       return IEquipeRest.updateEquipe(eq);
    }

    @DeleteMapping("supprimerEquipeobjet")
     void supprimerEquipe(@RequestBody Equipe eq) {
      IEquipeRest.deleteEquipe(eq);
    }

    @DeleteMapping("supprimerEquipeid/{id}")
     void supprimerEquipe(@PathVariable Long id) {
       IEquipeRest.deleteEquipe(id);
        ;
    }
  @GetMapping("findAllEquipe")
     List<Equipe> findAllEquipe() {

        return (List<Equipe>) IEquipeRest.findAllEquipe();
    }
    @GetMapping("findEquipeById/{id}")
    Equipe findEquipeById(@PathVariable Long id) {

        return IEquipeRest.findEquipeById(id);
    }






}
