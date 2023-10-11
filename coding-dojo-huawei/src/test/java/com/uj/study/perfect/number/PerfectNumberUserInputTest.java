package com.uj.study.perfect.number;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/11 下午12:47
 * @description：
 * * 输入n，请输出n以内(含n)完全数的个数。
 *  *
 *  * 数据范围： 1≤n≤5×105 1≤n≤5×105
 *  * 输入描述：
 */
public class PerfectNumberUserInputTest extends BaseUserInputReaderTest {
    private PerfectNumberUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new PerfectNumberUserInputReader(lineReaderStub);
    }

    @Test
    void readNumber() {
        lineReaderStub.simulateUserInputs("a","0","500001","500000");
        assertThat(reader.readNumber(), is(500000));
    }
}
