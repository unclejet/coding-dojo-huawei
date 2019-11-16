package com.uj.study.countcharinstring;

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
        Arrays.stream(inputs).forEach(str->userInputs.add(str));
    }


}
