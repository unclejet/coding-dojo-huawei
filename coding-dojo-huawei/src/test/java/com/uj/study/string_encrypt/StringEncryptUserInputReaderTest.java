package com.uj.study.string_encrypt;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/8 下午12:10
 * @description：
 */
public class StringEncryptUserInputReaderTest extends BaseUserInputReaderTest {
    StringEncryptUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StringEncryptUserInputReader(lineReaderStub);
    }

    @Test
    void inputKey_isValid() {
        lineReaderStub.simulateUserInputs("Nihao","ni hao", "nihao", "word word");
        reader.readKeyAndEncryptString();
        assertThat(reader.getKey(), is("nihao"));
        assertThat(reader.getEncryptString(), is("word word"));
    }
}
