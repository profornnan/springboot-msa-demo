package msa.support.clients;

import msa.support.domain.User;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    public User getUser(String userId) {
        RestTemplate restTemplate = new RestTemplate();

        String serviceUri = String.format("http://localhost:8002/api/user/%s", userId);

        ResponseEntity<User> restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, User.class, userId);

        return restExchange.getBody();
    }
}
