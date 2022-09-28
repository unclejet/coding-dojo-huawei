package com.uj.study.password_interception;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/9/27 下午12:49
 * @description：
 */
public class PasswordInterceptionUserInputReaderTest extends BaseUserInputReaderTest {
    PasswordInterceptionUserInputReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new PasswordInterceptionUserInputReader(lineReaderStub);
    }

    @Test
    void validInput() {
        lineReaderStub.simulateUserInputs("", "a");
        assertThat(reader.readLine(), is("a"));
        String s_2501 = RandomAlphabetGenerator.generateRandomCharacters(2501);
        String s_2500 = RandomAlphabetGenerator.generateRandomCharacters(2500);
        lineReaderStub.simulateUserInputs(s_2501, s_2500);
        assertThat(reader.readLine(), is(s_2500));
    }
}
