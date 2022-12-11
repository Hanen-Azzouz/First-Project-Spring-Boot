package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {


//la liste des etudiants de l'équipe dont son id est passé en paramétre(keyword)
    List<Etudiant> findByEquipesIdEquipe(long id);
//la liste des etudiants de l'équipe dont son id est passé en paramétre et la salle de détail équipe =12
    List<Etudiant> findByEquipesIdEquipeAnAndEquipesdetequipeSalle(long id,int salle);



    //afficher l'etudiant dont le nom et le prenom en parametres avec méthode jpql
    @Query("select student from Etudiant student where student.prenomE=:prenom and student.nomE=:nom" )
    Etudiant getEtudiantByPrenomEtNomJPQL(@Param(value = "nom") String nom, @Param(value="prenom") String prenom);

    //afficher l'etudiant dont le nom et le prenom en parametres avec méthode SQL


    //l'ordre est important , on peut numéroter 1,2 l'ordre dans requete est celui de méthode
    @Query(value="select * from etudiant where nome=?1 and prenome=?2",nativeQuery = true)
    Etudiant getEtudiantByPrenomEtNomSQL( String lastname, String firstname);



    @Query(value="select * from etudiant where nome=?1",nativeQuery = true)
    Etudiant getEtudiantByNomSql(String lastname);
}
