package com.uj.study.sort_score;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/5 下午12:49
 * @description：
 * * 数据范围：人数：1≤n≤200 1≤n≤200
 *  * 进阶：时间复杂度：O(nlogn) O(nlogn) ，空间复杂度：O(n) O(n)
 *  * 输入描述：
 *  * <p>
 *  * 第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开
 *  * 输出描述：
 *  * <p>
 *  * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *  * 示例1
 *  * 输入：
 *  * <p>
 *  * 3
 *  * 0
 *  * fang 90
 *  * yang 50
 *  * ning 70
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * fang 90
 *  * ning 70
 *  * yang 50
 *  * <p>
 */
public class ScoreSorterUserInputReaderTest extends BaseUserInputReaderTest {
    private ScoreSorterUserInputReader reader;


    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new ScoreSorterUserInputReader(lineReaderStub);
    }

    @Test
    void student_number_isValid() {
        lineReaderStub.simulateUserInputs("a", "0", "201", "200");
        assertThat(reader.readStudentNumber(), is(200));
    }

    @Test
    void sort_order_check() {
        lineReaderStub.simulateUserInputs("f", "2", "-1", "0");
        assertThat(reader.readSortOrder(), is(SortOrder.DESC));
        lineReaderStub.simulateUserInputs("1");
        assertThat(reader.readSortOrder(), is(SortOrder.ASC));
    }

    @Test
    void student_list_read() {
        lineReaderStub.simulateUserInputs("name score", "name1$70", "70", "name1 70", "name2 80", "name3 90");
        List<Student> studentList = reader.readStudents(2);
        assertThat(studentList.size(), is(2));
        assertThat(studentList.get(0).getScore(), is(70));
        assertThat(studentList.get(1).getName(), is("name2"));
    }
}
