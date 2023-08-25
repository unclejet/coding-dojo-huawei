package com.uj.study.oneway_list_k_node;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.uj.study.oneway_list_k_node.OnewayListKNode.buildList;
import static com.uj.study.oneway_list_k_node.OnewayListKNode.getKNode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/22 下午1:00
 * @description：
 * 描述
 *
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * 链表结点定义如下：
 *
 * struct ListNode
 * {
 *     int m_nKey;
 *     ListNode* m_pNext;
 * };
 *
 * 正常返回倒数第k个结点指针，异常返回空指针.
 * 要求：
 * (1)正序构建链表;
 * (2)构建后要忘记链表长度。
 * 数据范围：链表长度满足 1≤n≤1000 1≤n≤1000  ， k≤n k≤n  ，链表中数据满足 0≤val≤10000 0≤val≤10000
 *
 * 本题有多组样例输入。
 *
 *
 *
 * 输入描述：
 *
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 * 输出描述：
 *
 * 输出一个整数
 * 示例1
 * 输入：
 *
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 *
 * 输出：
 *
 * 5
 */
public class OnewayListKNodeTest {
    @Test
    void buildListCorrect() {
        int[] data = new int[]{1, 2};
        ListNode ln = buildList(data);
        assertThat(ln.getM_nKey(), is(1));
        assertThat(ln.getM_pNext().getM_nKey(), is(2));
    }

    @Test
    void get_k_node() {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode ln = buildList(data);

        assertThat(getKNode(4, ln), is(5));
        assertThat(getKNode(1, ln), is(8));
        assertThat(getKNode(8, ln), is(1));
    }
}

