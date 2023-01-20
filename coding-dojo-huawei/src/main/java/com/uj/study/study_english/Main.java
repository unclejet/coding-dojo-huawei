package com.uj.study.study_english;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午9:19
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        StudyEnglishUserInputReader reader = new StudyEnglishUserInputReader(lineReader);
        System.out.println(StudyEnglish.englishNumber(reader.readNumber()));
    }
}
