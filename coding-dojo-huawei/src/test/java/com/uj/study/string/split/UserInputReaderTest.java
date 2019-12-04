package com.uj.study.string.split;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserInputReaderTest {

    private LineReaderStub stub;
    private UserInputReader reader;

    @BeforeEach
    void setUp() {
        stub = new LineReaderStub();
        reader = new UserInputReader(stub);
    }

    @Test
    void userMustInputTwice_input2String() {
        stub.simulateUserInputs("one", "two");
        String[] actual = reader.read2String();
        assertThat(actual[0], is("one"));
        assertThat(actual[1], is("two"));
    }

    @Test
    void userMustInputTwice_press2Enter() {
        stub.simulateUserInputs("", "");
        String[] actual = reader.read2String();
        assertThat(actual[0], is(""));
        assertThat(actual[1], is(""));
    }

    @Test
    void userInput_lessThan100() {
        String moreString = RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(101);
        String firstLine = RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(100);
        String moreString1 = RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(201);
        String secondLine = RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(99);
        String moreString2 = RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(1);
        stub.simulateUserInputs(moreString, firstLine, moreString1, secondLine, moreString2);
        String[] actual = reader.read2String();
        assertThat(actual[0], is(firstLine));
        assertThat(actual[1], is(secondLine));
    }

    static class LineReaderStub implements LineReader {
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
