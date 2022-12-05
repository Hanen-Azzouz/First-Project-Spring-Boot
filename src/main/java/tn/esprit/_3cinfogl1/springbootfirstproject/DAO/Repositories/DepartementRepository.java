package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Departement;

import java.util.List;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Long> {


//select * from departement where nom_departement=(valeur passée en paramétre)
  List<Departement> getDepartementByNomDepartement(String nomDepartement);
}
