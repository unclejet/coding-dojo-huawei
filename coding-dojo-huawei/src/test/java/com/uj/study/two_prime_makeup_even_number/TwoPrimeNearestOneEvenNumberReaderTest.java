package com.uj.study.two_prime_makeup_even_number;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * @author ：UncleJet
 * @date ：Created in 2023/11/1 下午12:42
 * @description：
 * * <p>
 *  * 数据范围：输入的数据满足 4≤n≤1000 4≤n≤1000
 *  * 输入描述：
 *  * <p>
 *  * 输入一个大于2的偶数
 *  * 输出描述：
 *  * <p>
 *  * 从小到大输出两个素数
 *  * 示例1
 *  * 输入：
 *  * <p>
 *  * 20
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * 7
 *  * 13
 *  * <p>
 */
public class TwoPrimeNearestOneEvenNumberReaderTest extends BaseUserInputReaderTest {
    TwoPrimeNearestOneEvenNumberReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new TwoPrimeNearestOneEvenNumberReader(lineReaderStub);
    }

    @Test
    void numberValid() {
        lineReaderStub.simulateUserInputs("a", "3", "2", "1002", "1000");
        assertThat(reader.readEvenNumber(), is(1000));
    }
}
