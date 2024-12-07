package com.victorpalha.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class FirstController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/users/{id}")
    public String user(@PathVariable String id) {
        int idInt = Integer.parseInt(id);
        return "User with id " + idInt + " found";
    }

    @GetMapping("/products")
    public String products(@RequestParam String id) {
        List<String> products = new ArrayList<String>();
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
}
