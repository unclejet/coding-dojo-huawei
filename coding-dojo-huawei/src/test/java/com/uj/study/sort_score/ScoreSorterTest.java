package com.uj.study.sort_score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/4 下午12:49
 * @description： 描述
 * <p>
 * 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩
 * <p>
 * 都按先录入排列在前的规则处理。
 * <p>
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 * <p>
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 * <p>
 * 从低到高
 * <p>
 * smith     67
 * <p>
 * jack      70
 * Tom       70
 * peter     96
 * <p>
 * 注：0代表从高到低，1代表从低到高
 * <p>
 * 数据范围：人数：1≤n≤200 1≤n≤200
 * 进阶：时间复杂度：O(nlogn) O(nlogn) ，空间复杂度：O(n) O(n)
 * 输入描述：
 * <p>
 * 第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开
 * 输出描述：
 * <p>
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 * 示例1
 * 输入：
 * <p>
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * <p>
 * 输出：
 * <p>
 * fang 90
 * ning 70
 * yang 50
 * <p>
 * 示例2
 * 输入：
 * <p>
 * 3
 * 1
 * fang 90
 * yang 50
 * ning 70
 * <p>
 * 输出：
 * <p>
 * yang 50
 * ning 70
 * fang 90
 */
public class ScoreSorterTest {
    Student fang = new Student("fang", 90);
    Student yang = new Student("yang", 50);
    Student ning = new Student("ning", 70);
    Student jack = new Student("jack", 70);
    Student peter = new Student("peter", 96);
    Student tom = new Student("Tom", 70);
    Student smith = new Student("smith", 67);

    @Test
    void sort_student_asc() {
        List<Student> students = new ArrayList<>();
        students.add(fang);
        students.add(yang);
        ScoreSorter scoreSorter = new ScoreSorter(students);
        assertThat(scoreSorter.sortScore(SortOrder.ASC), contains(yang, fang));
    }

    @Test
    void sort_student_desc() {
        List<Student> students = new ArrayList<>();
        students.add(jack);
        students.add(peter);
        students.add(tom);
        students.add(smith);
        ScoreSorter scoreSorter = new ScoreSorter(students);
        assertThat(scoreSorter.sortScore(SortOrder.DESC), contains(peter, jack, tom, smith));
    }
}
