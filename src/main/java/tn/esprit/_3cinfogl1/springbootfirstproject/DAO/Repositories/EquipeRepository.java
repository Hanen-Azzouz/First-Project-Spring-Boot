package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Equipe;
import tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities.Specialite;

import java.util.List;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Long> {



    //Afficher la liste d'équipes avec une thématique passé en paramétre avec jpql
    //les noms de classes et attributs des objets utilisés
    @Query("select alias1 from Equipe alias1,DetailsEquipe alias2 where " +
            "alias1.detequipe.idDetailsEquipe=alias2.idDetailsEquipe and alias2.thematique=?1")

    List<Equipe> retrieveEquipesByThematiqueJPQL(String thematique);
    //Afficher la liste d'équipes avec une thématique passé en paramétre avec SQL

  // les noms des tables et attributs à prendre à partir de la BD
    @Query(value="select  alias1 from equipe alias1 join  details_equipe alias2 " +
            "on alias1.detequipe_id_details_equipe= alias2.id_details_equipe where  " +
            "alias2.thematique=?1",nativeQuery = true)
    List<Equipe> retrieveEquipesByThematiqueSQL(String thematique);


}
