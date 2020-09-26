package com.uj.study.count_char_numbers;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;

import java.util.regex.Pattern;

/**
 * @author ：unclejet
 * @date ：Created in 2020/9/26 上午7:43
 * @description：
 * @modified By：
 * @version:
 */
public class UserInputReader extends BaseUserInputReader {
    private static final Pattern ASCII_PATTERN = Pattern.compile("^\\p{ASCII}*$");

    public UserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readAscII() {
        String line = lineReader.readLine();
        while (!ASCII_PATTERN.matcher(line).matches()) {
            System.out.println("Please input ASCII characters");
            line = lineReader.readLine();
        }
        return line;
    }
}
