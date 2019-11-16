package com.uj.study.lastwordlength;

public class LastWordLength {
    public int calculateLastWordLength(String input) {
        if(input.isBlank() || input.length() > 5000)
            throw new IllegalArgumentException("invalid input");
        String[] sarr = input.split("\\s+");
        return sarr[sarr.length - 1].length();
    }
}
