package com.uj.study.countcharinstring;

import com.uj.study.common.input.LineReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineReaderStub implements LineReader {
    List<String> userInputs = new ArrayList<>();

    int readOffset = 0;

    @Override
    public String readLine() {
        return userInputs.get(readOffset++);
    }

    void simulateUserInputs(String... inputs) {
        reset();
        Arrays.stream(inputs).forEach(str->userInputs.add(str));
    }

    private void reset() {
        readOffset = 0;
        userInputs.clear();
    }


}
