package com.uj.study.sort_string_lines;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/5 下午1:45
 * @description：
 */
public class SortStringLineUserInputReader extends UserInputReader {
    private static final Pattern ALPHA_PATTERN = Pattern.compile("^\\p{Alpha}*$");

    private int count;

    public SortStringLineUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public List<String> readMultiLines() {
        count = 0;
        int number = readFirstLine();
        List<String> result = new ArrayList<>(number);
        while (hasNextLine(number))
            result.add(getLine());
        return result;
    }

    private String getLine() {
        String line = lineReader.readLine();
        while (!isValidString(line)) {
            System.out.println("Please input alpha string and length <= 100 : ");
            line = lineReader.readLine();
        }
        return line;
    }

    private boolean hasNextLine(int number) {
        return count++ < number;
    }

    private boolean isValidString(String line) {
        return isAlpha(line);
    }

    private boolean isAlpha(String line) {
        return ALPHA_PATTERN.matcher(line).matches();
    }

    public int readFirstLine() {
        String line = lineReader.readLine();
        while (!isValid(line)) {
            System.out.println("please input a integer between 1 and 1000:");
            line = lineReader.readLine();
        }
        return Integer.parseInt(line);
    }

    private boolean isValid(String line) {
        return isInteger(line) && isWithinRange(line);
    }

    private boolean isWithinRange(String line) {
        int i = Integer.parseInt(line);
        return i >= 1 && i <= 1000;
    }
}
