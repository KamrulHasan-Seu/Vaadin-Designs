package filter.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OnlineAPIReaderDaoImpl implements Online_API_ReaderDao {

    @Override
    public List<Player> getPlayer (String name) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Model> response = restTemplate.exchange(
                "https://cricapi.com/api/playerFinder?apikey=8roPV1IHd6glgHxIkFswOFQBCTC3&name=" + name,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Model>(){});
        Model model = response.getBody();
        return model.getData();
    }

    @Override
    public List<Player> getAllPlayer() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Model> response = restTemplate.exchange(
                "https://cricapi.com/api/playerFinder?apikey=8roPV1IHd6glgHxIkFswOFQBCTC3" ,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Model>(){});
        Model model = response.getBody();
        return model.getData();
    }
}
