package com.uj.study.linked_list_delete_node;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/20 下午12:56
 * @description：
 * 描述
 *
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表的值不能重复。
 * 构造过程，例如输入一行数据为:
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
 * 1 2 表示为
 * 2->1
 * 链表为2->1
 *
 * 3 2表示为
 * 2->3
 * 链表为2->3->1
 *
 * 5 1表示为
 * 1->5
 * 链表为2->3->1->5
 *
 * 4 5表示为
 * 5->4
 * 链表为2->3->1->5->4
 *
 * 7 2表示为
 * 2->7
 * 链表为2->7->3->1->5->4
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 *
 * 最后一个参数为2，表示要删掉节点为2的值
 *
 * 删除 结点 2
 * 则结果为 7 3 1 5 4
 *
 * 数据范围：链表长度满足 1≤n≤1000 1≤n≤1000  ，节点中的值满足 0≤val≤10000 0≤val≤10000
 *
 * 测试用例保证输入合法
 *
 *
 * 输入描述：
 * 输入一行，有以下4个部分：
 *
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 * 输出描述：
 * 输出一行
 *
 * 输出删除结点后的序列，每个数后都要加空格
 * 示例1
 * 输入：
 *
 * 5 2 3 2 4 3 5 2 1 4 3
 *
 * 输出：
 *
 * 2 5 4 1
 *
 * 说明：
 *
 * 形成的链表为2->5->3->4->1
 * 删掉节点3，返回的就是2->5->4->1
 *
 * 示例2
 * 输入：
 *
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 *
 * 输出：
 *
 * 7 3 1 5 4
 *
 * 说明：
 *
 * 如题
 */
public class LinkedListNodeDeleterTest {
    @Test
    void generate_2_nodes() {
        List<Integer> list = Arrays.asList(2, 2, 1, 2, 2);
        NodeDeleter nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);
        assertThat(nodeDeleter.getTotal(), is(2));
        assertThat(nodeDeleter.getFirst(), is(2));
        assertThat(nodeDeleter.getDelete(), is(2));
        Node n1 = nodeDeleter.getFirstNode();
        assertThat(n1.getData(), is(2));
        assertThat(n1.getPrevious(), nullValue());
        Node n2 = n1.getNext();
        assertThat(n2.getData(), is(1));
        assertThat(n2.getPrevious().getData(), is(2));
    }

    @Test
    void generate_3_nodes() {
         List<Integer> list = Arrays.asList(3, 2, 1, 2, 3, 2, 2);
        NodeDeleter nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);
        assertThat(nodeDeleter.getTotal(), is(3));
        assertThat(nodeDeleter.getFirst(), is(2));
        assertThat(nodeDeleter.getDelete(), is(2));

        Node n1 = nodeDeleter.getFirstNode();
        assertThat(n1.getData(), is(2));
        assertThat(n1.getPrevious(), nullValue());

        Node n2 = n1.getNext();
        assertThat(n2.getData(), is(3));
        assertThat(n2.getPrevious().getData(), is(2));
        assertThat(n2.getNext().getData(), is(1));

        Node n3 = n2.getNext();
        assertThat(n3.getData(), is(1));
        assertThat(n3.getPrevious().getData(), is(3));
        assertThat(n3.getNext(), nullValue());
    }

    /**
     * 2->3->1->5
     */
    @Test
    void generate_4_nodes() {
        List<Integer> list = Arrays.asList(4, 2, 1, 2, 3, 2, 5, 1, 2);
        NodeDeleter nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);

        Node n1 = nodeDeleter.getFirstNode();
        assertThat(n1.getData(), is(2));
        assertThat(n1.getPrevious(), nullValue());

        Node n2 = n1.getNext();
        assertThat(n2.getData(), is(3));
        assertThat(n2.getPrevious().getData(), is(2));
        assertThat(n2.getNext().getData(), is(1));

        Node n3 = n2.getNext();
        assertThat(n3.getData(), is(1));
        assertThat(n3.getPrevious().getData(), is(3));
        assertThat(n3.getNext().getData(), is(5));

        Node n4 = n3.getNext();
        assertThat(n4.getData(), is(5));
        assertThat(n4.getPrevious().getData(), is(1));
        assertThat(n4.getNext(), nullValue());
    }

    /**
     * 2->3->1->5->4
     *
     * 5 2 3 2 4 3 5 2 1 4 3
     * 2->5->3->4->1
     */
    @Test
    void generate_5_nodes() {
        List<Integer> list = Arrays.asList(5, 2, 1, 2, 3, 2, 5, 1, 4, 5, 2);
        NodeDeleter nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);

        Node n1 = nodeDeleter.getFirstNode();
        assertThat(n1.getData(), is(2));
        assertThat(n1.getPrevious(), nullValue());

        Node n2 = n1.getNext();
        assertThat(n2.getData(), is(3));
        assertThat(n2.getPrevious().getData(), is(2));
        assertThat(n2.getNext().getData(), is(1));

        Node n3 = n2.getNext();
        assertThat(n3.getData(), is(1));
        assertThat(n3.getPrevious().getData(), is(3));
        assertThat(n3.getNext().getData(), is(5));

        Node n4 = n3.getNext();
        assertThat(n4.getData(), is(5));
        assertThat(n4.getPrevious().getData(), is(1));
        assertThat(n4.getNext().getData(), is(4));

        Node n5 = n4.getNext();
        assertThat(n5.getData(), is(4));
        assertThat(n5.getPrevious().getData(), is(5));
        assertThat(n5.getNext(), nullValue());

        list = Arrays.asList(5, 2, 3, 2, 4, 3, 5, 2, 1, 4, 3);
        nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);

        n1 = nodeDeleter.getFirstNode();
        assertThat(n1.getData(), is(2));
        assertThat(n1.getPrevious(), nullValue());

        n2 = n1.getNext();
        assertThat(n2.getData(), is(5));
        assertThat(n2.getPrevious().getData(), is(2));
        assertThat(n2.getNext().getData(), is(3));

        n3 = n2.getNext();
        assertThat(n3.getData(), is(3));
        assertThat(n3.getPrevious().getData(), is(5));
        assertThat(n3.getNext().getData(), is(4));

        n4 = n3.getNext();
        assertThat(n4.getData(), is(4));
        assertThat(n4.getPrevious().getData(), is(3));
        assertThat(n4.getNext().getData(), is(1));

        n5 = n4.getNext();
        assertThat(n5.getData(), is(1));
        assertThat(n5.getPrevious().getData(), is(4));
        assertThat(n5.getNext(), nullValue());
    }

    /**
     * 2->7->3->1->5->4
     * 6 2 1 2 3 2 5 1 4 5 7 2 2
     */
    @Test
    void generate_6_nodes() {
        List<Integer> list = Arrays.asList(6, 2, 1, 2, 3, 2, 5, 1, 4, 5, 7, 2, 2);
        NodeDeleter nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);

        Node n1 = nodeDeleter.getFirstNode();
        assertThat(n1.getData(), is(2));
        assertThat(n1.getPrevious(), nullValue());

        Node n2 = n1.getNext();
        assertThat(n2.getData(), is(7));
        assertThat(n2.getPrevious().getData(), is(2));
        assertThat(n2.getNext().getData(), is(3));

        Node n3 = n2.getNext();
        assertThat(n3.getData(), is(3));
        assertThat(n3.getPrevious().getData(), is(7));
        assertThat(n3.getNext().getData(), is(1));

        Node n4 = n3.getNext();
        assertThat(n4.getData(), is(1));
        assertThat(n4.getPrevious().getData(), is(3));
        assertThat(n4.getNext().getData(), is(5));

        Node n5 = n4.getNext();
        assertThat(n5.getData(), is(5));
        assertThat(n5.getPrevious().getData(), is(1));
        assertThat(n5.getNext().getData(), is(4));

        Node n6 = n5.getNext();
        assertThat(n6.getData(), is(4));
        assertThat(n6.getPrevious().getData(), is(5));
        assertThat(n6.getNext(), nullValue());
    }

    /**
     * 7->3->1->5->4
     */

    @Test
    void delete_node() {
        List<Integer> list = Arrays.asList(6, 2, 1, 2, 3, 2, 5, 1, 4, 5, 7, 2, 2);
        NodeDeleter nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);

        nodeDeleter.deleteNode();

        Node n2 = nodeDeleter.getFirstNode();
        assertThat(n2.getData(), is(7));
        assertThat(n2.getPrevious().getData(), is(2));
        assertThat(n2.getNext().getData(), is(3));

        Node n3 = n2.getNext();
        assertThat(n3.getData(), is(3));
        assertThat(n3.getPrevious().getData(), is(7));
        assertThat(n3.getNext().getData(), is(1));

        Node n4 = n3.getNext();
        assertThat(n4.getData(), is(1));
        assertThat(n4.getPrevious().getData(), is(3));
        assertThat(n4.getNext().getData(), is(5));

        Node n5 = n4.getNext();
        assertThat(n5.getData(), is(5));
        assertThat(n5.getPrevious().getData(), is(1));
        assertThat(n5.getNext().getData(), is(4));

        Node n6 = n5.getNext();
        assertThat(n6.getData(), is(4));
        assertThat(n6.getPrevious().getData(), is(5));
        assertThat(n6.getNext(), nullValue());

        list = Arrays.asList(5, 2, 3, 2, 4, 3, 5, 2, 1, 4, 3);
        nodeDeleter = new NodeDeleter();
        nodeDeleter.generate(list);
        nodeDeleter.deleteNode();

        Node n1 = nodeDeleter.getFirstNode();
        assertThat(n1.getData(), is(2));
        assertThat(n1.getPrevious(), nullValue());

        n2 = n1.getNext();
        assertThat(n2.getData(), is(5));
        assertThat(n2.getPrevious().getData(), is(2));
        assertThat(n2.getNext().getData(), is(4));


        n4 = n2.getNext();
        assertThat(n4.getData(), is(4));
        assertThat(n4.getPrevious().getData(), is(3));
        assertThat(n4.getNext().getData(), is(1));

        n5 = n4.getNext();
        assertThat(n5.getData(), is(1));
        assertThat(n5.getPrevious().getData(), is(4));
        assertThat(n5.getNext(), nullValue());
    }
}

