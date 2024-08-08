package com.uj.study.bai_qian_bai_ji;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 描述
 * 公元五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 现要求你打印出所有花一百元买一百只鸡的方式。
 * 输入描述：
 *
 * 输入任何一个整数，即可运行程序。
 * 输出描述：
 *
 *  输出有数行，每行三个整数，分别代表鸡翁，母鸡，鸡雏的数量
 * 示例1
 * 输入：
 *
 * 1
 *
 * 输出：
 *
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 */
public class BuyChickenTest {
    @Test
    void buyChickenTest() {
        assertArrayEquals(buyChicken(), new int[]{0, 25, 75, 4, 18, 78, 8, 11, 81, 12, 4, 84});
    }

    public static final int TOTAL_MONEY = 100;
    public static final int TOTAL_CHICKEN = 100;
    public static final int COCK_PRICE = 5;
    public static final int HEN_PRICE = 3;

    private int[] buyChicken() {
        int[] result = new int[12];
        int c = 0;
        for (int cock = 0; cock <= TOTAL_MONEY / COCK_PRICE; cock++) {
            for (int hen = 0; hen <= (TOTAL_MONEY - cock * COCK_PRICE) / HEN_PRICE; hen++) {
                int chick = TOTAL_CHICKEN - cock - hen;
                if (cock * COCK_PRICE + hen * HEN_PRICE + (chick / 3.0) == TOTAL_MONEY) {
                    result[c] = cock;
                    result[c + 1] = hen;
                    result[c + 2] = chick;
                    c = c + 3;
                }
            }
        }
        return result;
    }
}
