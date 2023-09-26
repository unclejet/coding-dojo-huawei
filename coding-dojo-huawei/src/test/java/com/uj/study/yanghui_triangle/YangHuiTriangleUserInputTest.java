package com.uj.study.yanghui_triangle;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/25 下午12:53
 * @description：
 */
public class YangHuiTriangleUserInputTest extends BaseUserInputReaderTest {
    private YangHuiTriangleUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new YangHuiTriangleUserInputReader(lineReaderStub);
    }

    @Test
    void n() {
        lineReaderStub.simulateUserInputs("0", "110", "109");
        assertThat(reader.readRowNumber(), is(109));
    }
}
