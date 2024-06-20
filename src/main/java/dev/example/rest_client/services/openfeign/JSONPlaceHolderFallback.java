package dev.example.rest_client.services.openfeign;

import dev.example.rest_client.services.user.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JSONPlaceHolderFallback implements JSONPlaceHolderClient {

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}
