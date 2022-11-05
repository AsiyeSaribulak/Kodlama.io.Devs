package asiye.saribulak.Kodlama.io.Devs.dataAccess.abstracts;

import asiye.saribulak.Kodlama.io.Devs.entities.concrete.Languages;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ILanguageRepository extends JpaRepository<Languages,Integer> {

}
