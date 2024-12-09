package com.victorpalha.controllers;

import com.victorpalha.entities.User;
import com.victorpalha.services.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api")
@RestController
public class FirstController {

    final
    FirstService firstService;

    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/")
    public String index() {
        return firstService.sayHello();
    }

    @GetMapping("/users/{id}")
    public String user(@PathVariable String id) {
        int idInt = Integer.parseInt(id);
        return "User with id " + idInt + " found";
    }

    @GetMapping("/products")
    public String products(@RequestParam String id) {
        List<String> products = new ArrayList<>();
        products.add("1");
        products.add("2");
        products.add("3");

        final boolean productExists = products.contains(id);
        if (productExists) {
            for (String product : products) {
                if (product.equals(id)) {
                    return product;
                }
            }
        }
        return "Product not found";
    }

    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> params) {
        final Set<Map.Entry<String, String>> queries = params.entrySet();
        System.out.println(queries);
        return "Your Query is " + queries;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody String username) {
        User user = new User(1, username, "Something");

        return "Hello There, " + user.name;
    }

    @PatchMapping("/user/{id}")
    public String updateUser(@PathVariable String id, @RequestBody String username, @RequestHeader("Authorization") String token) {
        final int idInt = Integer.parseInt(id);
        User user = new User(idInt, username, "Hello there");
        System.out.println("User Id "+ user.getId());
        System.out.println("User name "+ user.name);
        System.out.println("Token "+token);
        return "Your user profile is updated";
    }

    @PutMapping("/headers")
    public String updateHeaders(@RequestHeader Map<String, String> headers) {
        final Set<Map.Entry<String, String>> keys = headers.entrySet();
        return keys.toString();
    }

    @GetMapping("/users")
    public ResponseEntity<List<String>> users() {
        final User user = new User(1, "One", "Something");
        final User user2 = new User(2, "Two", "Something");
        final User user3 = new User(3, "Three", "Something");
        final User user4 = new User(4, "Four", "Something");
        final User user5 = new User(5, "Five", "Something");

        final List<String> users = new ArrayList<>();
        users.add(user.name);
        users.add(user2.name);
        users.add(user3.name);
        users.add(user4.name);
        users.add(user5.name);

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
