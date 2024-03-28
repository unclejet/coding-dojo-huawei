package com.uj.study.matrix__multiplication;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/4 下午12:41
 * @description：
 * *  * 输出描述：
 *  *  * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 *  *  * 示例1
 *  *  * 输入：
 *  *  *
 *  *  * 2
 *  *  * 3
 *  *  * 2
 *  *  * 1 2 3
 *  *  * 3 2 1
 *  *  * 1 2
 *  *  * 2 1
 *  *  * 3 3
 *  *  *
 *  *  * 输出：
 *  *  *
 *  *  * 14 13
 *  *  * 10 11
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        MatrixMultiUserReader reader = new MatrixMultiUserReader(lineReader);
        MatrixMultiplier mm = new MatrixMultiplier();
        int row = reader.readRow();
        int y = reader.readY();
        int column = reader.readColumn();
        mm.setRow(row);
        mm.setColumn(column);
        mm.setY(y);
        mm.setArrA(reader.readArrA(row, y));
        mm.setArrB(reader.readArrB(y, column));
        int[] result = mm.multiply();
        for (int i = 0; i < result.length; i++) {
            if (i % column == 0) {
                System.out.println("");
            }
            System.out.print(result[i] + " ");

        }
    }
}
