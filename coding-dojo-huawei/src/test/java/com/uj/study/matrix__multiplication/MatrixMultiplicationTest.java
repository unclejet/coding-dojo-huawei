package com.uj.study.matrix__multiplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/19 下午12:52
 * @description：
 * 描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 *
 * 矩阵的大小不超过100*100
 * 输入描述：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 *
 * 输出描述：
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 * 示例1
 * 输入：
 *
 * 2
 * 3
 * 2
 * 1 2 3
 * 3 2 1
 * 1 2
 * 2 1
 * 3 3
 *
 * 输出：
 *
 * 14 13
 * 10 11
 *
 * 说明：
 *
 * 1 2 3
 * 3 2 1
 * 乘以
 * 1 2
 * 2 1
 * 3 3
 * 等于
 * 14 13
 * 10 11
 *
 * 示例2
 * 输入：
 *
 * 16
 * 8
 * 7
 * 17 19 16 19 14 1 14 9
 * 7 2 7 9 16 14 16 12
 * 13 3 3 17 5 9 8 16
 * 1 14 16 10 13 13 14 1
 * 13 13 15 4 7 2 6 16
 * 16 15 5 5 15 13 1 11
 * 11 5 0 16 14 7 7 15
 * 0 16 4 7 16 6 0 15
 * 2 14 11 2 17 17 5 12
 * 8 13 11 10 1 17 10 8
 * 15 16 17 15 7 8 13 14
 * 5 19 11 3 11 14 5 4
 * 9 16 13 11 15 18 0 3
 * 15 3 19 9 5 14 12 3
 * 9 8 7 11 18 19 14 18
 * 12 19 9 1 0 18 17 10
 * 5 18 16 19 6 12 5
 * 1 17 1 5 9 16 3
 * 14 16 4 0 19 3 6
 * 11 9 15 18 11 17 13
 * 5 5 19 3 16 1 12
 * 12 13 19 1 10 5 18
 * 19 18 6 18 19 12 3
 * 15 11 6 5 10 17 19
 *
 * 输出：
 *
 * 1020 1490 1063 1100 1376 1219 884
 * 966 1035 1015 715 1112 772 920
 * 822 948 888 816 831 920 863
 * 855 1099 828 578 1160 717 724
 * 745 1076 644 595 930 838 688
 * 635 1051 970 600 880 811 846
 * 748 879 952 772 864 872 878
 * 526 722 645 335 763 688 748
 * 764 996 868 362 1026 681 897
 * 836 1125 785 637 940 849 775
 * 1082 1476 996 968 1301 1183 953
 * 609 987 717 401 894 657 662
 * 700 1083 1022 527 1016 746 875
 * 909 1162 905 722 1055 708 720
 * 1126 1296 1240 824 1304 1031 1196
 * 905 1342 766 715 1028 956 749
 */
public class MatrixMultiplicationTest {
    private final MatrixMultiplier matrixMultiplier = new MatrixMultiplier();

    @Test
    void array111() {
        matrixMultiplier.setRow(1);
        matrixMultiplier.setY(1);
        matrixMultiplier.setColumn(1);
        matrixMultiplier.setArrA(new int[]{1});
        matrixMultiplier.setArrB(new int[]{1});
        Assertions.assertArrayEquals(matrixMultiplier.multiply(), new int[] {1});
    }

    @Test
    void array121() {
        matrixMultiplier.setRow(1);
        matrixMultiplier.setY(2);
        matrixMultiplier.setColumn(1);
        matrixMultiplier.setArrA(new int[]{1, 2});
        matrixMultiplier.setArrB(new int[]{2, 1});
        Assertions.assertArrayEquals(new int[] {4}, matrixMultiplier.multiply());
    }

    @Test
    void array131() {
        matrixMultiplier.setRow(1);
        matrixMultiplier.setY(3);
        matrixMultiplier.setColumn(1);
        matrixMultiplier.setArrA(new int[]{1, 2, 3});
        matrixMultiplier.setArrB(new int[]{3, 2, 1});
        Assertions.assertArrayEquals(new int[] {10}, matrixMultiplier.multiply());
    }

    @Test
    void array212() {
        matrixMultiplier.setRow(2);
        matrixMultiplier.setY(1);
        matrixMultiplier.setColumn(2);
        matrixMultiplier.setArrA(new int[]{1, 2});
        matrixMultiplier.setArrB(new int[]{1, 2});
        Assertions.assertArrayEquals(new int[] {1, 2, 2, 4}, matrixMultiplier.multiply());
    }

    @Test
    void array213() {
        matrixMultiplier.setRow(2);
        matrixMultiplier.setY(1);
        matrixMultiplier.setColumn(3);
        matrixMultiplier.setArrA(new int[]{1, 2});
        matrixMultiplier.setArrB(new int[]{1, 2, 3});
        Assertions.assertArrayEquals(new int[] {1, 2, 3, 2, 4, 6}, matrixMultiplier.multiply());
    }

    @Test
    void array313() {
        matrixMultiplier.setRow(3);
        matrixMultiplier.setY(1);
        matrixMultiplier.setColumn(3);
        matrixMultiplier.setArrA(new int[]{1, 2, 3});
        matrixMultiplier.setArrB(new int[]{3, 2, 1});
        Assertions.assertArrayEquals(new int[] {3, 2, 1, 6, 4, 2, 9, 6, 3}, matrixMultiplier.multiply());
    }

    /*
     * 输入：
     *
     * 2
     * 3
     * 2
     * 1 2 3
     * 3 2 1
     * 1 2
     * 2 1
     * 3 3
     *
     * 输出：
     *
     * 14 13
     * 10 11
     *
     */
    @Test
    void array232() {
        matrixMultiplier.setRow(2);
        matrixMultiplier.setY(3);
        matrixMultiplier.setColumn(2);
        matrixMultiplier.setArrA(new int[]{1, 2, 3, 3, 2, 1});
        matrixMultiplier.setArrB(new int[]{1, 2, 2, 1, 3, 3});
        Assertions.assertArrayEquals(new int[] {14, 13, 10, 11}, matrixMultiplier.multiply());
    }

    /*
     * 17 19 16 19 14 1 14 9
     * 7 2 7 9 16 14 16 12
     * 13 3 3 17 5 9 8 16
     * 1 14 16 10 13 13 14 1
     * 13 13 15 4 7 2 6 16
     * 16 15 5 5 15 13 1 11
     * 11 5 0 16 14 7 7 15
     * 0 16 4 7 16 6 0 15
     * 2 14 11 2 17 17 5 12
     * 8 13 11 10 1 17 10 8
     * 15 16 17 15 7 8 13 14
     * 5 19 11 3 11 14 5 4
     * 9 16 13 11 15 18 0 3
     * 15 3 19 9 5 14 12 3
     * 9 8 7 11 18 19 14 18
     * 12 19 9 1 0 18 17 10
     * 5 18 16 19 6 12 5
     * 1 17 1 5 9 16 3
     * 14 16 4 0 19 3 6
     * 11 9 15 18 11 17 13
     * 5 5 19 3 16 1 12
     * 12 13 19 1 10 5 18
     * 19 18 6 18 19 12 3
     * 15 11 6 5 10 17 19
     *
     * 输出：
     *
     * 1020 1490 1063 1100 1376 1219 884
     * 966 1035 1015 715 1112 772 920
     * 822 948 888 816 831 920 863
     * 855 1099 828 578 1160 717 724
     * 745 1076 644 595 930 838 688
     * 635 1051 970 600 880 811 846
     * 748 879 952 772 864 872 878
     * 526 722 645 335 763 688 748
     * 764 996 868 362 1026 681 897
     * 836 1125 785 637 940 849 775
     * 1082 1476 996 968 1301 1183 953
     * 609 987 717 401 894 657 662
     * 700 1083 1022 527 1016 746 875
     * 909 1162 905 722 1055 708 720
     * 1126 1296 1240 824 1304 1031 1196
     * 905 1342 766 715 1028 956 749
     */
    @Test
    void array16_8_7() {
        matrixMultiplier.setRow(16);
        matrixMultiplier.setY(8);
        matrixMultiplier.setColumn(7);
        matrixMultiplier.setArrA(new int[]{17, 19, 16, 19, 14, 1, 14, 9,
                7, 2, 7, 9, 16, 14, 16, 12,
                13, 3, 3, 17, 5, 9, 8, 16,
                1, 14, 16, 10, 13, 13, 14, 1,
                13, 13, 15, 4, 7, 2, 6, 16,
                16, 15, 5, 5, 15, 13, 1, 11,
                11, 5, 0, 16, 14, 7, 7, 15,
                0, 16, 4, 7, 16, 6, 0, 15,
                2, 14, 11, 2, 17, 17, 5, 12,
                8, 13, 11, 10, 1, 17, 10, 8,
                15, 16, 17, 15, 7, 8, 13, 14,
                5, 19, 11, 3, 11, 14, 5, 4,
                9, 16, 13, 11, 15, 18, 0, 3,
                15, 3, 19, 9, 5, 14, 12, 3,
                9, 8, 7, 11, 18, 19, 14, 18,
                12, 19, 9, 1, 0, 18, 17, 10
        });
        matrixMultiplier.setArrB(new int[]{5, 18, 16, 19, 6, 12, 5,
                1, 17, 1, 5, 9, 16, 3,
                14, 16, 4, 0, 19, 3, 6,
                11, 9, 15, 18, 11, 17, 13,
                5, 5, 19, 3, 16, 1, 12,
                12, 13, 19, 1, 10, 5, 18,
                19, 18, 6, 18, 19, 12, 3,
                15, 11, 6, 5, 10, 17, 19
        });
        Assertions.assertArrayEquals(new int[]{
                1020, 1490, 1063, 1100, 1376, 1219, 884,
                966, 1035, 1015, 715, 1112, 772, 920,
                822, 948, 888, 816, 831, 920, 863,
                855, 1099, 828, 578, 1160, 717, 724,
                745, 1076, 644, 595, 930, 838, 688,
                635, 1051, 970, 600, 880, 811, 846,
                748, 879, 952, 772, 864, 872, 878,
                526, 722, 645, 335, 763, 688, 748,
                764, 996, 868, 362, 1026, 681, 897,
                836, 1125, 785, 637, 940, 849, 775,
                1082, 1476, 996, 968, 1301, 1183, 953,
                609, 987, 717, 401, 894, 657, 662,
                700, 1083, 1022, 527, 1016, 746, 875,
                909, 1162, 905, 722, 1055, 708, 720,
                1126, 1296, 1240, 824, 1304, 1031, 1196,
                905, 1342, 766, 715, 1028, 956, 749
        }, matrixMultiplier.multiply());
    }
}
