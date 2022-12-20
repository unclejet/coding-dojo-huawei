package com.uj.study.counterweight;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/14 下午12:21
 * @description：
 */
public class CounterWeightUserInputReader extends UserInputReader {
    public CounterWeightUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public int readTypeNumber() {
        String line = lineReader.readLine();
        while (!isValidNumber(line, 1, 10)) {
            System.out.println("please input a number between 1 and 10");
            line = lineReader.readLine();
        }
        return Integer.parseInt(line);
    }

    private boolean isValidNumber(String line, int start, int end) {
        if (isInteger(line)) {
            int tu = Integer.parseInt(line);
            return tu >= start && tu <= end;
        }
        return false;
    }

    public List<Integer> readWeight(int typeNumber) {
        return readFixedNumEntities(typeNumber, 1, 2000, "please input a number between 1 and 2000");
    }

    public List<Integer> readQuantities(int typeNumber) {
        return readFixedNumEntities(typeNumber, 1, 10, "please input a number between 1 and 10");
    }

    private List<Integer> readFixedNumEntities(int typeNumber, int start, int end, String prompt) {
        String line = lineReader.readLine();
        while (!isValidNumbers(line, typeNumber, start, end)) {
            System.out.println(prompt);
            line = lineReader.readLine();
        }
        return Arrays.stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private boolean isValidNumbers(String line, int typeNumber, int start, int end) {
        String[] nums = line.split("\\s+");
        if (nums.length == typeNumber) {
            return Arrays.stream(nums).allMatch(n -> isValidNumber(n, start, end));
        }
        return false;
    }
}
