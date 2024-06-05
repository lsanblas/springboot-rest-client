package dev.example.rest_client.services.restclient;

import dev.example.rest_client.services.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserRestClient {

    public static final String USER = "/users";
    public static final String USER_ID = "/users/{id}";

    @Value("${spring.rest.service.url}")
    private String baseUrl;

    private final RestClient restClient;

    public UserRestClient(RestClient.Builder buider){
        this.restClient = buider.baseUrl(baseUrl).build();
    }

    public List<User> findAll(){
        return restClient.get()
                .uri(baseUrl + USER)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    public User findById(Integer id){
        return restClient.get()
                .uri(baseUrl + USER_ID, id)
                .retrieve()
                .body(User.class);
    }
}
