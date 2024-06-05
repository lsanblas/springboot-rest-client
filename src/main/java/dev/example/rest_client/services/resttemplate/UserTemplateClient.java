package dev.example.rest_client.services.resttemplate;

import dev.example.rest_client.services.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserTemplateClient {

    public static final String USER = "/users";
    public static final String USER_ID = "/users/{id}";

    @Value("${spring.rest.service.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public UserTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> findAll(){
        User[] users = this.restTemplate.getForObject(baseUrl + USER, User[].class);
        return users != null ? Arrays.stream(users).toList() : new ArrayList<>();
    }

    public User findById(Integer id){
        return this.restTemplate.getForObject(baseUrl + USER_ID, User.class, id);
    }
}
