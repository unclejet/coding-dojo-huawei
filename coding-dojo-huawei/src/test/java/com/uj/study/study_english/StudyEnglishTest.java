package com.uj.study.study_english;

import org.junit.jupiter.api.Test;

import static com.uj.study.study_english.StudyEnglish.englishNumber;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/20 上午11:59
 * @description： 描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 * <p>
 * 具体规则如下:
 * 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
 * 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
 * 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
 * 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
 * <p>
 * 下面再看几个数字例句：
 * 22: twenty two
 * 100:  one hundred
 * 145:  one hundred and forty five
 * 1,234:  one thousand two hundred and thirty four
 * 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
 * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
 * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
 * <p>
 * 说明：
 * 数字为正整数，不考虑小数，转化结果为英文小写；
 * 保证输入的数据合法
 * 关键字提示：and，billion，million，thousand，hundred。
 * <p>
 * 数据范围：1≤n≤2000000 1≤n≤2000000 
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入一个long型整数
 * 输出描述：
 * <p>
 * 输出相应的英文写法
 * 示例1
 * 输入：
 * <p>
 * 22
 * <p>
 * 输出：
 * <p>
 * twenty two
 */
public class StudyEnglishTest {
    @Test
    void unitDigit() {
        assertThat(englishNumber("0"), is("zero"));
        assertThat(englishNumber("1"), is("one"));
        assertThat(englishNumber("2"), is("two"));
        assertThat(englishNumber("3"), is("three"));
        assertThat(englishNumber("4"), is("four"));
        assertThat(englishNumber("5"), is("five"));
        assertThat(englishNumber("6"), is("six"));
        assertThat(englishNumber("7"), is("seven"));
        assertThat(englishNumber("8"), is("eight"));
        assertThat(englishNumber("9"), is("nine"));
    }

    @Test
    void tensDigit() {
        assertThat(englishNumber("10"), is("ten"));
        assertThat(englishNumber("11"), is("eleven"));
        assertThat(englishNumber("12"), is("twelve"));
        assertThat(englishNumber("13"), is("thirteen"));
        assertThat(englishNumber("14"), is("fourteen"));
        assertThat(englishNumber("15"), is("fifteen"));
        assertThat(englishNumber("16"), is("sixteen"));
        assertThat(englishNumber("17"), is("seventeen"));
        assertThat(englishNumber("18"), is("eighteen"));
        assertThat(englishNumber("19"), is("nineteen"));

        assertThat(englishNumber("20"), is("twenty"));
        assertThat(englishNumber("21"), is("twenty one"));
        assertThat(englishNumber("29"), is("twenty nine"));
        assertThat(englishNumber("30"), is("thirty"));
        assertThat(englishNumber("32"), is("thirty two"));
        assertThat(englishNumber("40"), is("forty"));
        assertThat(englishNumber("43"), is("forty three"));
        assertThat(englishNumber("54"), is("fifty four"));
        assertThat(englishNumber("65"), is("sixty five"));
        assertThat(englishNumber("76"), is("seventy six"));
        assertThat(englishNumber("87"), is("eighty seven"));
        assertThat(englishNumber("98"), is("ninety eight"));
    }

    @Test
    void hundredsDigit() {
        assertThat(englishNumber("100"), is("one hundred"));
        assertThat(englishNumber("200"), is("two hundred"));
        assertThat(englishNumber("101"), is("one hundred and one"));
        assertThat(englishNumber("145"), is("one hundred and forty five"));
    }

    @Test
    void thousandsDigit() {
        //4 figures
        assertThat(englishNumber("1000"), is("one thousand"));
        assertThat(englishNumber("2000"), is("two thousand"));
        assertThat(englishNumber("1234"), is("one thousand two hundred and thirty four"));
        assertThat(englishNumber("8088"), is("eight thousand eighty eight"));
        //5 figures
        assertThat(englishNumber("10000"), is("ten thousand"));
        assertThat(englishNumber("11000"), is("eleven thousand"));
        assertThat(englishNumber("22000"), is("twenty two thousand"));
        assertThat(englishNumber("22001"), is("twenty two thousand one"));
        assertThat(englishNumber("22101"), is("twenty two thousand one hundred and one"));
        //6 figures
        assertThat(englishNumber("100000"), is("one hundred thousand"));
        assertThat(englishNumber("101000"), is("one hundred and one thousand"));
        assertThat(englishNumber("888088"), is("eight hundred and eighty eight thousand eighty eight"));
        assertThat(englishNumber("486669"), is("four hundred and eighty six thousand six hundred and sixty nine"));
    }

    @Test
    void millionsDigit() {
        //7 figures
        assertThat(englishNumber("1000000"), is("one million"));
        assertThat(englishNumber("2000000"), is("two million"));
        assertThat(englishNumber("2345000"), is("two million three hundred and forty five thousand"));
        assertThat(englishNumber("2345678"), is("two million three hundred and forty five thousand six hundred and seventy eight"));
        assertThat(englishNumber("1652510"), is("one million six hundred and fifty two thousand five hundred and ten"));
        assertThat(englishNumber("1652001"), is("one million six hundred and fifty two thousand one"));
        //8 figures
        assertThat(englishNumber("11652001"), is("eleven million six hundred and fifty two thousand one"));
        //9 figures
        assertThat(englishNumber("117345678"), is("one hundred and seventeen million three hundred and forty five thousand six hundred and seventy eight"));
    }

    @Test
    void billionDigit() {
        //1,000,000,000 - 321,000,000,000

        //10 figures
        assertThat(englishNumber("1000000000"), is("one billion"));
        assertThat(englishNumber("4000000000"), is("four billion"));
        assertThat(englishNumber("4567000000"), is("four billion five hundred and sixty seven million"));
        assertThat(englishNumber("4567892351"), is("four billion five hundred and sixty seven million eight hundred and ninety two thousand three hundred and fifty one"));
        //11 figures
        assertThat(englishNumber("24567000000"), is("twenty four billion five hundred and sixty seven million"));
        //12 figures
        assertThat(englishNumber("479117345078"), is("four hundred and seventy nine billion one hundred and seventeen million three hundred and forty five thousand seventy eight"));
    }
}
