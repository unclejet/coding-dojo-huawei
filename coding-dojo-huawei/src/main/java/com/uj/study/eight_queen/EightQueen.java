package com.uj.study.eight_queen;

import java.util.Arrays;



/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午9:25
 * @description： In this chapter we make a short interlude to present a simple but complete program in Lua that solves the
 * eight-queen puzzle: its goal is to position eight queens in a chessboard in such a way that no queen can
 * attack another one.
 * <p>
 * A first step to solving the eight-queen puzzle is to note that any valid solution must have exactly one queen
 * in each row. Therefore, we can represent potential solutions with a simple array of eight numbers, one for
 * each row; each number tells at which column is the queen at that row. For instance, the array {3, 7, 2,
 * 1, 8, 6, 5, 4} means that the queens are in the squares (1,3), (2,7), (3,2), (4,1), (5,8), (6,6), (7,5),
 * and (8,4). (By the way, this is not a valid solution; for instance, the queen in square (3,2) can attack the
 * one in square (4,1).) Note that any valid solution must be a permutation of the integers 1 to 8, as a valid
 * solution also must have exactly one queen in each column.
 * <p>
 * 这种局测的思路：
 * 1、一个一个摆上去，一个一个计算符合规则的落位
 */
public class EightQueen {
    public static final int N = 8;
    private static int[] q;

    public static String addQueen() {
        q = new int[N];
        q[0] = 0;
        q[1] = getValidPosition(1);
        addQueenLoop();
        return Arrays.toString(q);
    }

    private static void addQueenLoop() {
        for (int n = 2; n < N; n++) {
            q[n] = getValidPosition(n);
            if (q[n] == -1) {
                q[1] = q[1] + 1;
                addQueenLoop();
            }
        }
    }

    private static int getValidPosition(int nth) {
        for (int c = 0; c < N; c++) {
            if (isPlaceOk(c, nth)) {
                return c;
            }
        }
        return -1;
    }

    private static boolean isPlaceOk(int c, int nth) {
        for (int n = 0; n < nth; n++) {
          if (hadQueen(c) || isDiagonal(nth - 1, c))
                return false;
        }
        return true;
    }

    private static boolean isDiagonal(int previous, int c) {
        int upDiag = q[previous] - 1;
        int downDiag = q[previous] + 1;
        return downDiag == c || upDiag == c;
    }

    private static boolean hadQueen(int queen) {
        return Arrays.stream(q).anyMatch(i -> i == queen);
    }
}
