package com.uj.study.picture_arrange;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/21 下午12:14
 * @description：
 */
public class PictureUserInputReader extends ValidLineReader {
    private static final Pattern ALNUM_PATTERN = Pattern.compile("^\\p{Alnum}*$");
    public PictureUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readPictures() {
        return readValidLine("Please input valid pictures \"A\"到\"Z\"、\"a\"到\"z\"、\"0\"到\"9\"");
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() > 0 && line.length() <= 1000
                && ALNUM_PATTERN.matcher(line).matches();
    }
}
