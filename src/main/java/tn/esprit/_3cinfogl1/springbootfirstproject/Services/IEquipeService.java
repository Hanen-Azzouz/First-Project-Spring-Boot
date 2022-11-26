package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Equipe;

import java.util.List;

public interface IEquipeService {

    Equipe addEquipe(Equipe eq);

    Equipe updateEquipe(Equipe eq);

    void deleteEquipe(Equipe eq);

    void deleteEquipe(Long id);

    List<Equipe> findAllEquipe();

    Equipe findEquipeById(Long id);
}
