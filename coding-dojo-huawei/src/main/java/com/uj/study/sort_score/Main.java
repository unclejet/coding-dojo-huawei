package com.uj.study.sort_score;

import com.uj.study.common.SuperMain;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/7 下午12:28
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        ScoreSorterUserInputReader reader = new ScoreSorterUserInputReader(lineReader);
        int stuNum = reader.readStudentNumber();
        SortOrder so = reader.readSortOrder();
        List<Student> studentList = reader.readStudents(stuNum);
        ScoreSorter ss = new ScoreSorter(studentList);
        ss.sortScore(so).stream().forEach(s-> System.out.println(s.printString()));
    }
}
