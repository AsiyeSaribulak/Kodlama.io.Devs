package asiye.saribulak.Kodlama.io.Devs.entities.concrete;

import asiye.saribulak.Kodlama.io.Devs.entities.abstracts.IEntity;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "languages")
@Entity
public class Languages implements IEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "languageName")
    private String languageName;

    @OneToMany(mappedBy = "language",targetEntity = Technology.class)
    private List<Technology> technologies;
}
