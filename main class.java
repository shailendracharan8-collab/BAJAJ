package com.shailendra.bfhl_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BfhlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BfhlApiApplication.class, args);
    }

    @GetMapping("/bfhl")
    public String test() {
        return "Working";
    }
}