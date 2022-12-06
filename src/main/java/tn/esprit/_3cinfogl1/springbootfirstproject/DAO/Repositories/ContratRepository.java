package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

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

    List<Contrat> getContratByArchiveAndDateDebutC(boolean archive, Date datedebutc);


    //select * from contrat where dateDebutContrat>(param) and datedebutContrat<(parametre)
    List<Contrat> getContratByDateDebutCBetween(Date date1,Date date2);


}
