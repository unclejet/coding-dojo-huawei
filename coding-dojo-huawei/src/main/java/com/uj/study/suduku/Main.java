package com.uj.study.suduku;

import com.uj.study.common.input.LineReader;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/5/29 下午12:34
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        SuDuKuUserInputReader reader = new SuDuKuUserInputReader(lineReader);
        int[][] data = reader.readSuDu();
        SuDuKu.sudu(data);
        for (int[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }
}
