package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.DetailsEquipe;

import java.util.List;

public interface IDetailsEquipeService {

    DetailsEquipe addDetailsEquipe(DetailsEquipe de);

    DetailsEquipe updateDetailsEquipe(DetailsEquipe de);

    void deleteDetailsEquipe(DetailsEquipe de);

    void deleteDetailsEquipe(Long id);

    List<DetailsEquipe> findAllDetailsEquipe();

    DetailsEquipe findDetailsEquipeById(Long id);
}
