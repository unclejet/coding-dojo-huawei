package com.uj.study.countcharinstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串
 * 第二行输入一个字符.
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数.
 */
public class CharInStringCounterTest {


    public static final String STRING1 = "random string";
    public static final String CHAR_A = "a";
    private LineReaderStub stub;
    private UserInputReader reader;

    @BeforeEach
    void setUp() {
        stub = new LineReaderStub();
        reader = new UserInputReader(stub);
    }

    @Test
    void userMustInputTwoLines() {
        stub.simulateUserInputs(STRING1, CHAR_A);

        String firstLine = reader.readFirstLine();
        String secondLine = reader.readSecondLine();

        assertEquals(STRING1, firstLine);
        assertEquals(CHAR_A, secondLine);
    }

    @Test
    void firstLineMustBe_Char_number_space() {
        verifyFirstLineRule(new String[]{"@@@", STRING1});
        verifyFirstLineRule(new String[]{"_", " "});
        verifyFirstLineRule(new String[]{"[] \\", " sdf22 223 fds s434 s "});
    }

    @Test
    void secondLine_onlyOneChar() {
        verifySecondLineRule(new String[]{"_", "c"});
        verifySecondLineRule(new String[]{"cc", "c"});
        verifySecondLineRule(new String[]{"we 234se 23", "c"});
        verifySecondLineRule(new String[]{" "});
        verifySecondLineRule(new String[]{"2"});
    }

    @Test
    void countCharInString() {
        stub.simulateUserInputs(STRING1, CHAR_A);
        assertEquals(1, CharCounter.count(reader.readFirstLine(), reader.readSecondLine()));

        stub.simulateUserInputs(" sdf22 223 fds s434 s ", "s");
        assertEquals(4, CharCounter.count(reader.readFirstLine(), reader.readSecondLine()));
    }

    @Test
    void verifyOutput() {
        LinePrinterStub stub = new LinePrinterStub();
        long count = CharCounter.count("abcda", "a");
        stub.printLine(String.valueOf(count));
        assertThat(stub.content, is("2"));
    }

    private void verifyFirstLineRule(String[] inputs) {
        stub.simulateUserInputs(inputs);
        String firstLine  = reader.readFirstLine();
        assertEquals(inputs[inputs.length - 1], firstLine);
    }

    private void verifySecondLineRule(String[] inputs) {
        stub.simulateUserInputs(inputs);
        String secondLine  = reader.readSecondLine();
        assertEquals(inputs[inputs.length - 1], secondLine);
    }
}
