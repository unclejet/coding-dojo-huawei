package com.uj.study.little_ball_path_height;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/17 下午12:05
 * @description：
 */
public class LittleBallPathHeightUserInputReaderTest extends BaseUserInputReaderTest {
    LittleBallPathHeightUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new LittleBallPathHeightUserInputReader(lineReaderStub);
    }

    @Test
    void inputHeightNumber_isValid() {
        lineReaderStub.simulateUserInputs("a", "0","1001", "1000");
        assertThat(reader.readHeight(), is(1000));
    }
}
