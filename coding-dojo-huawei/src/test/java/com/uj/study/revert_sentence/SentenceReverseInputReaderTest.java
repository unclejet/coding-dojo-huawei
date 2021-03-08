package com.uj.study.revert_sentence;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/2 上午11:52
 * @description：
 */
public class SentenceReverseInputReaderTest extends BaseUserInputReaderTest {
    private SentenceReverseInputReader inputReader;

    @BeforeEach
    public void setUp() {
        super.setUp();
        inputReader = new SentenceReverseInputReader(lineReaderStub);
    }

    @Test
    void input_is_englishChars() {
        lineReaderStub.simulateUserInputs("i AM 30 OLD", "I am a boy");
        assertThat(inputReader.readAlpha(), is("I am a boy"));
    }
}
