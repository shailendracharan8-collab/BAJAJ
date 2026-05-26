package com.shailendra.bfhl_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BFHLController {

    @GetMapping("/bfhl")
    public String test() {
        return "BFHL API Working";
    }
}