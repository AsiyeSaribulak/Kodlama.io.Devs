package asiye.saribulak.Kodlama.io.Devs.business.abstracts;

import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.CreateLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.DeleteLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.UpdateLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;

import java.util.List;

public interface ILanguageService {
    List<GetAllLanguagesResponse> getAll();
    GetByIdLanguagesResponse getById(int id) throws Exception;
    void add(CreateLanguagesRequest createLanguagesRequest) throws Exception;
    void delete(DeleteLanguagesRequest deleteLanguagesRequest) throws Exception;
    void update(UpdateLanguagesRequest updateLanguagesRequest) throws Exception;
}
