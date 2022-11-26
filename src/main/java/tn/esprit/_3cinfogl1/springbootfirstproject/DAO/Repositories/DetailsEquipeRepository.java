package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.DetailsEquipe;
@Repository
public interface DetailsEquipeRepository extends CrudRepository<DetailsEquipe,Long> {
}
