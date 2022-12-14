package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor//constructeur par defaut
@AllArgsConstructor//constructeur paramétré
@Builder
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Departement> departement;

}
