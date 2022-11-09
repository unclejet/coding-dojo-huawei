package com.uj.study.snake_array;


import java.util.stream.IntStream;



/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/24 下午12:16
 * @description： 描述
 * <p>
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入5时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * <p>
 * 2 5 9 14
 * <p>
 * 4 8 13
 * <p>
 * 7 12
 * 11
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入正整数N（N不大于100）
 * 输出描述：
 * <p>
 * 输出一个N行的蛇形矩阵。
 * 示例1
 * 输入：
 * <p>
 * 4
 * <p>
 * 输出：
 * <p>
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class SnakeArrayGenerator {

    public static String printSnakeArray(int count) {
        return formatUTM(count, generateUTM(count));
    }

    static String formatUTM(int count, int[] utm) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0, rowStartIndex = 0, rowLength = count; row < count; row++, rowStartIndex += rowLength, --rowLength) {
            for (int col = rowStartIndex; col < rowLength + rowStartIndex; col++)
                sb.append(utm[col] + " ");
            sb.append("\n");
        }
        sb.delete(sb.length() - 2, sb.length()); //delete last \n and white space
        return sb.toString();
    }

    static int[] generateUTM(int count) {
        int[] utm = new int[IntStream.rangeClosed(1, count).reduce(Integer::sum).getAsInt()];
        int lastElement;
        int lastRowStartElement = 1;
        for (int row = 0, colInc = 0, rowStartIdx = 0, rowLength = count, rowIncFactor = 2;
             row < count;
             row++, colInc += 1, rowStartIdx += rowLength, --rowLength, rowIncFactor++) {
            //handle first column(each row start element)
            utm[rowStartIdx] = lastRowStartElement + colInc;
            lastElement = utm[rowStartIdx];
            lastRowStartElement = utm[rowStartIdx];
            //handle each row except first element.
            for (int col = rowStartIdx + 1, rowInc = rowIncFactor; col < rowLength + rowStartIdx; col++, rowInc += 1) {
                utm[col] = lastElement + rowInc;
                lastElement = utm[col];
            }
        }
        return utm;
    }
}
