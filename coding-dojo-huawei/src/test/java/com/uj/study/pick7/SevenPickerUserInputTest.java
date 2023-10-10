package com.uj.study.pick7;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/9 下午12:58
 * @description：
 * * 数据范围： 1≤n≤30000 1≤n≤30000
 *  * 输入描述：
 *  *
 *  * 一个正整数 n 。( n 不大于 30000 )
 */
public class SevenPickerUserInputTest extends BaseUserInputReaderTest {
    private SevenPickerUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new SevenPickerUserInputReader(lineReaderStub);
    }

    @Test
    void nothing() {
        lineReaderStub.simulateUserInputs("0","30001","30000");
        assertThat(reader.readNumber(), is(30000));
    }
}
