package com.example.teste.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testeBanco")
public class HomeResource {


    @GetMapping
    public String testServer() {
        return "Server UP";
    }

}
