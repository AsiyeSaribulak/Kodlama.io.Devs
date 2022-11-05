package asiye.saribulak.Kodlama.io.Devs.business.requests.languages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguagesRequest {
    private int id;
    private String languageName;
}
