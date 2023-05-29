package com.uj.study.suduku;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/5/23 下午12:43
 * @description：
 */
public class SuDuKuUserInputReader extends ValidLineReader {
    public static final int ROW = 9;
    public static final int COL = 9;

    public SuDuKuUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        String[] split = line.split("\\s+");
        return split.length == COL && !Arrays.stream(split).mapToInt(s->getParseInt(s)).anyMatch(i -> (i < 0 || i > 9));
    }

    private Integer getParseInt(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String readLine() {
        return readValidLine("Please input 0-9 in 9x9 array like this: 0 9 2 4 8 1 7 6 3 and each row column number no repeat:");
    }

    List<String> readSuduData() {
        List<String> result = new ArrayList<>();
        int count = 0;
        while (count < ROW) {
            String line = readLine();
            if (dataSatisfyRow(result, line)) {
                result.add(line);
                count++;
            }
        }
        return result;
    }

    public int[][] readSuDu() {
        int[][] maze = new int[ROW][COL];
        List<String> data = readSuduData();
        for (int i = 0; i < ROW; i++) {
            String[] sd = data.get(i).split("\\s+");
            for (int j = 0; j < COL; j++) {
                maze[i][j] = Integer.parseInt(sd[j]);
            }
        }
        return maze;
    }

    private boolean dataSatisfyRow(List<String> data, String line) {
        String[] inputRowData = line.split("\\s+");
        Set<String> s = Stream.of(inputRowData).collect(Collectors.toSet());
        if (isValidRow(s)) {
            for (String d : data)
                if (!isValidColumn(d, inputRowData)) {
                    return false;
                }
            return true;
        }
        System.out.println("Please input data no repeat with each row and each column:");
        return false;
    }

    private boolean isValidRow(Set<String> s) {
        return s.size() == COL;
    }

    private boolean isValidColumn(String data, String[] inputRowData) {
        String[] rowData = data.split("\\s+");
        for (int i = 0; i < COL; i++) {
            if (rowData[i].equals(inputRowData[i]) && !"0".equals(rowData[i]))
                return false;
        }
        return true;
    }
}
