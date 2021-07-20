package com.uj.study.soda_bottle;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/7/19 下午12:19
 * @description：
 * 描述
 *
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 输入描述：
 *
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
 * 输出描述：
 *
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 * 示例1
 * 输入：
 *
 * 3
 * 10
 * 81
 * 0
 *
 * 输出：
 *
 * 1
 * 5
 * 40
 */
public class SodaBottleUserInputReaderTest extends BaseUserInputReaderTest {
    private SodaBottleUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new SodaBottleUserInputReader(lineReaderStub);
    }

    @Test
    void inputDataNumberLessThan10() {
        lineReaderStub.simulateUserInputs("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "0");
        assertThat(reader.read(), contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    void oneLineOnlyOnePositiveNumberBetween0_100() {
        lineReaderStub.simulateUserInputs("2 3", "-1", "100", "101", "1", "0");
        assertThat(reader.read(), contains(100, 1));
    }
}
