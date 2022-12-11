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


    //functions with Keywords

    List<Etudiant> findByIdEquipeAndSalle(Long id,int salle);

    List<Etudiant> findByIdEquipe(long id);


    Etudiant searchEtudiantByNomEtPrenomJpql(String nom,String prenom);
    Etudiant searchEtudiantByNomEtPrenomSql(String nom,String prenom);
    Etudiant searchEtudiantByNomSql(String nom);


}
