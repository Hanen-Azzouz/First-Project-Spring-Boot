package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Contrat;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.ContratRepository;

import java.util.Date;
import java.util.List;

@Service
public class ContratService implements  IContratService{
    @Autowired//equivalent à @Injected
    private ContratRepository icontratrepo;

    @Override
    public Contrat addContrat(Contrat c) {
        return icontratrepo.save(c);//si id de l'objet contrat c est null ou bien inexistant das bd dnc il l'ajoute
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return icontratrepo.save(c);//si id de l'objet contrat c est not null ou bien existant das bd dnc il le modifie
    }


    @Override
    public void deleteContrat(Contrat c) {

        icontratrepo.delete(c);
    }

    @Override
    public void deleteContrat(Long id) {

        icontratrepo.deleteById(id);
    }

    @Override
    public List<Contrat> findAllContrat()
    {

        return (List<Contrat>) icontratrepo.findAll();
    }

    @Override
    public Contrat findContartById(Long id) {
        return icontratrepo.findById(id).get();//fonction get() return  objet si il existe ou bien vide sinon
    }

    @Override
    public List<Contrat> searchContratByArchive(boolean archive) {

        return (List<Contrat>)icontratrepo.getByArchive(archive);
    }
   @Override
   public List<Contrat> searchContratByArchiveAndDateDebutC(boolean archive, Date datedebutc){
        return (List<Contrat>)icontratrepo.getContratByArchiveAndDateDebutC(archive,datedebutc);
   }
   @Override
  public List<Contrat> searchContratByDateDebutCBetween(Date date1,Date date2){
        return (List<Contrat>)icontratrepo.getContratByDateDebutCBetween(date1,date2);
   }

}
