package asiye.saribulak.Kodlama.io.Devs.business.responses;

import asiye.saribulak.Kodlama.io.Devs.entities.concrete.Languages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologyResponse {
    private int id;
    private int languageId;
    private String technologyName;
    private String languageName;

}
