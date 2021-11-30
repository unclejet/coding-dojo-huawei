package com.uj.study.data.classify;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/16 下午12:40
 * @description：
 */
public class DataClassifyUserInputReader extends UserInputReader {
    public static final Pattern DATA_SEQUENCE_PATTERN = Pattern.compile("[\\d\\s]+");

    public DataClassifyUserInputReader(LineReader lineReader) {
        super(lineReader);

    }

    public String[] readSequence() {
        String line = lineReader.readLine();
        while (!isValidFormat(line)) {
            System.out.println("Please input integers separated by space:");
            line = lineReader.readLine();
        }
        String[] split = line.split("\\s");
        return Arrays.copyOfRange(split, 1, split.length);
    }

    private boolean isValidFormat(String line) {
        if (DATA_SEQUENCE_PATTERN.matcher(line).matches()) {
            String[] data = line.split("\\s");
            return data.length == Integer.parseInt(data[0]) + 1;
        }
        return false;
    }
}
