package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {


    Contrat addContrat(Contrat c);
    Contrat updateContrat(Contrat c);
    void deleteContrat(Contrat c);
    void deleteContrat(Long id);
    List<Contrat> findAllContrat();
    Contrat findContartById(Long id);
    List<Contrat> searchContratByArchive(boolean  archive);

    List<Contrat> searchContratByIdEtudiantJPQL(Long idEtudiant);

    List<Contrat> searchContratByIdEtudiantSQL(Long idEtudiant);


    List<Contrat> searchContratByArchiveAndDateDebutC(boolean archive, Date datedebutc);
    List<Contrat> searchContratByDateDebutCBetween(Date date1,Date date2);


    Contrat affectContratToEtudiant (Contrat ce, String nom,String prenomE );
    String retrieveAndUpdateStatusContrat();

}
