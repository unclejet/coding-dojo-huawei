package com.uj.study;


import com.uj.study.common.utils.RandomAlphabetGenerator;

class StubTest {
    public static void main(String[] args) {
        RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(100);
    }

    private static void regex() {
        String REGEX = "[a-zA-Z0-9\\s]{1}+";
        String input = " ";
        if (input.matches(REGEX))
            System.out.println("matched");
        else
            System.out.println("unmatched");
    }
}