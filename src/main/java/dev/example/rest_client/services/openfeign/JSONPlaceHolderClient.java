package dev.example.rest_client.services.openfeign;

import dev.example.rest_client.services.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/", configuration = OpenFeignConfiguration.class, fallback = JSONPlaceHolderFallback.class)
public interface JSONPlaceHolderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<User> findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}", produces = "application/json")
    User findById(@PathVariable("id") Integer id);
}
