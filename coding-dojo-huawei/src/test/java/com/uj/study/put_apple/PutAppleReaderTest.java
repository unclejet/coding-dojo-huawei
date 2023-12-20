package com.uj.study.put_apple;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/19 下午12:25
 * @description：
 * * <p>
 *  * 数据范围：0≤m≤10 0≤m≤10 ，1≤n≤10 1≤n≤10 。
 *  * <p>
 *  * <p>
 *  * 输入描述：
 *  * <p>
 *  * 输入两个int整数
 */
public class PutAppleReaderTest extends BaseUserInputReaderTest {
    private PutAppleReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new PutAppleReader(lineReaderStub);
    }

    @Test
    void input_number_is_valid() {
        lineReaderStub.simulateUserInputs("a b", "-1 1", "0 0", "1 11", "1 1 1", "0 10");
        reader.readAppleAndPlateNumber();
        assertThat(reader.getApple(), is(0));
        assertThat(reader.getPlate(), is(10));
    }
}
