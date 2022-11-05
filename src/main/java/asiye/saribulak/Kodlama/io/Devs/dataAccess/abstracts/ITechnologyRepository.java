package asiye.saribulak.Kodlama.io.Devs.dataAccess.abstracts;

import asiye.saribulak.Kodlama.io.Devs.entities.concrete.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<Technology,Integer> {

}
