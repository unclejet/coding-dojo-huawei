package com.uj.study.string_encrypt;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/8 下午12:11
 * @description：
 */
public class StringEncryptUserInputReader extends ValidLineReader {
    private String[] inputs = new String[2];
    public StringEncryptUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public void readKeyAndEncryptString() {
        inputs[0] = readValidLine("Please input valid key only include lowercase:");
        inputs[1] = lineReader.readLine();
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() <= 100 && line.length() >= 1 &&
                line.matches("\\p{Lower}+");
    }

    public String getKey() {
        return inputs[0];
    }

    public String getEncryptString() {
        return inputs[1];
    }
}
