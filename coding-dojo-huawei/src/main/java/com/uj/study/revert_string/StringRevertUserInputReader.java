package com.uj.study.revert_string;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/1/27 下午1:52
 * @description：
 */
public class StringRevertUserInputReader extends UserInputReader {
    private static final Pattern LOWER_CASE_PATTERN = Pattern.compile("^\\p{Lower}*$");

    public StringRevertUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readLowercaseCharacters() {
        String line = lineReader.readLine();
        while (!isValidInput(line)) {
            System.out.println("Please input lowercase characters");
            line = lineReader.readLine();
        }
        return line;
    }

    private boolean isValidInput(String line) {
        return isLowercase(line) && isValidLength(line);
    }

    private boolean isValidLength(String line) {
        return line.length() <= 1000;
    }

    private boolean isLowercase(String line) {
        return LOWER_CASE_PATTERN.matcher(line).matches();
    }
}
