package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etud);
    Etudiant updateEtudiant(Etudiant etud);
    void deleteEtudiant(Etudiant etud);
    void deleteEtudiant(Long id);
    List<Etudiant> findAllEtudiant();
    Etudiant findEtudiantById(Long id);

}
