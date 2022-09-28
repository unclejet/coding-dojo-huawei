package com.uj.study.password_interception;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/8/16 下午12:28
 * @description：
 * 描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 数据范围：字符串长度满足 1≤n≤2500 1 \le n \le 2500 \ 1≤n≤2500
 * 输入描述：
 *
 * 输入一个字符串（字符串的长度不超过2500）
 * 输出描述：
 *
 * 返回有效密码串的最大长度
 * 示例1
 * 输入：
 *
 * ABBA
 *
 * 输出：
 *
 * 4
 *
 * 示例2
 * 输入：
 *
 * ABBBA
 *
 * 输出：
 *
 * 5
 *
 * 示例3
 * 输入：
 *
 * 12HHHHA
 *
 * 输出：
 *
 * 4
 */
public class PasswordInterceptionTest {
    private final SymmetryFinder symmetryFinder = new SymmetryFinder();

    @Test
    void symmetry_1() {
        //长度为1
        assertThat(symmetryFinder.findMaxSymmetryLength("A"), is(0));
    }

    @Test
    void symmetry_2() {
        assertThat(symmetryFinder.findMaxSymmetryLength("AA"), is(2));
        assertThat(symmetryFinder.findMaxSymmetryLength("AB"), is(0));
    }

    @Test
    //奇数个元素
    void symmetry_3() {
        //一种元素
        assertThat(symmetryFinder.findMaxSymmetryLength("AAA"), is(3));
//        //两种元素
        assertThat(symmetryFinder.findMaxSymmetryLength("AAB"), is(2));
        assertThat(symmetryFinder.findMaxSymmetryLength("BAA"), is(2));
        assertThat(symmetryFinder.findMaxSymmetryLength("ABA"), is(3));
//        //三种元素
        assertThat(symmetryFinder.findMaxSymmetryLength("ABC"), is(0));
    }

    @Test
    //偶数个元素
    void symmetry_4() {
        //一种元素
        assertThat(symmetryFinder.findMaxSymmetryLength("AAAA"), is(4));
        //两种元素
        assertThat(symmetryFinder.findMaxSymmetryLength("AAAB"), is(3));
        assertThat(symmetryFinder.findMaxSymmetryLength("AABA"), is(3));
        assertThat(symmetryFinder.findMaxSymmetryLength("ABAA"), is(3));
        assertThat(symmetryFinder.findMaxSymmetryLength("BAAA"), is(3));
        assertThat(symmetryFinder.findMaxSymmetryLength("AABB"), is(2));
        assertThat(symmetryFinder.findMaxSymmetryLength("ABBA"), is(4));
        assertThat(symmetryFinder.findMaxSymmetryLength("BBAA"), is(2));
        //三种元素
        assertThat(symmetryFinder.findMaxSymmetryLength("AABC"), is(2));
        assertThat(symmetryFinder.findMaxSymmetryLength("ABAC"), is(3));
        assertThat(symmetryFinder.findMaxSymmetryLength("ABCA"), is(0));
        assertThat(symmetryFinder.findMaxSymmetryLength("BACA"), is(3));
        assertThat(symmetryFinder.findMaxSymmetryLength("BCAA"), is(2));
        assertThat(symmetryFinder.findMaxSymmetryLength("BAAC"), is(2));
        //四种元素
        assertThat(symmetryFinder.findMaxSymmetryLength("ABCD"), is(0));
    }

    @Test
    void  entirety_test() {
        assertThat(symmetryFinder.findMaxSymmetryLength("123321"), is(6));
        assertThat(symmetryFinder.findMaxSymmetryLength("12ABBA"), is(4));
        assertThat(symmetryFinder.findMaxSymmetryLength("ABAKK"), is(3));
        assertThat(symmetryFinder.findMaxSymmetryLength("51233214"), is(6));
        assertThat(symmetryFinder.findMaxSymmetryLength("abaaab"), is(5));
        assertThat(symmetryFinder.findMaxSymmetryLength("ABBBA"), is(5));
        assertThat(symmetryFinder.findMaxSymmetryLength("12HHHHA"), is(4));
    }
}
