package asiye.saribulak.Kodlama.io.Devs.entities.concrete;

import asiye.saribulak.Kodlama.io.Devs.entities.abstracts.IEntity;
import lombok.*;
import javax.persistence.*;

@javax.persistence.Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "technologies")
public class Technology implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tecnologyName")
    private String tecnologyName;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Languages language;
}
