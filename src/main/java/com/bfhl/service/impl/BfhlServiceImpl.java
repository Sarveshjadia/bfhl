package com.bfhl.service.impl;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import com.bfhl.service.BfhlService;
import com.bfhl.util.BfhlUtility;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String USER_ID = "sarvesh_jadia_07042005";
    private static final String EMAIL = "sarveshjadia230885@acropolis.in";
    private static final String ROLL_NUMBER = "0827CS231240";

    @Override
    public BfhlResponse processRequest(BfhlRequest request) {
        BfhlResponse response = new BfhlResponse();
        response.setUserId(USER_ID);
        response.setEmail(EMAIL);
        response.setRollNumber(ROLL_NUMBER);

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        BigInteger sum = BigInteger.ZERO;

        if (request != null && request.getData() != null) {
            for (String item : request.getData()) {
                if (item == null) {
                    continue;
                }
                item = item.trim();
                if (BfhlUtility.isNumeric(item)) {
                    BigInteger val = new BigInteger(item);
                    if (val.abs().mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                    sum = sum.add(val);
                } else if (BfhlUtility.isAlphabet(item)) {
                    alphabets.add(item.toUpperCase());
                } else {
                    specialCharacters.add(item);
                }
            }
        }

        response.setOddNumbers(oddNumbers);
        response.setEvenNumbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecialCharacters(specialCharacters);
        response.setSepcialCharacters(specialCharacters); // set the duplicate typo key for compliance
        response.setSum(sum.toString());
        response.setConcatString(BfhlUtility.generateConcatString(alphabets));
        response.setSuccess(true);

        return response;
    }
}
