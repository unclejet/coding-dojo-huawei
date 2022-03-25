package com.uj.study.brother_word;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/3/4 上午11:39
 * @description：
 */
public class BrotherWordUserInputReader extends UserInputReader {
    public BrotherWordUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public InputData readLine() {
        String line = lineReader.readLine();
        while (!isValidFormat(line)) {
            System.out.println("Please input like this: '3 abc bca cab abc 1', string length <=10, 1<=first number<=1000 , 1<=last number<=first number.");
            line = lineReader.readLine();
        }
        InputData data = formatInputData(line);
        return data;
    }

    private boolean isValidFormat(String line) {
        String[] arr = line.split("\\s");
        return isValidFirstNumber(arr[0]) &&
                isValidWordList(arr) &&
                isValidLastNumber(arr[arr.length - 1], arr[0]);
    }

    private boolean isValidLastNumber(String lastNumStr, String firstNumStr) {
        try {
            int lastNum = Integer.parseInt(lastNumStr);
            int firstNum = Integer.parseInt(firstNumStr);
            return lastNum <= firstNum && lastNum >= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidWordList(String[] arr) {
        return arr.length == (Integer.parseInt(arr[0]) + 3) && Arrays.asList(arr).subList(1, arr.length - 1).stream().allMatch(s -> s.length() <= 10);
    }

    private boolean isValidFirstNumber(String inputStr) {
        try {
            int i = Integer.parseInt(inputStr);
            return i <= 1000 && i >= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private InputData formatInputData(String input) {
        String[] arr = input.split("\\s");
        int wordCount = Integer.parseInt(arr[0]);
        List<String> words = Arrays.asList(arr).subList(1, wordCount + 1);
        String word = arr[arr.length - 2];
        int idx = Integer.parseInt(arr[arr.length - 1]);
        return new InputData(wordCount, words, word, idx);
    }
}
