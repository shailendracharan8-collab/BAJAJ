package com.shailendra.bfhl_api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BFHLController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @PostMapping("/bfhl")
    public Map<String, Object> bfhl(@RequestBody Map<String, List<String>> request) {

        List<String> data = request.get("data");

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;
        StringBuilder alphabetChars = new StringBuilder();

        for (String item : data) {

            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                sum += num;

                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());
                alphabetChars.append(item);

            } else {

                specialCharacters.add(item);
            }
        }

        String reversed =
                new StringBuilder(alphabetChars.toString())
                        .reverse()
                        .toString();

        StringBuilder concatString = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                concatString.append(Character.toUpperCase(ch));
            } else {
                concatString.append(Character.toLowerCase(ch));
            }
        }

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("is_success", true);
        response.put("user_id", "shailendra_charan_07102003");
        response.put("email", "shailendracharan8@gmail.com");
        response.put("roll_number", "0827CY231064");

        response.put("odd_numbers", oddNumbers);
        response.put("even_numbers", evenNumbers);
        response.put("alphabets", alphabets);
        response.put("special_characters", specialCharacters);

        response.put("sum", String.valueOf(sum));
        response.put("concat_string", concatString.toString());

        return response;
    }
}
