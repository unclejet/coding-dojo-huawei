package com.uj.study.suduku;

import com.uj.study.suduku.SuDuKu.MissingNumber;
import com.uj.study.suduku.SuDuKu.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.uj.study.suduku.SuDuKu.fillNumbers;
import static com.uj.study.suduku.SuDuKu.findPoint0;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/4/26 下午12:25
 * @description： 描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
 * 例如：
 * 输入
 * <p>
 * 输出
 * <p>
 * <p>
 * 数据范围：输入一个 9*9 的矩阵
 * 输入描述：
 * <p>
 * <p>
 * 算法纪要：
 * 1、根据0所在的行和列把missing number找出来
 * 2、确认0所在的3x3数组
 * 3、33数组根据自己的需要，从missing number中筛选
 * <p>
 * <p>
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出描述：
 * <p>
 * 完整的9X9盘面数组
 * 示例1
 * 输入：
 * <p>
 * 0 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 0 4 5 2 7 6 8 3 1
 * <p>
 * 输出：
 * <p>
 * 5 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 9 4 5 2 7 6 8 3 1
 */
public class SuDuKuTest {
    @Test
    void array3x3_fillNumber() {
        int[][] array = new int[][]{{0, 9, 2}, {4, 1, 3}, {8, 6, 7}};
        fillNumbers(array);
        assertThat(array[0][0], is(5));

        array = new int[][]{{0, 9, 2}, {4, 0, 3}, {8, 6, 0}};
        fillNumbers(array);
        assertThat(array[0][0], is(1));
        assertThat(array[1][1], is(5));
        assertThat(array[2][2], is(7));

        array = new int[][]{{4, 8, 0}, {0, 6, 2}, {3, 0, 9}};
        fillNumbers(array);
        assertThat(array[0][2], is(1));
        assertThat(array[1][0], is(5));
        assertThat(array[2][1], is(7));

        array = new int[][]{{0, 8, 1}, {7, 0, 2}, {0, 5, 9}};
        fillNumbers(array);
        assertThat(array[0][0], is(3));
        assertThat(array[1][1], is(4));
        assertThat(array[2][0], is(6));

        array = new int[][]{{4, 0, 1}, {7, 0, 2}, {3, 0, 9}};
        fillNumbers(array);
        assertThat(array[0][1], is(5));
        assertThat(array[1][1], is(6));
        assertThat(array[2][1], is(8));
    }

    @Test
    void find0Points() {
        int[][] array = new int[][]{{0, 9, 2}, {4, 0, 3}, {8, 6, 0}};
        List<Point> points = findPoint0(array);
        assertThat(points.size(), is(3));
        assertThat(points.get(0).getCol(), is(0));
        assertThat(points.get(0).getRow(), is(0));
        assertThat(points.get(2).getCol(), is(2));
        assertThat(points.get(2).getRow(), is(2));

        int[][] array99 = new int[][]{
                {0, 9, 2, 4, 8, 1, 7, 6, 3},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {8, 6, 7, 3, 5, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 0},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        points = findPoint0(array99);
        assertThat(points.size(), is(3));
        assertThat(points.get(1).getCol(), is(8));
        assertThat(points.get(1).getRow(), is(6));
    }

    @Test
    void findMissingNumbersWithArr3x3() {
        int[][] array = new int[][]{{0, 9, 2}, {4, 0, 3}, {8, 6, 0}};
        List<MissingNumber> mn = SuDuKu.findMissingNumbersWithArr3x3(array);
        assertThat(mn, containsInAnyOrder(new MissingNumber(1), new MissingNumber(5), new MissingNumber(7)));
    }

    /**
     * 0那一行那一列的数字列表拿到
     */
    @Test
    void findRelatedAxisNumbers() {
        int[][] array = new int[][]{{5, 9, 2}, {4, 0, 3}, {8, 6, 7}};
        List<Integer> axisNumbers = SuDuKu.findRelatedAxisNumbers(new Point(1, 1), array);
        assertThat(axisNumbers, containsInAnyOrder(3, 4, 6, 9));

        array = new int[][]{{5, 9, 2}, {4, 1, 3}, {0, 6, 7}};
        axisNumbers = SuDuKu.findRelatedAxisNumbers(new Point(2, 0), array);
        assertThat(axisNumbers, containsInAnyOrder(4, 5, 6, 7));

        int[][] array99 = new int[][]{
                {0, 9, 2, 4, 8, 1, 7, 6, 3},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {8, 6, 7, 3, 5, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        axisNumbers = SuDuKu.findRelatedAxisNumbers(new Point(0, 0), array99);
        assertThat(axisNumbers, containsInAnyOrder(0, 1, 2, 3, 4, 6, 7, 8, 9));
        axisNumbers = SuDuKu.findRelatedAxisNumbers(new Point(8, 0), array99);
        assertThat(axisNumbers, containsInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7, 8));
    }

    @Test
    void findMissingNumbers() {
        int[][] array99 = new int[][]{
                {0, 9, 2, 4, 8, 1, 7, 6, 3},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {8, 6, 7, 3, 5, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        List<MissingNumber> mn = SuDuKu.findMissingNumbers(array99, new SuDuKu.Point(0, 0));
        assertThat(mn, containsInAnyOrder(new MissingNumber(5)));
    }

    @Test
    void sudu() {
        int[][] array99 = new int[][]{
                {0, 9, 2, 4, 8, 1, 7, 6, 3},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {8, 6, 7, 3, 5, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        SuDuKu.sudu(array99);
        assertThat(array99[0][0], is(5));
        assertThat(array99[8][0], is(9));

        array99 = new int[][]{
                {0, 9, 2, 4, 8, 1, 0, 6, 3},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {0, 6, 7, 3, 0, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        SuDuKu.sudu(array99);
        assertThat(array99[0][0], is(5));
        assertThat(array99[0][6], is(7));
        assertThat(array99[2][0], is(8));
        assertThat(array99[2][4], is(5));
        assertThat(array99[8][0], is(9));

        array99 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {8, 6, 7, 3, 5, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        SuDuKu.sudu(array99);
        assertThat(array99[0][0], is(5));
        assertThat(array99[0][1], is(9));
        assertThat(array99[0][2], is(2));
        assertThat(array99[0][3], is(4));
        assertThat(array99[0][4], is(8));
        assertThat(array99[0][5], is(1));
        assertThat(array99[0][6], is(7));
        assertThat(array99[0][7], is(6));
        assertThat(array99[0][8], is(3));
        assertThat(array99[8][0], is(9));

        array99 = new int[][]{
                {0, 9, 0, 4, 8, 1, 7, 6, 0},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {8, 6, 7, 3, 5, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 0, 2, 7, 6, 8, 3, 0}
        };
        SuDuKu.sudu(array99);
        assertThat(array99[0][0], is(5));
        assertThat(array99[0][2], is(2));
        assertThat(array99[0][8], is(3));
        assertThat(array99[8][0], is(9));
        assertThat(array99[8][8], is(1));
        assertThat(array99[8][2], is(5));

        array99 = new int[][]{
                {0, 0, 0, 4, 8, 1, 7, 6, 3},
                {0, 0, 0, 7, 6, 2, 9, 8, 5},
                {0, 0, 0, 3, 5, 9, 4, 1, 2},
                {6, 2, 4, 1, 9, 5, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {0, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        SuDuKu.sudu(array99);
        assertThat(array99[0][0], is(5));
        assertThat(array99[0][1], is(9));
        assertThat(array99[0][2], is(2));
        assertThat(array99[1][0], is(4));
        assertThat(array99[1][1], is(1));
        assertThat(array99[1][2], is(3));
        assertThat(array99[2][0], is(8));
        assertThat(array99[2][1], is(6));
        assertThat(array99[2][2], is(7));

        array99 = new int[][]{
                {5, 9, 2, 4, 8, 1, 7, 6, 3},
                {4, 1, 3, 7, 6, 2, 9, 8, 5},
                {8, 6, 7, 3, 0, 0, 4, 1, 2},
                {6, 2, 4, 1, 0, 0, 3, 7, 8},
                {7, 5, 9, 8, 4, 3, 1, 2, 6},
                {1, 3, 8, 6, 2, 7, 5, 9, 4},
                {2, 7, 1, 5, 3, 8, 6, 4, 9},
                {3, 8, 6, 9, 1, 4, 2, 5, 7},
                {9, 4, 5, 2, 7, 6, 8, 3, 1}
        };
        SuDuKu.sudu(array99);
        assertThat(array99[2][4], is(5));
        assertThat(array99[2][5], is(9));
        assertThat(array99[3][4], is(9));
        assertThat(array99[3][5], is(5));

        array99 = new int[][]{
                {5, 9, 2, 4, 0, 1, 7, 6, 3},
                {4, 1, 0, 7, 0, 0, 9, 8, 5},
                {8, 6, 7, 3, 0, 0, 4, 1, 2},
                {6, 0, 4, 1, 0, 0, 3, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 3, 8, 6, 0, 7, 5, 0, 4},
                {2, 7, 1, 0, 0, 8, 6, 4, 9},
                {3, 8, 6, 9, 0, 4, 2, 5, 7},
                {9, 4, 5, 2, 0, 6, 8, 3, 1}
        };
        SuDuKu.sudu(array99);
        assertThat(array99[6][3], is(5));
        assertThat(array99[5][7], is(9));
        assertThat(array99[3][1], is(2));
        assertThat(array99[3][7], is(7));
        assertThat(array99[4][0], is(7));
        assertThat(array99[4][1], is(5));
        assertThat(array99[4][2], is(9));
        assertThat(array99[4][3], is(8));
        assertThat(array99[4][4], is(4));
        assertThat(array99[4][5], is(3));
        assertThat(array99[4][6], is(1));
        assertThat(array99[4][7], is(2));
        assertThat(array99[4][8], is(6));
        assertThat(array99[0][4], is(8));
        assertThat(array99[1][4], is(6));
        assertThat(array99[2][4], is(5));
        assertThat(array99[3][4], is(9));
        assertThat(array99[4][4], is(4));
        assertThat(array99[5][4], is(2));
        assertThat(array99[6][4], is(3));
        assertThat(array99[7][4], is(1));
        assertThat(array99[8][4], is(7));
        assertThat(array99[1][2], is(3));
        assertThat(array99[1][5], is(2));
        assertThat(array99[2][5], is(9));
        assertThat(array99[3][5], is(5));
    }
}
