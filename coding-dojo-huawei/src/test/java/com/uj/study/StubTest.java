package com.uj.study;


class StubTest {
    public static void main(String[] args) {
        String REGEX = "[a-zA-Z0-9\\s]{1}+";
        String input = " ";
        if (input.matches(REGEX))
            System.out.println("matched");
        else
            System.out.println("unmatched");
    }
}