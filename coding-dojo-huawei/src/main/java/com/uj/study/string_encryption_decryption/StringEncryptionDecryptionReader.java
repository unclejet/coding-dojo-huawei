package com.uj.study.string_encryption_decryption;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/7/11 下午12:31
 * @description：
 */
public class StringEncryptionDecryptionReader extends ValidLineReader {
    public static final Pattern ALPHA_NUMBER_PATTERN = Pattern.compile("\\p{Alnum}+");

    public StringEncryptionDecryptionReader(LineReader lineReader) {
        super(lineReader);
    }

    public String[] read2Lines() {
        int size = 2;
        String[] lines = new String[size];
        for (int i = 0; i < size; i++)
            lines[i] = readValidLine("please input alphabetic character or number and 1<=string length<=1000");
        return lines;
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() >= 1 && line.length() <= 1000
                && ALPHA_NUMBER_PATTERN.matcher(line).matches();
    }
}
