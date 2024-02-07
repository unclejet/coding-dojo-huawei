package com.uj.study.sort_score;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/4 下午12:57
 * @description：
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String line) {
        String[] arr = line.split("\\s");
        this.name = arr[0];
        this.score = Integer.parseInt(arr[1]);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String printString() {
        return name + " " + score;
    }
}
