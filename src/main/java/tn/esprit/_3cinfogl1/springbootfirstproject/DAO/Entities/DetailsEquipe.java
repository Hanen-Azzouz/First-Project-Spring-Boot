package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor//constructeur par defaut
@AllArgsConstructor//constructeur paramétré
@Builder
public class DetailsEquipe  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailsEquipe;
    private int salle;
    private String thematique;
    @OneToOne(mappedBy = "detequipe")//association oneToOne(child)
    private Equipe equipe;
}
