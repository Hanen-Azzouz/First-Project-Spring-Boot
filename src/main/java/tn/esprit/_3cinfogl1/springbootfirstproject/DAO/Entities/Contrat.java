package tn.esprit._3cinfogl1.springbootfirstproject.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor//constructeur par defaut
@AllArgsConstructor//constructeur paramétré
//@RequiredArgsConstructor//on a le droit a un seul constructeur personnalise
@Builder//pour un constructeur paramétré personnalisé à utiliser lors de l'instanciation
//@FieldDefaults(Level=AccessLevel.PRIVATE)
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long idContrat;
    @Temporal(TemporalType.DATE)
    @Column(name="DateDebutContrat")
    private Date dateDebutC;
    @Temporal(TemporalType.DATE)
    @Column(name="DateFinContrat")
    private Date dateFinC;
    @Enumerated(EnumType.STRING)//chaine de caracteres
     private Specialite specialite;
   boolean archive;
   @Column(name="MontantContrat")
      private float montantC;
    @Transient //("pour ne pas créer l'attribut dans la table dans bd")
    private  float salaire;

   @ManyToOne
    private Etudiant students;

}
