package com.uj.study.yanghui_triangle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.uj.study.yanghui_triangle.YangHuiTriangle.generateTriangle;
import static com.uj.study.yanghui_triangle.YangHuiTriangle.getFirstEvenNumber;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/4 下午12:29
 * @description：
 *  以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数、左上角数和右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 *
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3，输入2则输出-1。
 *
 * 数据范围： 1≤n≤109 1≤n≤109
 * 输入描述：
 *
 * 输入一个int整数
 * 输出描述：
 *
 * 输出返回的int值
 * 示例1
 * 输入：
 *
 * 4
 *
 * 输出：
 *
 * 3
 */
public class YangHuiTriangleRowDataTest {
    @Test
    void generateTriangleCorrectly() {
        List<TriangleRowData> triangleRowDataList = generateTriangle(4);
        assertThat(triangleRowDataList.get(1).getData(), contains(1, 1, 1));
        assertThat(triangleRowDataList.get(0).getData(), contains(1));
        assertThat(triangleRowDataList.get(2).getData(), contains(1, 2, 3, 2, 1));
        assertThat(triangleRowDataList.get(3).getData(), contains(1, 3, 6, 7, 6, 3, 1));
    }

    @Test
    void firstEvenNumber() {
        List<TriangleRowData> triangleRowDataList = generateTriangle(109);
        assertThat(getFirstEvenNumber(triangleRowDataList, 1), is(-1));
        assertThat(getFirstEvenNumber(triangleRowDataList, 2), is(-1));
        assertThat(getFirstEvenNumber(triangleRowDataList, 3), is(2));
        assertThat(getFirstEvenNumber(triangleRowDataList, 4), is(3));
    }
}
