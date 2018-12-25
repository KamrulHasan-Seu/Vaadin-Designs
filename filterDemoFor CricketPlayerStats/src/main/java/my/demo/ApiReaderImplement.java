package my.demo;

import my.demo.Models.Model;
import my.demo.Models.Player;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiReaderImplement implements ApiReaderDao {
    @Override
    public List<Model> getPlayer(String name) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Player> response = restTemplate.exchange(
                "https://cricapi.com/api/playerFinder?apikey=8roPV1IHd6glgHxIkFswOFQBCTC3&name=" + name,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Player>() {
                });
        Player player = response.getBody();
        return player.getData();
    }

    @Override
    public List<Model> getPlayerDetails(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Player> response = restTemplate.exchange(
                "https://cricapi.com/api/playerStats?apikey=8roPV1IHd6glgHxIkFswOFQBCTC3&pid=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Player>() {
                });
        Player player = response.getBody();
        return player.getData();
    }
}
