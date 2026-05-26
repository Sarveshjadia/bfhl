package com.bfhl.util;

import java.util.List;

public class BfhlUtility {

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^-?\\d+$");
    }

    public static boolean isAlphabet(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^[a-zA-Z]+$");
    }

    public static String generateConcatString(List<String> alphabets) {
        if (alphabets == null || alphabets.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : alphabets) {
            sb.append(s);
        }
        String reversed = sb.reverse().toString();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}
