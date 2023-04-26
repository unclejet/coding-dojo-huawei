package com.uj.study.extract.nonrepeat.integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author ：unclejet
 * @date ：Created in 2020/8/15 上午11:31
 * @description：
 * * 题目描述
 *  * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *  * 保证输入的整数最后一位不是0。
 *  *
 *  * 输入描述:
 *  * 输入一个int型整数
 *  *
 *  * 输出描述:
 *  * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *  *
 *  * 示例1
 *  * 输入
 *  * 复制
 *  * 9876673
 *  * 输出
 *  * 复制
 *  * 37689
 * @modified By：
 * @version:
 */
class NonRepeatExtractorTest {

    @Test
    void extract() {
        NonRepeatExtractor extractor = new NonRepeatExtractor();
        int input = 9876673;
        assertEquals(37689, extractor.extract(input));
        input = 4354343;
        assertEquals(345, extractor.extract(input));
    }
}