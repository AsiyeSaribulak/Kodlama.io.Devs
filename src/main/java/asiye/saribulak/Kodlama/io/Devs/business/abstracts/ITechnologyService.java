package asiye.saribulak.Kodlama.io.Devs.business.abstracts;

import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import asiye.saribulak.Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ITechnologyService {
    List<GetAllTechnologyResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
    void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
}
