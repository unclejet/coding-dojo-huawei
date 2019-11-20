package com.uj.study.mingming_random;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        int size = userInputReader.readArraySize();
        int[] array = userInputReader.createArray(size);
        MingMingRandom mingRandom = new MingMingRandom();
        int[] result = mingRandom.handle(array);
        Arrays.stream(result).forEach(System.out::println);
    }
}
