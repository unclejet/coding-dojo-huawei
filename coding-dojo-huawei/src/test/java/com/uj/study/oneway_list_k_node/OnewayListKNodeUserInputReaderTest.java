package com.uj.study.oneway_list_k_node;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.LineReaderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/24 下午12:53
 * @description：
 * * 数据范围：链表长度满足 1≤n≤1000 1≤n≤1000  ， k≤n k≤n  ，链表中数据满足 0≤val≤10000 0≤val≤10000
 *
 * * 输入描述：
 *  *
 *  * 输入说明
 *  * 1 输入链表结点个数
 *  * 2 输入链表的值
 *  * 3 输入k的值
 *  * 输出描述：
 *  *
 *  * 输出一个整数
 *  * 示例1
 *  * 输入：
 *  *
 *  * 8
 *  * 1 2 3 4 5 6 7 8
 *  * 4
 */
public class OnewayListKNodeUserInputReaderTest extends BaseUserInputReaderTest {
    OnewayListKNodeUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new OnewayListKNodeUserInputReader(lineReaderStub);
    }

    @Test
    void length_check() {
        lineReaderStub.simulateUserInputs("a", "0", "1001", "1000");
        assertThat(reader.readLength(), is(1000));
    }

    @Test
    void data_check() {
        lineReaderStub.simulateUserInputs("a b c", "-1 1 2", "0 1000 10001", "0 2 10000");
        int[] data = reader.readNodeData(3);
        assertThat(data[0], is(0));
        assertThat(data[1], is(2));
        assertThat(data[2], is(10000));
    }

    @Test
    void k_check() {
        lineReaderStub.simulateUserInputs("a", "5", "2");
        int length = 3;
        assertThat(reader.readK(length), is(2));
    }
}
