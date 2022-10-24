package com.uj.study.picture_arrange;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/24 下午12:13
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        PictureUserInputReader reader = new PictureUserInputReader(lineReader);
        System.out.println(AscIISorter.sortASCII(reader.readPictures()));
    }
}
