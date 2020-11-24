package com.example.teste.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "/testeBanco")
public class HomeResource {


    @ApiOperation("")
    @GetMapping
    public String testServer() {
        return "Server UP";
    }

}
