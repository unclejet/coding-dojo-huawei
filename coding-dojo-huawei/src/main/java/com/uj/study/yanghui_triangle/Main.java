package com.uj.study.yanghui_triangle;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/26 下午12:46
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        YangHuiTriangleUserInputReader reader = new YangHuiTriangleUserInputReader(lineReader);
        int row = reader.readRowNumber();
        List<TriangleRowData> triangleRowData = YangHuiTriangle.generateTriangle(row);
        System.out.println(YangHuiTriangle.getFirstEvenNumber(triangleRowData, row));
    }
}
