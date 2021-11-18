package com.uj.study.chorus;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/10 下午12:40
 * @description：
 */
public class ChorusUserInputReader extends UserInputReader {
    public static final Pattern HEIGHTS_PATTERN = Pattern.compile("[\\d\\s]+");

    public ChorusUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public int[] readHeights() {
        int num = readInteger();
        while (!isValidInteger(num)) {
            num = readInteger();
        }
        return inputHeights(num);
    }

    private int[] inputHeights(int num) {
        String line = lineReader.readLine();
        while (!isValidFormat(line, num)) {
            System.out.println(String.format("Please input %s integers separated by space: ", num));
            line = lineReader.readLine();
        }
        return Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
    }

    private boolean isValidInteger(int num) {
        return num >= 1 && num <= 3000;
    }

    private int readInteger() {
        String line = lineReader.readLine();
        while (!isInteger(line)) {
            System.out.println("Please input a integer: ");
            line = lineReader.readLine();
        }
        return Integer.parseInt(line);
    }

    public boolean isValidFormat(String inputs, int num) {
        return HEIGHTS_PATTERN.matcher(inputs).matches() &&
                inputs.split("\\s").length == num;
    }
}
