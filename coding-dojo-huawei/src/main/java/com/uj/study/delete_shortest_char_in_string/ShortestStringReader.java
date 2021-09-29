package com.uj.study.delete_shortest_char_in_string;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/17 下午12:25
 * @description：
 */
public class ShortestStringReader extends BaseUserInputReader {
    public ShortestStringReader(LineReader lineReader) {
        super(lineReader);
    }


    public List<String> readStrings() {
        List<String> result = new ArrayList<>();
        String line = lineReader.readLine();
        while (!line.equals("q")) {
            if (isValid(line))
            result.add(line.toLowerCase());
            line = lineReader.readLine();
        }
        return result;
    }

    private boolean isValid(String line) {
        return line.length() <= 20;
    }

}
