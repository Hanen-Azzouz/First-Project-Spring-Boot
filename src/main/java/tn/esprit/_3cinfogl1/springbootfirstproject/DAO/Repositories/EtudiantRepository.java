package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {


//la liste des etudiants de l'équipe dont son id est passé en paramétre
   // List<Etudiant> findByEquipesIdEquipe(long id);
//la liste des etudiants de l'équipe dont son id est passé en paramétre et la salle de détail équipe =12
   // List<Etudiant> findByEquipesIdEquipeAnAndEquipesdetequipeSalle(int id,int salle);


}
