package com.uj.study.soda_bottle;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/7/19 下午12:21
 * @description：
 */
public class SodaBottleUserInputReader extends UserInputReader {
    public static final Pattern POSITIVE_NUMBER = Pattern.compile("\\d+");

    public SodaBottleUserInputReader(LineReader lineReader) {
        super(lineReader);
    }


    public List<Integer> read() {
        List<Integer> result = new ArrayList<>();
        String line = lineReader.readLine();
        while (!line.equals("0")) {
            if (isValidNumber(line))
                result.add(Integer.parseInt(line));
            line = lineReader.readLine();
        }
        return result.stream().limit(10).collect(Collectors.toList());
    }

    private boolean isValidNumber(String line) {
        return POSITIVE_NUMBER.matcher(line).matches() && Integer.parseInt(line) <= 100;
    }
}
