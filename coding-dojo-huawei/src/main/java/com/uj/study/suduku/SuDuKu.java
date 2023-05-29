package com.uj.study.suduku;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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
public class SuDuKu {

    private static List<MissingNumber> findMissingNumbers(List<Integer> numbers) {
        return IntStream.rangeClosed(1, 9).filter(i -> !numbers.contains(i))
                .mapToObj(MissingNumber::new).collect(Collectors.toList());
    }

    static List<Integer> findRelatedAxisNumbers(Point p, int[][] array) {
        List<Integer> result = new ArrayList<>();
        result.addAll(findHorizontalAxisNumbers(p, array));
        result.addAll(findVerticalAxisNumbers(p, array));
        return new ArrayList<>(new HashSet<>(result));
    }

    private static List<Integer> findVerticalAxisNumbers(Point p, int[][] array) {
        List<Integer> result = new ArrayList<>();
        int row = p.getRow();
        int col = p.getCol();
        for (int i = 0; i < array.length; i++) {
            if (i != row)
                result.add(array[i][col]);
        }
        return result;
    }

    private static List<Integer> findHorizontalAxisNumbers(Point p, int[][] array) {
        List<Integer> result = new ArrayList<>();
        int row = p.getRow();
        int col = p.getCol();
        for (int i = 0; i < array[row].length; i++) {
            if (i != col)
                result.add(array[row][i]);
        }
        return result;
    }


    static List<MissingNumber> findMissingNumbersWithArr3x3(int[][] array33) {
        int[] arr = Stream.of(array33).flatMapToInt(IntStream::of).toArray();
        return IntStream.rangeClosed(1, 9).filter(i -> arrayNotContains(i, arr))
                .mapToObj(MissingNumber::new).collect(Collectors.toList());
    }

    private static boolean arrayNotContains(int i, int[] arr) {
        return Arrays.stream(arr).noneMatch(a -> a == i);
    }

    static List<Point> findPoint0(int[][] array) {
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    result.add(new Point(i, j));
                }
            }
        }
        return result;
    }

    static void fillNumbers(int[][] array) {
        List<Point> points0 = findPoint0(array);
        List<MissingNumber> missingNums = findMissingNumbersWithArr3x3(array);
        points0.forEach(point -> {
            List<Integer> relatedNums = findRelatedAxisNumbers(point, array);
            for (int i = 0; i < missingNums.size(); i++) {
                if (!relatedNums.contains(missingNums.get(i).getValue())) {
                    if (!missingNums.get(i).isUsed()) {
                        array[point.getRow()][point.getCol()] = missingNums.get(i).getValue();
                        missingNums.get(i).setUsed(true);
                        break;
                    }
                }
            }
        });
    }

    public static void sudu(int[][] array) {
        List<Point> points0 = findPoint0(array);
        int size = points0.size();
        while (size > 0) {
            fillPoints0(array, points0);
            points0 = findPoint0(array);
            if (size == points0.size()) {
                Point point = points0.get(0);
                List<MissingNumber> missingNums = findMissingNumbers(array, point);
                array[point.getRow()][point.getCol()] = missingNums.get(0).getValue();
            } else {
                size = points0.size();
            }
        }
    }

    static List<MissingNumber> findMissingNumbers(int[][] array, Point point) {
        List<Integer> relatedNums = findRelatedAxisNumbers(point, array);
        return findMissingNumbers(relatedNums);
    }

    private static void fillPoints0(int[][] array, List<Point> points0) {
        points0.forEach(point -> {
            List<MissingNumber> missingNums = findMissingNumbers(array, point);
            if (missingNums.size() == 1)
                array[point.getRow()][point.getCol()] = missingNums.get(0).getValue();
        });
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }


    }

    static class MissingNumber {
        int value;
        boolean isUsed = false;

        public MissingNumber(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public boolean isUsed() {
            return isUsed;
        }

        public void setUsed(boolean used) {
            isUsed = used;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MissingNumber that = (MissingNumber) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "MissingNumber{" +
                    "isUsed=" + isUsed +
                    "value=" + value + '}';
        }
    }

}
