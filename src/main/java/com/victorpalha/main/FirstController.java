package com.victorpalha.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class FirstController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}