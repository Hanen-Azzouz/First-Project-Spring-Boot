package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.DepartementRepository;

import java.util.List;
@Service
public class DepartementService implements IDepartementService{

    //on doit faire l'injection de dépendance en déclarant une variable de type repository relatif au service
    @Autowired
    private DepartementRepository idepartrepo;

    @Override
    public Departement addDepartement(Departement d) {
        return idepartrepo.save(d) ;
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return idepartrepo.save(d);
    }

    @Override
    public void deleteDepartement(Departement d) {
         idepartrepo.delete(d);
    }

    @Override
    public void deleteDepartement(Long id) {
      idepartrepo.deleteById(id);
    }

    @Override
    public List<Departement> findAllDepartement() {
        return (List<Departement>) idepartrepo.findAll();
    }

    @Override
    public Departement findDepartementById(Long id) {

        return idepartrepo.findById(id).get() ;
    }
}
