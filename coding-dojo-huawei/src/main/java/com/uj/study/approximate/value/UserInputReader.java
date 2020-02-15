package com.uj.study.approximate.value;

import com.uj.study.common.input.LineReader;

import java.util.regex.Pattern;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/15 11:35
 * @description：
 * @modified By：
 * @version:
 */
public class UserInputReader {
    public static final Pattern POSITIVE_FLOAT_NUMBER_PATTERN = Pattern.compile("^\\d*[.]\\d+$");
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public float readAFloatNumber() {
        String line = lineReader.readLine();
        while (!POSITIVE_FLOAT_NUMBER_PATTERN.matcher(line).matches()) {
            System.out.println("please input a positive float number:");
            line = lineReader.readLine();
        }
        return Float.parseFloat(line);
    }

}
