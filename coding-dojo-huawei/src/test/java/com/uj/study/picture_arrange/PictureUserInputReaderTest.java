package com.uj.study.picture_arrange;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/21 下午12:14
 * @description：
 */
public class PictureUserInputReaderTest extends BaseUserInputReaderTest {
    PictureUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new PictureUserInputReader(lineReaderStub);
    }

    @Test
    void validPictures() {
        lineReaderStub.simulateUserInputs("#", "", RandomAlphabetGenerator.generateRandomCharacters(1001), "0aI");
        assertThat(reader.readPictures(), is("0aI"));
    }
}
