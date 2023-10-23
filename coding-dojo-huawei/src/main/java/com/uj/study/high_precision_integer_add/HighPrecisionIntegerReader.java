package com.uj.study.high_precision_integer_add;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/23 下午12:41
 * @description：
 */
public class HighPrecisionIntegerReader extends ValidLineReader {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("\\p{Digit}+");

    public HighPrecisionIntegerReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() <= 10000 && NUMBER_PATTERN.matcher(line).matches();
    }

    public String readNumString() {
        return readValidLine("Please input number length <= 10000");
    }
}
