package com.uj.study.count_char_numbers;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：unclejet
 * @date ：Created in 2020/9/26 上午6:45
 * @description：
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 * @modified By：
 * @version:
 */
public class UserInputReaderTest extends BaseUserInputReaderTest {
    private UserInputReader userInputReader;

    @BeforeEach
    public void setUp() {
        super.setUp();
        userInputReader = new UserInputReader(lineReaderStub);
    }

    @Test
    void inputShouldBeASCII() {
        lineReaderStub.simulateUserInputs("汉子", "abaca");
        String input = userInputReader.readAscII();
        assertThat(input, is("abaca"));
    }
}
