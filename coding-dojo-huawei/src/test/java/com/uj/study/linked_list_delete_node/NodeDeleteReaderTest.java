package com.uj.study.linked_list_delete_node;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/30 下午12:48
 * @description：
 * 数据范围：链表长度满足 1≤n≤1000 1≤n≤1000  ，节点中的值满足 0≤val≤10000 0≤val≤10000
 * * 输出删除结点后的序列，每个数后都要加空格
 *  * 示例1
 *  * 输入：
 *  *
 *  * 5 2 3 2 4 3 5 2 1 4 3
 *  *
 *  * 输出：
 *  *
 *  * 2 5 4 1
 *  *
 *  * 说明：
 *  *
 *  * 形成的链表为2->5->3->4->1
 *  * 删掉节点3，返回的就是2->5->4->1
 *  *
 *  * 示例2
 *  * 输入：
 *  *
 *  * 6 2 1 2 3 2 5 1 4 5 7 2 2
 *  *
 *  * 输出：
 *  *
 *  * 7 3 1 5 4
 */
public class NodeDeleteReaderTest extends BaseUserInputReaderTest {
    NodeDeleteReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new NodeDeleteReader(lineReaderStub);
    }

    @Test
    void isInteger() {
        lineReaderStub.simulateUserInputs("a 1", "2 3 1 100001", "-1 1", "2 10000 1 10000 10000");
        List<Integer> list = reader.read();
        assertThat(list.size(), is(5));
    }

    @Test
    void listDataContentCorrect() {
        lineReaderStub.simulateUserInputs("2 3 1 3", "2 3 1 3 4",  "2 3 1 3 3");
        List<Integer> list = reader.read();
        assertThat(list, containsInAnyOrder(2, 3, 1, 3, 3));
    }

    @Test
    void fullTest() {
        lineReaderStub.simulateUserInputs("6 2 1 2 3 2 5 1 4 5 7 2 2");
        List<Integer> list = reader.read();
        assertThat(list, containsInAnyOrder(6, 2, 1, 2, 3, 2, 5, 1, 4, 5, 7, 2, 2));
    }

    @Test
    void fullTest1() {
        lineReaderStub.simulateUserInputs("5 2 3 2 4 3 5 2 1 4 3");
        List<Integer> list = reader.read();
        assertThat(list, containsInAnyOrder(5, 2, 3, 2, 4, 3, 5, 2, 1, 4, 3));
    }
}
