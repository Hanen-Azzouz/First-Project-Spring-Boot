package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;

import java.util.List;

public interface IDepartementService {

    Departement addDepartement(Departement d);

    Departement updateDepartement(Departement d);

    void deleteDepartement(Departement d);

    void deleteDepartement(Long id);

    List<Departement> findAllDepartement();

    Departement findDepartementById(Long id);

}
