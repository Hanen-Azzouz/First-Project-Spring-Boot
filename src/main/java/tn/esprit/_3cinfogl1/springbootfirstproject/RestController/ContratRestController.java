package tn.esprit._3cinfogl1.springbootfirstproject.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Contrat;
import tn.esprit._3cinfogl1.springbootfirstproject.Services.IContratService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("contratRest")
public class ContratRestController {

    @Autowired
    private IContratService IContratRest;
    //on doit faire l'injection de dépendance en déclarant une variable de type interface de service
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
    void supprimerContrat(@PathVariable long id){

    IContratRest.deleteContrat(id);
    }
    @GetMapping("findAllContrat")
    List<Contrat> findAllContrat(){

    return IContratRest.findAllContrat();
    }
    @GetMapping("findContartById")
    Contrat findContartById(@RequestParam long id){
//@RequestParam on ne met pas l'ID dans le mapping
    return  IContratRest.findContartById(id);
    }
    @GetMapping("searchContratByArchive/{archive}")
    List<Contrat> searchContratByArchive(@PathVariable boolean archive){
    return IContratRest.searchContratByArchive(archive);
    }
    @GetMapping("searchContratByIdEtudiantJPQL")
    List<Contrat> searchContratByIdEtudiantJPQL(@RequestParam Long idEtudiant){
    return  IContratRest.searchContratByIdEtudiantJPQL(idEtudiant);

    }
    @GetMapping("searchContratByIdEtudiantSQL")
    List<Contrat> searchContratByIdEtudiantSQL(@RequestParam Long idEtudiant){
    return  IContratRest.searchContratByIdEtudiantSQL(idEtudiant);
    }


    @GetMapping("searchContratByArchiveAndDateDebutC/{archive}/{datedebut}")
    List<Contrat> searchContratByArchiveAndDateDebutC(@PathVariable boolean archive,@PathVariable Date datedebut){
    return IContratRest.searchContratByArchiveAndDateDebutC(archive,datedebut);
    }
    @GetMapping("searchContratByDateDebutCBetween/{date1}/{date2}")
   List<Contrat> searchContratByDateDebutCBetween(@PathVariable Date date1,@PathVariable Date date2){
    return IContratRest.searchContratByDateDebutCBetween(date1, date2);

    }

}
