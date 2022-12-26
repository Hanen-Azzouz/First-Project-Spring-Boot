package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.*;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.ContratRepository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.DepartementRepository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.EquipeRepository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.EtudiantRepository;

import java.util.List;
@Service
public class EtudiantService implements IEtudiantService {

    @Autowired//equivalent à @Injected
    private EtudiantRepository ietudiantrepo;
    @Autowired
    private DepartementRepository idepartrepo;
    @Autowired
    private ContratRepository icontratrepo;
    @Autowired
    private EquipeRepository iequiperepo;

    @Override
    public Etudiant addEtudiant(Etudiant etud) {
        return ietudiantrepo.save(etud);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etud) {

        return ietudiantrepo.save(etud);
    }

    @Override
    public void deleteEtudiant(Etudiant etud) {
      ietudiantrepo.delete(etud);
    }

    @Override
    public void deleteEtudiant(Long id) {
        ietudiantrepo.deleteById(id);
    }

    @Override
    public List<Etudiant> findAllEtudiant() {

        return (List<Etudiant>) ietudiantrepo.findAll();
    }

    @Override
    public Etudiant findEtudiantById(Long id) {

        return ietudiantrepo.findById(id).get();



    }


    //Recherche en utilisant keywords
    @Override
    public List<Etudiant> findByIdEquipeAndSalle(Long id,int salle){
        return ietudiantrepo.findByEquipesIdEquipeAndEquipesDetequipeSalle(id,salle);
    }
    @Override
    public List<Etudiant> findByIdEquipe(long id){
        return ietudiantrepo.findByEquipesIdEquipe(id);
    }
    //Recherche en utilisant JPQL
    @Override
    public  Etudiant searchEtudiantByNomEtPrenomJpql(String nom,String prenom){
        return  ietudiantrepo.getEtudiantByPrenomEtNomJPQL(nom, prenom);
    }
    //Recherche en utilisant SQL
    @Override
    public  Etudiant searchEtudiantByNomEtPrenomSql(String nom,String prenom) {
     return  ietudiantrepo.getEtudiantByPrenomEtNomSQL(nom,prenom);
    }


    @Override
    public Etudiant searchEtudiantByNomSql(String nom){
        return ietudiantrepo.getEtudiantByNomSql(nom);

    }

    @Override
    public Etudiant searchEtudiantByLevelParamSQL( Niveau niveau){
        return (Etudiant) ietudiantrepo.searchEtudiantByLevelParamSQL(niveau);
    }

    @Override
    public  void deleteEtudiantByNomEtPrenomJPQL(String nom,String prenom){
       ietudiantrepo.supprimerEtudiantAvecNomEtPrenomJPQL(nom,prenom);
    }
    @Override
   public  void deleteEtudiantByNomEtPrenomSQL(String nom,String prenom){
    ietudiantrepo.supprimerEtudiantAvecNomEtPrenomSQL(nom,prenom);
    }


    //Affecter un département à un étudiant : les identifiants passés en paramétres

    @Override
    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId){
       Etudiant studentaffecte=ietudiantrepo.findById(Long.valueOf(etudiantId)).get();
        Departement departementaffecte=idepartrepo.findById(Long.valueOf(departementId)).get();
        //etudiant est parent departement child


        studentaffecte.setDepart(departementaffecte);
        ietudiantrepo.save(studentaffecte);
       //save pour le parent

    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer
            idEquipe)
    {
        Contrat contrataffecte = icontratrepo.findById(Long.valueOf(idContrat)).get();
        Equipe equipeaffectee = iequiperepo.findById(Long.valueOf(idEquipe)).get();
        e.getEquipes().add(equipeaffectee);
        e.getContrats().add(contrataffecte);
        return ietudiantrepo.save(e);
    }




    }
