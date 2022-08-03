package com.uj.study.string_combine_handle;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/7/26 下午12:41
 * @description：
 */
public class StringCombineHandleReader extends ValidLineReader {
    public static final Pattern VALID_PATTERN = Pattern.compile("\\p{ASCII}+\\p{Space}\\p{ASCII}+");
    public StringCombineHandleReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readLine() {
        return readValidLine("Please input like this:str1 str2").trim();

    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() <= 100 && VALID_PATTERN.matcher(line).matches();
    }
}
