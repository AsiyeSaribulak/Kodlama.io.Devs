package asiye.saribulak.Kodlama.io.Devs.webApi.concrete;

import asiye.saribulak.Kodlama.io.Devs.business.abstracts.ILanguageService;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.CreateLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.DeleteLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.languages.UpdateLanguagesRequest;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    private ILanguageService languageService;

    public LanguageController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguagesResponse> getAll(){

        return languageService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdLanguagesResponse getById(@PathVariable(value = "id") int id)throws Exception{
        return languageService.getById(id);
    }

    @PostMapping("/add")
    public void  add(@RequestBody CreateLanguagesRequest createLanguagesRequest) throws Exception{
      this.languageService.add(createLanguagesRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(DeleteLanguagesRequest deleteLanguagesRequest) throws Exception{
        this.languageService.delete(deleteLanguagesRequest);
    }

    @PutMapping("/update/{id}")
    public void update(UpdateLanguagesRequest updateLanguagesRequest) throws Exception{
        this.languageService.update(updateLanguagesRequest);
    }
}
