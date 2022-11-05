package asiye.saribulak.Kodlama.io.Devs.business.concrete;

import asiye.saribulak.Kodlama.io.Devs.business.abstracts.ITechnologyService;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import asiye.saribulak.Kodlama.io.Devs.dataAccess.abstracts.ILanguageRepository;
import asiye.saribulak.Kodlama.io.Devs.dataAccess.abstracts.ITechnologyRepository;
import asiye.saribulak.Kodlama.io.Devs.entities.concrete.Languages;
import asiye.saribulak.Kodlama.io.Devs.entities.concrete.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements ITechnologyService {
    private ITechnologyRepository technologyRepository;
    private ILanguageRepository languageRepository;

    public TechnologyManager(ITechnologyRepository technologyRepository,ILanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository=languageRepository;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technology=this.technologyRepository.findAll();
        List<GetAllTechnologyResponse> getAllTechnologyResponses=new ArrayList<GetAllTechnologyResponse>();
        for (Technology technology1:technology){
            GetAllTechnologyResponse technologyResponse=new GetAllTechnologyResponse();
            technologyResponse.setTechnologyName(technology1.getTecnologyName());
            technologyResponse.setLanguageName(technology1.getLanguage().getLanguageName());
            technologyResponse.setId(technology1.getId());
            technologyResponse.setLanguageId(technology1.getLanguage().getId());
            getAllTechnologyResponses.add(technologyResponse);
        }
        return getAllTechnologyResponses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        Technology technology=new Technology();
        Languages languages=this.languageRepository.findById(createTechnologyRequest.getLanguageId()).get();
        technology.setTecnologyName(createTechnologyRequest.getTechnologyName());
        technology.setLanguage(languages);

    if (createTechnologyRequest.getTechnologyName().isEmpty())throw new Exception("İsim alanı boş olamaz");
    for (GetAllTechnologyResponse technology1:getAll()){
        if (createTechnologyRequest.getTechnologyName().equals(technology1.getTechnologyName())){
            throw new Exception("Bu isim de framwork mevcut");
        }
    }
    this.technologyRepository.save(technology);
    }


    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        for (GetAllTechnologyResponse technology:getAll()){
            if (deleteTechnologyRequest.getId()== technology.getId()){
                this.technologyRepository.deleteById(technology.getId());
            }
            else {throw new Exception("Id bulunaması");}
        }
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        for (GetAllTechnologyResponse technology:getAll()){
            if (    updateTechnologyRequest.getId()== technology.getId()){

               this.technologyRepository.findById(updateTechnologyRequest.getId()).get();
            } else if (updateTechnologyRequest.getTechnologyName().equals(technology.getLanguageName())) {
                throw new Exception("sistemde böyle bir dil mevcut");
            }
            else if (updateTechnologyRequest.getTechnologyName().isEmpty()){
                throw new Exception("İsim alanı boş olamaz");
            }
            else {
                throw new Exception("Id bulunamadı");
            }
            Technology technology1=new Technology();
            Languages languages=this.languageRepository.findById(updateTechnologyRequest.getId()).get();
            technology1.setTecnologyName(updateTechnologyRequest.getTechnologyName());
            technology1.setLanguage(languages);
            this.technologyRepository.save(technology1);
        }
    }
}
