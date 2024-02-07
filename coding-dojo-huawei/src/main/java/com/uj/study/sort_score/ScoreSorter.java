package com.uj.study.sort_score;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreSorter {
    private List<Student> students;

    public ScoreSorter(List<Student> students) {
        this.students = students;
    }

    List<Student> sortScore(SortOrder order) {
        if (SortOrder.ASC.equals(order))
            return students.stream().sorted(Comparator.comparingInt(Student::getScore)).collect(Collectors.toList());
        else if (SortOrder.DESC.equals(order))
            return students.stream().sorted(Comparator.comparingInt(Student::getScore).reversed()).collect(Collectors.toList());
        return students;
    }
}