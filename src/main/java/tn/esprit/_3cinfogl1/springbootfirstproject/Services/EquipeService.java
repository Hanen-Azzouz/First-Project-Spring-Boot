package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Equipe;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.EquipeRepository;

import java.util.List;
@Service
public class EquipeService implements  IEquipeService{
    @Autowired//equivalent à @Injected
    private EquipeRepository iequiperepo;

    @Override
    public Equipe addEquipe(Equipe eq) {
        return iequiperepo.save(eq);
    }

    @Override
    public Equipe updateEquipe(Equipe eq) {
        return iequiperepo.save(eq);
    }

    @Override
    public void deleteEquipe(Equipe eq) {
       iequiperepo.delete(eq);
    }

    @Override
    public void deleteEquipe(Long id) {
        iequiperepo.deleteById(id);
    }

    @Override
    public List<Equipe> findAllEquipe() {
        return (List<Equipe>) iequiperepo.findAll();
    }

    @Override
    public Equipe findEquipeById(Long id) {
        return iequiperepo.findById(id).get();
    }
}
