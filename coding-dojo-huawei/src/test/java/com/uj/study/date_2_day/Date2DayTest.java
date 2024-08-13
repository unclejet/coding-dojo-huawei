package com.uj.study.date_2_day;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 描述
 * 根据输入的日期，计算是这一年的第几天。
 * 保证年份为4位数且日期合法。
 * 进阶：时间复杂度：O(n) O(n) ，空间复杂度：O(1) O(1)
 * 输入描述：
 *
 * 输入一行，每行空格分割，分别是年，月，日
 * 输出描述：
 * 输出是这一年的第几天
 * 示例1
 * 输入：
 *
 * 2012 12 31
 *
 * 输出：
 *
 * 366
 *
 * 示例2
 * 输入：
 *
 * 1982 3 4
 *
 * 输出：
 *
 * 63
 */
public class Date2DayTest {
    @Test
    void january() {
        assertThat(date2Day(2012, 1, 1), is(1));
        assertThat(date2Day(2012, 1, 15), is(15));
    }

    @Test
    void february() {
        assertThat(date2Day(2012, 2, 1), is(32));
        assertThat(date2Day(2012, 2, 29), is(60));
        assertThat(date2Day(2013, 3, 1), is(60));
    }

    @Test
    void mixedMonth() {
        assertThat(date2Day(2012, 12, 31), is(366));
        assertThat(date2Day(1982, 3, 4), is(63));

    }

    private int date2Day(int year, int month, int days) {
        if (isInvalidDate(year, month, days)) {
            return -1;
        }

        int daysSum = 0;
        for (int m = 1; m < month; m++) {
            daysSum += getMonthDays(year, m);
        }
        daysSum += days;
        return daysSum;
    }


    private int getMonthDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    private  boolean isInvalidDate(int year, int month, int day) {
        return  year < 1000 || year > 9999 ||
        month < 1 || month > 12 ||
        day < 1 || day > 31;
    }

    private  boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}
