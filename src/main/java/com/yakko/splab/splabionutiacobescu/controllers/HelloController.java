package com.yakko.splab.splabionutiacobescu.controllers;

import com.yakko.splab.splabionutiacobescu.difexample.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public record HelloController(ClientComponent client1, ClientComponent client2) {

    @GetMapping("/")
    public String sayHello() {
        return "Hello, <br>Client 1: " + client1 + "<br>Client 2: " + client2;
    }
}