package com.uj.study.beauty_name;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/19 下午12:38
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        BeautifulNameUserInputReader reader = new BeautifulNameUserInputReader(lineReader);
        List<String> contentList = reader.readLinesContent(reader.readLinesNumber());
        for (String line :
                contentList) {
            System.out.println(BeautifulName.countChars(line));
        }
    }
}
