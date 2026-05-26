package com.shailendra.bfhl_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
public class BfhlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BfhlApiApplication.class, args);
    }

    @PostMapping("/bfhl")
    public Map<String, Object> bfhl(@RequestBody Map<String, Object> request) {
        return Map.of(
                "is_success", true,
                "message", "POST API Working"
        );
    }
}