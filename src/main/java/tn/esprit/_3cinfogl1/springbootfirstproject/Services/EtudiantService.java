package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.EtudiantRepository;

import java.util.List;

public class EtudiantService implements IEtudiantService {

    @Autowired//equivalent à @Injected
    private EtudiantRepository ietudiantrepo;

    @Override
    public Etudiant addEtudiant(Etudiant etud) {
        return ietudiantrepo.save(etud);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etud) {
        return ietudiantrepo.save(etud);
    }

    @Override
    public void deleteEtudiant(Etudiant etud) {
      ietudiantrepo.delete(etud);
    }

    @Override
    public void deleteEtudiant(Long id) {
        ietudiantrepo.deleteById(id);
    }

    @Override
    public List<Etudiant> findAllEtudiant() {
        return (List<Etudiant>) ietudiantrepo.findAll();
    }

    @Override
    public Etudiant findEtudiantById(Long id) {
        return ietudiantrepo.findById(id).get();
    }
}
