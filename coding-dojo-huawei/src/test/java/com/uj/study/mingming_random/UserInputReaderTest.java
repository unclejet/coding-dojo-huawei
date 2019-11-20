package com.uj.study.mingming_random;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserInputReaderTest {
    @Test
    void inputArraySize_ShouldBeNumber() {
        LineReaderStub stub = new LineReaderStub();
        stub.simulateUserInputs("abc", "@$#E", "11");
        UserInputReader reader = new UserInputReader(stub);
        assertThat(reader.readArraySize(), is(11));
    }

    @Test
    void createArrayFromUserInput() {
        LineReaderStub stub = new LineReaderStub();
        stub.simulateUserInputs("try", "10", "15", "abc", "30", "40");
        UserInputReader reader = new UserInputReader(stub);
        int[] array = reader.createArray(3);
        assertThat(array, is(new int[]{10, 15, 30}));
    }

    private class LineReaderStub implements LineReader {
        List<String> userInputs = new ArrayList<>();
        private int readOffset = 0;

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
}
