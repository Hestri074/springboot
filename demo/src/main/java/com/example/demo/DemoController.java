package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // handle requests URL/Client
    @GetMapping("/cek_demo")
    public String cekDemo() {
        return "Hello World, This is my first Spring Boot Application";
    }
}
