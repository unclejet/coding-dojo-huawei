package com.uj.study.first_only_once_char;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/27 下午12:49
 * @description：
 */
public class FirstOnlyOnceCharacterReader extends ValidLineReader {
    private static final Pattern SPACE_PATTERN = Pattern.compile("^\\p{Space}+$");
    public FirstOnlyOnceCharacterReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        return (line.length() >= 1 && line.length() <= 1000) &&
                !SPACE_PATTERN.matcher(line).matches();
    }

    public String readString() {
        String line = readValidLine("Please input string length between 1 and 1000");
        return line;
    }
}
