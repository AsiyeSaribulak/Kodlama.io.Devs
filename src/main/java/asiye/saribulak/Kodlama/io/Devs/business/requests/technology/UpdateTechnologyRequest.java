package asiye.saribulak.Kodlama.io.Devs.business.requests.technology;

import asiye.saribulak.Kodlama.io.Devs.entities.concrete.Languages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {
    private int id;
    private String technologyName;
    private int languageId;
}
