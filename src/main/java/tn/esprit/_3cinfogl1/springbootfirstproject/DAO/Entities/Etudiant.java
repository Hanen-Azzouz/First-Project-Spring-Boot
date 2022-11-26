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

public class Etudiant implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Domaine domaine;

    @ManyToOne
    private  Departement depart;

    @ManyToMany(mappedBy = "etudiants")
    private List<Equipe>equipes;

    @OneToMany(mappedBy = "students")
    private List<Contrat> contrats;
}
