package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Equipe;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Niveau;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {


//la liste des etudiants de l'équipe dont son id est passé en paramétre(keyword)
    List<Etudiant> findByEquipesIdEquipe(long id);
//la liste des etudiants de l'équipe dont son id est passé en paramétre et la salle de détail équipe =12
    List<Etudiant> findByEquipesIdEquipeAndEquipesDetequipeSalle(long id,int salle);



    //afficher l'etudiant dont le nom et le prenom en parametres avec méthode jpql
    @Query("select student from Etudiant student where student.prenomE=:prenom and student.nomE=:nom" )
    Etudiant getEtudiantByPrenomEtNomJPQL(@Param(value = "nom") String nom, @Param(value="prenom") String prenom);

    //afficher l'etudiant dont le nom et le prenom en parametres avec méthode SQL


    //l'ordre est important , on peut numéroter 1,2 l'ordre dans requete est celui de méthode
    @Query(value="select * from etudiant where nome=?1 and prenome=?2",nativeQuery = true)
    Etudiant getEtudiantByPrenomEtNomSQL( String lastname, String firstname);



    @Query(value="select * from etudiant where nome=?1",nativeQuery = true)
    Etudiant getEtudiantByNomSql(String lastname);




    //Liste des étudiants avec un niveau passé en paramétre SQL(ManyToMany)

    @Query(value = "select alias1 from etudiant alias1 join equipe_etudiants alias2 " +
      "on alias1.id_etudiant=alias2.etudiants_id_etudiant join equipe alias3 on alias2.equipes_id_equipe=alias3.id_equipe " +
            "where alias3.niveau=:niv",nativeQuery = true)

    List<Etudiant> searchEtudiantByLevelParamSQL(@Param(value="niv") Niveau niveau);


    //Supprimer un étudiant dont le nom et le prénom sont pasés en paramétres avec JPQL
@Modifying
@Query("delete from Etudiant where nomE= :name and prenomE= :firstname ")
void supprimerEtudiantAvecNomEtPrenomJPQL(@Param(value="name")String nom,@Param(value="firstname")String prenom);

//Supprimer un étudiant dont le nom et le prénom sont pasés en paramétres avec  SQL

    @Modifying
    @Query(value = "delete from etudiant where nome= :name and prenome= :firstname ",nativeQuery = true)
    void supprimerEtudiantAvecNomEtPrenomSQL(@Param(value="name")String nom,@Param(value="firstname")String prenom);



}
