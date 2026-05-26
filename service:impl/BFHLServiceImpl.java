package com.shailendra.bfhl.service.impl;

import com.shailendra.bfhl.dto.RequestDTO;
import com.shailendra.bfhl.dto.ResponseDTO;
import com.shailendra.bfhl.service.BFHLService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BFHLServiceImpl implements BFHLService {

    @Override
    public ResponseDTO processData(RequestDTO request) {

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;

        StringBuilder alphaChars = new StringBuilder();

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                sum += num;

                if (num % 2 == 0)
                    evenNumbers.add(item);
                else
                    oddNumbers.add(item);

            }

            else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                alphaChars.append(item);

            }

            else {

                specialCharacters.add(item);

            }
        }

        String concatString =
                reverseAlternateCaps(alphaChars.toString());

        return ResponseDTO.builder()
                .is_success(true)
                .user_id("shailendra_charan_26052026")
                .email("your_email@gmail.com")
                .roll_number("0827CY221164")
                .odd_numbers(oddNumbers)
                .even_numbers(evenNumbers)
                .alphabets(alphabets)
                .special_characters(specialCharacters)
                .sum(String.valueOf(sum))
                .concat_string(concatString)
                .build();
    }

    private String reverseAlternateCaps(String str) {

        String reversed =
                new StringBuilder(str).reverse().toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            if (i % 2 == 0)
                result.append(
                        Character.toUpperCase(
                                reversed.charAt(i)
                        )
                );
            else
                result.append(
                        Character.toLowerCase(
                                reversed.charAt(i)
                        )
                );
        }

        return result.toString();
    }
}