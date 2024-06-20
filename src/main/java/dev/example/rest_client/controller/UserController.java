package dev.example.rest_client.controller;

import dev.example.rest_client.services.httpclient.UserHttpClient;
import dev.example.rest_client.services.openfeign.JSONPlaceHolderClient;
import dev.example.rest_client.services.restclient.UserRestClient;
import dev.example.rest_client.services.resttemplate.UserTemplateClient;
import dev.example.rest_client.services.user.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserRestClient userRestClient;
    private final UserTemplateClient userTemplateClient;
    private final UserHttpClient userHttpClient;
    private final JSONPlaceHolderClient jsonPlaceHolderClient;


    @GetMapping("/rest")
    List<User> findAllRest(){
        log.info("findAll() Using UserRestClient to call rest endpoint");
        return userRestClient.findAll();
    }

    @GetMapping("/rest/{id}")
    User findByIdRest(@PathVariable Integer id){
        log.info("findById(id) Using UserRestClient to call rest endpoint");
        return userRestClient.findById(id);
    }

    @GetMapping("/template")
    List<User> findAllTemplate(){
        log.info("findAll() Using UserTemplateClient to call rest endpoint");
        return userTemplateClient.findAll();
    }

    @GetMapping("/template/{id}")
    User findByIdTemplate(@PathVariable Integer id){
        log.info("findById(id) Using UserTemplateClient to call rest endpoint");
        return userTemplateClient.findById(id);
    }

    @GetMapping("/http")
    List<User> findAllHttp(){
        log.info("findAll() Using UserHttpClient to call rest endpoint");
        return userHttpClient.findAll();
    }

    @GetMapping("/http/{id}")
    User findByIdHttp(@PathVariable Integer id){
        log.info("findById(id) Using UserHttpClient to call rest endpoint");
        return userHttpClient.findById(id);
    }

    @GetMapping("/feign")
    List<User> findAllFeign(){
        log.info("findAll() Using JSONPlaceHolderClient to call rest endpoint");
        return jsonPlaceHolderClient.findAll();
    }

    @GetMapping("/feign/{id}")
    User findByIdFeign(@PathVariable Integer id){
        log.info("findById(id) Using JSONPlaceHolderClient to call rest endpoint");
        return jsonPlaceHolderClient.findById(id);
    }
}
