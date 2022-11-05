package asiye.saribulak.Kodlama.io.Devs.webApi.concrete;

import asiye.saribulak.Kodlama.io.Devs.business.abstracts.ITechnologyService;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private ITechnologyService technologyService;

    @Autowired
    public TechnologyController(ITechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }
    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
        this.technologyService.add(createTechnologyRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception{
        this.technologyService.delete(deleteTechnologyRequest);
    }
    @PutMapping("/update")
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        this.technologyService.update(updateTechnologyRequest);
    }
}
