package com.uj.study.max_serial_bit_count;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;
import com.uj.study.common.input.ValidLineReader;

public class MaxSerialBitCounterReader extends ValidLineReader {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 5 * 100000; // 5×10^5

    public MaxSerialBitCounterReader(LineReader lineReader) {
        super(lineReader);
    }


    public int readInput() {
        while (true) {
            String input = lineReader.readLine();
            if (isValidString(input)) {
                return Integer.parseInt(input.trim());
            }
        }
    }

    @Override
    public boolean isValidString(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        try {
            int number = Integer.parseInt(input.trim());
            return number >= MIN_VALUE && number <= MAX_VALUE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
