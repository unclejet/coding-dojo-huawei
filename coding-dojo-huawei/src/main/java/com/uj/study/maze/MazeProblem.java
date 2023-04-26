package com.uj.study.maze;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/4/23 下午12:53
 * @description：
 */
public class MazeProblem {
    private int maze[][];

    public MazeProblem(int[][] maze) {
        this.maze = maze;
    }

    public List<String> wayOut() {
        return findPath(0, 0);
    }

    private List<String> findPath(int startRow, int startCol) {
        List<String> result = new ArrayList<>();
        for (int i = startRow, nextCol = startCol; i < maze.length; i++) {
            for (int j = nextCol; j < maze[i].length; j++) {
                if (isTurning(i, j)) {
                    result.add(String.format("(%d,%d)", i, j));
                    List<String> exploreDown = findPath(i + 1, j);
                    if (exploreDown.contains(String.format("(%d,%d)", maze.length - 1, maze[0].length - 1))) {
                        result.addAll(exploreDown);
                        return result;
                    }
                    List<String> exploreRight = findPath(i, j + 1);
                    result.addAll(exploreRight);
                    return result;
                }
                else if (maze[i][j] == 0) {
                    result.add(String.format("(%d,%d)", i, j));
                    nextCol = j;
                }
                if (j + 1 < maze.length && maze[i][j + 1] == 1) {
                    break;
                }
            }
        }
        return result;
    }

    private boolean isTurning(int i, int j) {
        return i < maze.length - 1 && j < maze.length - 1 &&
                maze[i][j + 1] == 0 && maze[i + 1][j] == 0;
    }
}
