package asiye.saribulak.Kodlama.io.Devs.business.concrete;

import asiye.saribulak.Kodlama.io.Devs.business.abstracts.ILanguageService;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.CreateLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.DeleteLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.UpdateLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;
import asiye.saribulak.Kodlama.io.Devs.dataAccess.abstracts.ILanguageRepository;
import asiye.saribulak.Kodlama.io.Devs.entities.concrete.Languages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements ILanguageService {
    private ILanguageRepository languageRepository;

    public LanguageManager(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Languages> languages=this.languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponses=new ArrayList<GetAllLanguagesResponse>();

        for ( Languages languages1: languages){
            GetAllLanguagesResponse getAllLanguagesResponse=new GetAllLanguagesResponse();
            getAllLanguagesResponse.setId(languages1.getId());
            getAllLanguagesResponse.setLanguageName(languages1.getLanguageName());
            languagesResponses.add(getAllLanguagesResponse);
        }
        return languagesResponses;
    }

    @Override
    public GetByIdLanguagesResponse getById(int id) throws Exception {
        GetByIdLanguagesResponse getByIdLanguagesResponse = null;
        for (GetAllLanguagesResponse languagesResponse : getAll()) {
            if (languagesResponse.getId() == id) {
                Languages languages = this.languageRepository.findById(id).get();
                getByIdLanguagesResponse = new GetByIdLanguagesResponse();
                getByIdLanguagesResponse.setLanguageName(languages.getLanguageName());
            } else
                throw new Exception("id bulunamadı");
        }
        return getByIdLanguagesResponse;
    }

    @Override
    public void add(CreateLanguagesRequest createLanguagesRequest) throws Exception {
        for (GetAllLanguagesResponse languages:getAll()){
            if (createLanguagesRequest.getLanguageName().equals(languages.getLanguageName()))
                throw new Exception("sistemde böyle bir dil mevcut");
        }
        if (createLanguagesRequest.getLanguageName().isEmpty()){
            throw new Exception("İsim alanı boş olamaz");
        }
       Languages languages=new Languages();
       languages.setLanguageName(createLanguagesRequest.getLanguageName());
     this.languageRepository.save(languages);

    }

    @Override
    public void delete(DeleteLanguagesRequest deleteLanguagesRequest) throws Exception {
        for (GetAllLanguagesResponse languages:getAll()){
            if (languages.getId()== deleteLanguagesRequest.getId()){
                this.languageRepository.deleteById(deleteLanguagesRequest.getId());
            }else{
                throw new Exception("Id bulunamadı");
            }
        }
    }

    @Override
    public void update(UpdateLanguagesRequest updateLanguagesRequest) throws Exception{
        for (GetAllLanguagesResponse languages:getAll()){
            if (languages.getId()== updateLanguagesRequest.getId()){
               this.languageRepository.findById(updateLanguagesRequest.getId()).get();
            } else if (updateLanguagesRequest.getLanguageName().equals(languages.getLanguageName())) {
                throw new Exception("sistemde böyle bir dil mevcut");
            }
            else if (updateLanguagesRequest.getLanguageName().isEmpty()){
                throw new Exception("İsim alanı boş olamaz");
            }
            else {
                throw new Exception("Id bulunamadı");
            }
        }
        Languages languages=new Languages();
        languages.setLanguageName(updateLanguagesRequest.getLanguageName());
        this.languageRepository.save(languages);
    }
}
