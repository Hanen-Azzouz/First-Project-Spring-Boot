package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {

//select * from departement where nom_departement=(valeur passée en paramétre)



}
