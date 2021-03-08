package com.uj.study.revert_sentence;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/2 上午11:53
 * @description：
 */
public class SentenceReverseInputReader extends UserInputReader {
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("(?=.*\\S)[a-zA-Z\\s]*");

    public SentenceReverseInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readAlpha() {
        String line = lineReader.readLine();
        while (!isValidInput(line)) {
            System.out.println("Please input english characters");
            line = lineReader.readLine();
        }
        return line;
    }

    private boolean isValidInput(String line) {
        return SENTENCE_PATTERN.matcher(line).matches();
    }
}
