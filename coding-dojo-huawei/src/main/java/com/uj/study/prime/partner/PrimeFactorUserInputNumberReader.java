package com.uj.study.prime.partner;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/4/28 下午12:58
 * @description：
 */
public class PrimeFactorUserInputNumberReader extends ValidLineReader {
    public PrimeFactorUserInputNumberReader(LineReader lineReader) {
        super(lineReader);
    }

    public List<Integer> readNumbers(int numCount) {
        List<Integer> result = getIntegers();
        while (!isValidInteger(result, numCount)) {
            System.out.println("please input" + numCount + " integers like this: 2 5 6 13");
            result = getIntegers();
        }
        return result;
    }

    private boolean isValidInteger(List<Integer> result, int numCount) {
        return result != null &&
                result.size() == numCount &&
                result.stream().filter(i->i<2||i>30000).findAny().isEmpty();
    }

    private List<Integer> getIntegers() {
        String line = lineReader.readLine();
        try {
            return Stream.of(line.split("\\s+")).mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    @Override
    protected boolean isValidString(String line) {
        if (super.isInteger(line)) {
            int num = Integer.parseInt(line);
            return num % 2 == 0 && num <= 100 && num >= 1;
        }
        return false;
    }

    public int readEvenTotalNumber() {
        return Integer.parseInt(super.readValidLine("Please input:'1<=even number<=100' like 2: "));
    }
}
