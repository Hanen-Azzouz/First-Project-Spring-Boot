package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.EtudiantRepository;

import java.util.List;
@Service
public class EtudiantService implements IEtudiantService {

    @Autowired//equivalent à @Injected
    private EtudiantRepository ietudiantrepo;

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
        return ietudiantrepo.findByEquipesIdEquipeAnAndEquipesdetequipeSalle(id,salle);
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
    }
