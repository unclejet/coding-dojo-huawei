package com.uj.study.two_prime_makeup_even_number;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/11/1 下午12:43
 * @description：
 */
public class TwoPrimeNearestOneEvenNumberReader extends ValidLineReader {
    public TwoPrimeNearestOneEvenNumberReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        if (isInteger(line)) {
            int n = getInteger(line);
            return n >= 4 && n <= 1000;
        }
        return false;
    }

    public int readEvenNumber() {
        String line = readValidLine("Please input even number between 4 and 1000:");
        return getInteger(line);
    }
}
