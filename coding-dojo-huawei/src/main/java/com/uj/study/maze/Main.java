package com.uj.study.maze;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/4/26 下午12:12
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        MazeProblemUserInputReader reader = new MazeProblemUserInputReader(lineReader);
        int[][] maze = reader.readMaze();
        MazeProblem mp = new MazeProblem(maze);
        System.out.println(mp.wayOut());
    }
}
