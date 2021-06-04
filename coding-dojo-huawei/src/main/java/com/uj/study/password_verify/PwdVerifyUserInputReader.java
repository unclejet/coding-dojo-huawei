package com.uj.study.password_verify;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/31 上午11:42
 * @description：
 */
public class PwdVerifyUserInputReader extends BaseUserInputReader {
    public PwdVerifyUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public List<String> readPwdList() {
        List<String> results = new ArrayList<>();
        String line = lineReader.readLine();
        while (!exit(line)) {
            results.add(line);
            line = lineReader.readLine();
        }
        return results;
    }
}
