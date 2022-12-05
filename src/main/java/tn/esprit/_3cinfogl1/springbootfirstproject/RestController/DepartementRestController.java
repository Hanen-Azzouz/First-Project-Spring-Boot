package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;
import tn.esprit._3cinfogl1.springbootfirstproject.Services.IDepartementService;

import java.util.List;

@RestController
@RequestMapping("departementRest")
public class DepartementRestController {
    @Autowired
    private IDepartementService IDepartementRest;

   @PostMapping("ajoutDepartement")
     Departement ajoutDepartement(@RequestBody Departement d) {
        return IDepartementRest.addDepartement(d) ;
    }

    @PutMapping("modifierDepartement")
     Departement modifierDepartement(@RequestBody Departement d) {

       return IDepartementRest.updateDepartement( d);
    }

   @DeleteMapping("supprimerDepartementobjet")
    void supprimerDepartement(Departement d) {
        IDepartementRest.deleteDepartement(d);
    }

   @DeleteMapping("supprimerDepartementid/{id}")
   void supprimerDepartement(@PathVariable  Long id) {
        IDepartementRest.deleteDepartement(id);
    }

@GetMapping("findAllDepartement")
    List<Departement> findAllDepartement() {
        return (List<Departement>) IDepartementRest.findAllDepartement();
    }

@GetMapping("findDepartementById/{id}")
    Departement findDepartementById(@PathVariable Long id) {

       return IDepartementRest.findDepartementById(id);
    }














}
