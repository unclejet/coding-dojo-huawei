package com.uj.study.smallest;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/24 下午12:50
 * @description：
 * * 本题有多组输入样例
 *  *
 *  * 数据范围：1≤n≤1000 1≤n≤1000  ，输入的整数满足 1≤val≤10000 1≤val≤10000
 *  * 输入描述：
 *  *
 *  * 第一行输入两个整数n和k
 *  * 第二行输入一个整数数组
 *  * 输出描述：
 *  *
 *  * 从小到大输出最小的k个整数，用空格分开。
 *  * 示例1
 *  * 输入：
 *  *
 *  * 5 2
 *  * 1 3 5 7 2
 */
public class SmallestIntegerKGeneratorReaderTest extends BaseUserInputReaderTest {
    private SmallestIntegerKGeneratorReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new SmallestIntegerKGeneratorReader(lineReaderStub);
    }

    @Test
    void firstLineCorrect() {
        lineReaderStub.simulateUserInputs("52", "0 0", "1001 1000", "2 5", "5 0", "5   1");
        reader.readFirstLine();
        assertThat(reader.getArraySize(), is(5));
        assertThat(reader.getKNumber(), is(1));
    }

    @Test
    void secondLineCorrect() {
        lineReaderStub.simulateUserInputs("0 0 0", "1 10001 10000", "5 7", "5 7 2");
        reader.readSecondLine(3);
        int[] arr = reader.getArray();
        assertThat(arr[0], is(5));
        assertThat(arr[1], is(7));
        assertThat(arr[2], is(2));
    }
}
