package com.uj.study.coordinate;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/3/26 上午11:43
 * @description：
 */
public class CoordinateUserInputReader extends UserInputReader {
    public static final Pattern COORDINATE_PATTERN = Pattern.compile("[ADWS]\\p{Digit}{1,2}+");

    public CoordinateUserInputReader(LineReader lineReader) {
        super(lineReader);
    }


    public List<String> readValidCoordinates() {
        String line = lineReader.readLine();
        return Arrays.stream(line.split(";"))
                .filter(v -> COORDINATE_PATTERN.matcher(v).matches())
                .collect(Collectors.toList());
    }
}
