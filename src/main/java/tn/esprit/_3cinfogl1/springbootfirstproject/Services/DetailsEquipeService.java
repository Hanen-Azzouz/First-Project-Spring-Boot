package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.DetailsEquipe;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.DetailsEquipeRepository;

import java.util.List;

public class DetailsEquipeService implements  IDetailsEquipeService {
    @Autowired
    private DetailsEquipeRepository idetailsequiperepo;

    @Override
    public DetailsEquipe addDetailsEquipe(DetailsEquipe de) {
        return idetailsequiperepo.save(de);
    }

    @Override
    public DetailsEquipe updateDetailsEquipe(DetailsEquipe de) {
        return idetailsequiperepo.save(de);
    }

    @Override
    public void deleteDetailsEquipe(DetailsEquipe de) {
        idetailsequiperepo.delete(de);
    }

    @Override
    public void deleteDetailsEquipe(Long id) {
       idetailsequiperepo.deleteById(id);
    }

    @Override
    public List<DetailsEquipe> findAllDetailsEquipe() {
        return (List<DetailsEquipe>) idetailsequiperepo.findAll();
    }

    @Override
    public DetailsEquipe findDetailsEquipeById(Long id) {
        return idetailsequiperepo.findById(id).get();
    }
}
