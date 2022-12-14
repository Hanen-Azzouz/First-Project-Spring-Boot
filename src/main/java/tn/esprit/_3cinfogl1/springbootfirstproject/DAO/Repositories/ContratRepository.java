package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Contrat;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat,Long> {

    //select * from contrat where archive=(valeur passée en paramétre)
    //get ou find contrat par  archive c une fonction personnalisée ca sera automatiquement la requete
    List<Contrat> getByArchive(boolean archive);

//select * from contrat where archive=(valeur) and dateDebutContrat=(parametre)
      // avec keywords
    List<Contrat> getContratByArchiveAndDateDebutC(boolean archive, Date datedebutc);


    //select * from contrat where dateDebutContrat>(param) and datedebutContrat<(parametre)
    List<Contrat> getContratByDateDebutCBetween(Date date1,Date date2);



    //Afficher liste des contrats d'un étudiant dont l'Id est passé en paramétre avec jpql


    @Query("select alias1 from Contrat alias1,Etudiant alias2 where " +
            "alias1.students.idEtudiant=alias2.idEtudiant and alias2.idEtudiant=?1")
    List<Contrat> searchContratByIdEtudiantJPQL(Long idEtudiant);



    //Afficher liste des contrats d'un étudiant dont l'Id est passé en paramétre avec SQL

   @Query(value ="select alias1 from contrat alias1 join etudiant alias2 " +
            "on alias1.students_id_etudiant=alias2.id_etudiant where alias2.id_etudiant=?1",nativeQuery = true)

   List<Contrat> searchContratByIdEtudiantSQL(Long idEtudiant);


}
