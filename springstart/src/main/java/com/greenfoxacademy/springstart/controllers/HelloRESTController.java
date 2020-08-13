package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloRESTController {

    AtomicInteger atomicInt = new AtomicInteger();

    @GetMapping("/greeting")
    public Greeting greeting (@RequestParam String name) {
        Greeting greeting = new Greeting(atomicInt.incrementAndGet(), "Hello, " + name + "!");
        return greeting;
    }
}
