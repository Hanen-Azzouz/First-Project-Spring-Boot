package tn.esprit._3cinfogl1.springbootfirstproject.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Contrat;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.ContratRepository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Slf4j
@Service
public class ContratService implements  IContratService{
    @Autowired//equivalent à @Injected
    private ContratRepository icontratrepo;

    @Autowired
    private EtudiantRepository ietudiantrepo;

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
   public  List<Contrat> searchContratByIdEtudiantJPQL(Long idEtudiant){
     return (List<Contrat>) icontratrepo.searchContratByIdEtudiantJPQL(idEtudiant);
    }
    @Override
    public List<Contrat> searchContratByIdEtudiantSQL(Long idEtudiant){
        return (List<Contrat>) icontratrepo.searchContratByIdEtudiantSQL(idEtudiant);
    }



   @Override
   public List<Contrat> searchContratByArchiveAndDateDebutC(boolean archive, Date datedebutc){
        return (List<Contrat>)icontratrepo.getContratByArchiveAndDateDebutC(archive,datedebutc);
   }
   @Override
  public List<Contrat> searchContratByDateDebutCBetween(Date date1,Date date2){
        return (List<Contrat>)icontratrepo.getContratByDateDebutCBetween(date1,date2);
   }
    @Override
    public Contrat affectContratToEtudiant (Contrat ce, String nom,String prenomE ) {
        Etudiant etudiantAffecte = ietudiantrepo.getEtudiantByPrenomEtNomJPQL(nom, prenomE);
        if (etudiantAffecte.getContrats().size() < 5)
              { etudiantAffecte.getContrats().add(ce);
               ietudiantrepo.save(etudiantAffecte);}
           return ce;


    }

    @Override
    public String retrieveAndUpdateStatusContrat() {
         String msgForAdmin="";
         int nbrJours=0;
        List<Contrat> contratsVerifies= icontratrepo.getByArchive(false);
        for(Contrat c:contratsVerifies){
           nbrJours+= calculDiff(c.getDateFinC() ,new Date())+1;
           if(nbrJours==0){
               c.setArchive(true);
               icontratrepo.save(c);
               log.warn("Le contrat"+c.getIdContrat()+"de l'étudiant"+c.getStudents().getNomE()+
                       c.getStudents().getPrenomE()+"est expiré");}
           else if (nbrJours==15){
               msgForAdmin+="le contrat"+c.getIdContrat()+"sera expiré dans 15 jours";}
        }
          return msgForAdmin;
    }

    public long calculDiff(Date date1, Date date2) {
        long diffInMillies = date1.getTime() - date2.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
