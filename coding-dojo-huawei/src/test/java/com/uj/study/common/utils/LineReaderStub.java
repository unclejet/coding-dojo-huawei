package com.uj.study.common.utils;

import com.uj.study.common.input.LineReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineReaderStub  implements LineReader {
    public List<String> userInputs = new ArrayList<>();
    private int readOffset = 0;

    @Override
    public String readLine() {
        return userInputs.get(readOffset++);
    }

    public void simulateUserInputs(String... inputs) {
        reset();
        Arrays.stream(inputs).forEach(str->userInputs.add(str));
    }

    private void reset() {
        readOffset = 0;
        userInputs.clear();
    }
}
