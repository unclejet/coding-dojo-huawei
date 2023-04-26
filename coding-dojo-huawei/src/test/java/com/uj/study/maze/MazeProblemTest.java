package com.uj.study.maze;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/3/10 下午12:30
 * @description： 描述
 * <p>
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 * <p>
 * <p>
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * <p>
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 * <p>
 * 数据范围： 2≤n,m≤10 2≤n,m≤10  ， 输入的内容只包含 0≤val≤1 0≤val≤1
 * 输入描述：
 * <p>
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * 输出描述：
 * <p>
 * 左上角到右下角的最短路径，格式如样例所示。
 * 示例1
 * 输入：
 * <p>
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * <p>
 * 输出：
 * <p>
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 * <p>
 * 示例2
 * 输入：
 * <p>
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 1
 * 0 1 1 1 0
 * 0 0 0 0 0
 * <p>
 * 输出：
 * <p>
 * (0,0)
 * (1,0)
 * (2,0)
 * (3,0)
 * (4,0)
 * (4,1)
 * (4,2)
 * (4,3)
 * (4,4)
 * <p>
 * 说明：
 * <p>
 * 注意：不能斜着走！！
 */
public class MazeProblemTest {
    private MazeProblem mazeProblem;



    private int maze[][];
//    private List<String> result;

    @Test
    void maze_2_2() {
        mazeProblem = new MazeProblem(new int[][]{{0, 0}, {0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(1,1)"));
        mazeProblem = new MazeProblem(new int[][]{{0, 1}, {0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(1,1)"));
        mazeProblem = new MazeProblem(new int[][]{{0, 0}, {1, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(0,1)", "(1,1)"));
    }


    @Test
    void maze_3_3() {
        mazeProblem = new MazeProblem(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(2,0)", "(2,1)", "(2,2)"));
        mazeProblem = new MazeProblem(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(2,0)", "(2,1)", "(2,2)"));
        mazeProblem = new MazeProblem(new int[][]{{0, 0, 1}, {0, 0, 0}, {0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(2,0)", "(2,1)", "(2,2)"));
        mazeProblem = new MazeProblem(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(0,1)", "(1,1)", "(2,1)", "(2,2)"));
        mazeProblem = new MazeProblem(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(0,1)", "(0,2)", "(1,2)", "(2,2)"));
        mazeProblem = new MazeProblem(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(0,1)", "(1,1)", "(2,1)", "(2,2)"));
    }


    @Test
    void maze_5_5() {
        mazeProblem = new MazeProblem(new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(2,0)", "(3,0)", "(4,0)", "(4,1)", "(4,2)", "(4,3)", "(4,4)"));

        mazeProblem = new MazeProblem(new int[][]{{0, 1, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(2,0)", "(2,1)", "(2,2)", "(2,3)", "(2,4)", "(3,4)", "(4,4)"));

        mazeProblem = new MazeProblem(new int[][]{{0, 1, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}});
        assertThat(mazeProblem.wayOut(), contains("(0,0)", "(1,0)", "(2,0)", "(3,0)", "(4,0)", "(4,1)", "(4,2)", "(4,3)", "(4,4)"));
    }

//    private List<String> wayOut() {
//        return findPath(0, 0);
//    }
//
//    private List<String> findPath(int startRow, int startCol) {
//        List<String> result = new ArrayList<>();
//        for (int i = startRow, nextCol = startCol; i < maze.length; i++) {
//            for (int j = nextCol; j < maze[i].length; j++) {
//                if (isTurning(i, j)) {
//                    result.add(String.format("(%d,%d)", i, j));
//                    List<String> exploreDown = findPath(i + 1, j);
//                    if (exploreDown.contains(String.format("(%d,%d)", maze.length - 1, maze[0].length - 1))) {
//                        result.addAll(exploreDown);
//                        return result;
//                    }
//                    List<String> exploreRight = findPath(i, j + 1);
//                    result.addAll(exploreRight);
//                    return result;
//                }
//                else if (maze[i][j] == 0) {
//                    result.add(String.format("(%d,%d)", i, j));
//                    nextCol = j;
//                }
//                if (j + 1 < maze.length && maze[i][j + 1] == 1) {
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean isTurning(int i, int j) {
//        return i < maze.length - 1 && j < maze.length - 1 &&
//                maze[i][j + 1] == 0 && maze[i + 1][j] == 0;
//    }
}
