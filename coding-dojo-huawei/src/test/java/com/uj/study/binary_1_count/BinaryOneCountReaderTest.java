package com.uj.study.binary_1_count;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/20 下午12:34
 * @description：
 *  * 描述
 *  * 输入一个正整数，计算它在二进制下的1的个数。
 *  * 注意多组输入输出！！！！！！
 *  *
 *  * 数据范围： 1≤n≤231−1 1≤n≤231−1
 *  * 输入描述：
 *  *
 */
public class BinaryOneCountReaderTest extends BaseUserInputReaderTest {
    private BinaryOneCountReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new BinaryOneCountReader(lineReaderStub);
    }

    @Test
    void base2Exponent31() {
        assertThat((int)(Math.pow(2, 31) - 1), is(Integer.MAX_VALUE));
    }

    @Test
    void inputNumber_correctly() {
        lineReaderStub.simulateUserInputs("a", "-1", "0", String.valueOf(Integer.MAX_VALUE));
        assertThat(reader.readNumberStr(), is(String.valueOf(Integer.MAX_VALUE)));
    }
}
