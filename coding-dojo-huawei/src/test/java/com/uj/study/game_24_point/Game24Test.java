package com.uj.study.game_24_point;

import org.junit.jupiter.api.Test;

import static com.uj.study.game_24_point.Game24.group;
import static com.uj.study.game_24_point.Game24.has24;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/30 下午12:49
 * @description：
 * 描述
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
 * 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
 * 输入描述：
 *
 * 读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 * 输出描述：
 *
 * 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 * 示例1
 * 输入：
 *
 * 7 2 1 10
 *
 * 输出：
 *
 * true
 */
public class Game24Test {

    @Test
    void check_group() {
        PairGroup[] pgs = group(new int[]{7, 2, 1, 10});
        
        assertThat(pgs.length, is(3));
        assertThat(pgs[0].getGroup1().getBig(), is(7));
        assertThat(pgs[0].getGroup1().getSmall(), is(2));
        assertThat(pgs[0].getGroup2().getBig(), is(10));
        assertThat(pgs[0].getGroup2().getSmall(), is(1));

        assertThat(pgs[1].getGroup1().getBig(), is(7));
        assertThat(pgs[1].getGroup1().getSmall(), is(1));
        assertThat(pgs[1].getGroup2().getBig(), is(10));
        assertThat(pgs[1].getGroup2().getSmall(), is(2));

        assertThat(pgs[2].getGroup1().getBig(), is(10));
        assertThat(pgs[2].getGroup1().getSmall(), is(7));
        assertThat(pgs[2].getGroup2().getBig(), is(2));
        assertThat(pgs[2].getGroup2().getSmall(), is(1));
    }

    @Test
    void check_24() {
        assertThat(has24(new int[]{7, 2, 1, 10}), is(true));
        assertThat(has24(new int[]{3, 3, 4, 4}), is(true));
        assertThat(has24(new int[]{1, 2, 3, 4}), is(false));
    }
}
