package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Universite;

import java.util.List;

public interface IUniversiteService {



    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    void deleteUniversite(Universite u);

    void deleteUniversite(Long id);

    List<Universite> findAllUniversite();

    Universite findUniversiteById(Long id);
}
