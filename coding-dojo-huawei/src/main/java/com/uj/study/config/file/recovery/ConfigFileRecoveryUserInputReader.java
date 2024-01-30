package com.uj.study.config.file.recovery;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/29 下午12:42
 * @description：
 */
public class ConfigFileRecoveryUserInputReader extends ValidLineReader {
    public ConfigFileRecoveryUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() <= 20;
    }

    public List<String> readCommands() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            String line = readValidLine("please input string more than 1 and less than 20 characters:");
            if (line.isEmpty())
                break;
            result.add(line);
        }
        return result;
    }
}
