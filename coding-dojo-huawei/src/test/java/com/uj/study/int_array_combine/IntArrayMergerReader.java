package com.uj.study.int_array_combine;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.Arrays;

public class IntArrayMergerReader extends UserInputReader {
    public IntArrayMergerReader(LineReader lineReader) {
        super(lineReader);
    }

    public int readPositiveNumber() {
        String line;
        while (true) {
            line = lineReader.readLine();
            try {
                int number = Integer.parseInt(line);
                if (number > 0) {
                    return number;
                }
            } catch (NumberFormatException e) {
                // Continue reading next line
            }
        }
    }

    public int[] readIntArray(int n, String s) {
        String[] strArray = s.trim().split("\\s+");
        int[] result = new int[n];
        Arrays.setAll(result, i -> Integer.parseInt(strArray[i]));
        return result;
    }
}
