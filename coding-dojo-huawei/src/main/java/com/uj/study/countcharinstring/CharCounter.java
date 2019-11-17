package com.uj.study.countcharinstring;

public final class CharCounter {
    public static long count(String firstLine, String secondLine) {
        return firstLine.chars().filter(c->c == secondLine.charAt(0)).count();
    }
}
