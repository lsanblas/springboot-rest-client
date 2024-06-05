package dev.example.rest_client.controller;

import dev.example.rest_client.services.httpclient.UserHttpClient;
import dev.example.rest_client.services.restclient.UserRestClient;
import dev.example.rest_client.services.resttemplate.UserTemplateClient;
import dev.example.rest_client.services.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserRestClient userRestClient;
    private final UserTemplateClient userTemplateClient;
    private final UserHttpClient userHttpClient;

    public UserController(UserRestClient userRestClient, UserTemplateClient userTemplateClient, UserHttpClient userHttpClient) {
        this.userRestClient = userRestClient;
        this.userTemplateClient = userTemplateClient;
        this.userHttpClient = userHttpClient;
    }
    @GetMapping("/rest")
    List<User> findAllRest(){
        log.info("Using UserRestClient to call rest endpoint");
        return userRestClient.findAll();
    }

    @GetMapping("/rest/{id}")
    User findByIdRest(@PathVariable Integer id){
        log.info("Using UserRestClient to call rest endpoint");
        return userRestClient.findById(id);
    }

    @GetMapping("/template")
    List<User> findAllTemplate(){
        log.info("Using UserTemplateClient to call rest endpoint");
        return userTemplateClient.findAll();
    }

    @GetMapping("/template/{id}")
    User findByIdTemplate(@PathVariable Integer id){
        log.info("Using UserTemplateClient to call rest endpoint");
        return userTemplateClient.findById(id);
    }

    @GetMapping("/http")
    List<User> findAllHttp(){
        log.info("Using UserHttpClient to call rest endpoint");
        return userHttpClient.findAll();
    }

    @GetMapping("/http/{id}")
    User findByIdHttp(@PathVariable Integer id){
        log.info("Using UserHttpClient to call rest endpoint");
        return userHttpClient.findById(id);
    }
}
