package com.uj.study.maze;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/4/7 下午12:57
 * @description：
 */
public class MazeProblemUserInputReader {
    private MazeSizeReader mazeSizeReader;
    private MazeLineReader mazeLineReader;

    public MazeProblemUserInputReader(LineReader lineReader) {
        mazeSizeReader = new MazeSizeReader(lineReader);
        mazeLineReader = new MazeLineReader(lineReader);
    }

    int[] readMazeSize() {
        return mazeSizeReader.readMazeSize();
    }

    String[] readMazeLine(int length) {
        return mazeLineReader.readMazeLine(length);
    }

    public int[][] readMaze() {
        int[] size = readMazeSize();
        int row = size[0];
        int col = size[1];
        int[][] maze = new int[row][col];
        List<String> data = readMazeData(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = Integer.parseInt(data.get(i * maze.length + j));
            }
        }
        return maze;
    }

    List<String> readMazeData(int row, int col) {
        List<String> result = new ArrayList<>();
        int count = 0;
        while (count++ < row) {
            String[] data = readMazeLine(col);
            result.addAll(Arrays.asList(data));
        }
        return result;
    }

    class MazeLineReader extends ValidLineReader {
        private int length;

        public MazeLineReader(LineReader lineReader) {
            super(lineReader);
        }

        private String[] readMazeLine(int length) {
            this.length = length;
            String line = readValidLine("Please input maze data use 0 or 1  and length = " + length);
            return line.split("\\s+");
        }

        @Override
        protected boolean isValidString(String line) {
            return line.matches("[01\\s]+") &&
                    line.split("\\s+").length == length;
        }
    }

    class MazeSizeReader extends ValidLineReader {

        public MazeSizeReader(LineReader lineReader) {
            super(lineReader);
        }

        private int[] readMazeSize() {
            return StrArr2IntArr(readValidLine("please input maze size like 5 5"));
        }

        @Override
        protected boolean isValidString(String line) {
            int[] size = StrArr2IntArr(line);
            return size != null && size.length == 2 && size[0] >= 2 && size[1] <= 10;
        }

        private int[] StrArr2IntArr(String line) {
            try {
                return Arrays.stream(line.split("\\p{Space}")).mapToInt(Integer::parseInt).toArray();
            } catch (Exception e) {
                return null;
            }
        }
    }
}
