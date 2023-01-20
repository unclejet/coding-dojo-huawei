package com.uj.study.study_english;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:54
 * @description：
 */
public class StudyEnglishUserInputReaderTest extends BaseUserInputReaderTest {
    StudyEnglishUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StudyEnglishUserInputReader(lineReaderStub);
    }

    @Test
    void validInput() {
        lineReaderStub.simulateUserInputs("-1", "a", "0","1");
        assertThat(reader.readNumber(), is("0"));
        lineReaderStub.simulateUserInputs("1000000000001", "100000000000");
        assertThat(reader.readNumber(), is("100000000000"));
    }
}
