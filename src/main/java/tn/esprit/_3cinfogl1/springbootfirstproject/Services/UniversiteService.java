package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Universite;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.DepartementRepository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.UniversiteRepository;

import java.util.List;
@Service
public class UniversiteService implements  IUniversiteService{
    @Autowired
    private UniversiteRepository iuniversiterepo;
    @Autowired
    private DepartementRepository idepartrepo;

    @Override
    public Universite addUniversite(Universite u) {
        return iuniversiterepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return iuniversiterepo.save(u);
    }

    @Override
    public void deleteUniversite(Universite u) {
           iuniversiterepo.delete(u);
    }

    @Override
    public void deleteUniversite(Long id) {
          iuniversiterepo.deleteById(id);
    }

    @Override
    public List<Universite> findAllUniversite() {
        return (List<Universite>) iuniversiterepo.findAll();
    }

    @Override
    public Universite findUniversiteById(Long id) {
        return iuniversiterepo.findById(id).get();
    }

@Override
public void assignUniversiteToDepartement(Integer idUniversite,Integer idDepartement){
Universite universiteaffecte=iuniversiterepo.findById(Long.valueOf(idUniversite)).get();




}



}
