package com.uj.study.true_fractions_into_egyptian_fractions;

import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 描述
 * 定义分子为 1 的分数为埃及分数，例如 12,110021​,1001​ 等。
 * 现在，对于给定的一个分子小于分母的分数 abba​，请将其分解为若干个不同的埃及分数之和。随后，使用 1/b1+1/b2+⋯+1/bn1/b1​+1/b2​+⋯+1/bn​ 的格式输出结果，其中，b1,b2,…,bnb1​,b2​,…,bn​ 表示每一个埃及分数的分母。
 * 输入描述：
 * 以 a/b 的格式输入一个分数 abba​，其中 1≦a<b≦1001≦a<b≦100。不保证分数为最简分数。
 * 输出描述：
 * 以 1/b1+1/b2+⋯+1/bn1/b1​+1/b2​+⋯+1/bn​ 的格式输出结果，其中，b1,b2,…,bnb1​,b2​,…,bn​ 表示每一个埃及分数的分母。
 *
 * 如果存在多个解决方案，您可以输出任意一个，系统会自动判定是否正确。注意，自测运行功能可能因此返回错误结果，请自行检查答案正确性。
 * 示例1
 * 输入：
 *
 * 2/4
 *
 * 输出：
 *
 * 1/2
 *
 * 说明：
 *
 * 在这个样例中，输出 1/3+1/6 也是正确的。
 *
 * 示例2
 * 输入：
 *
 * 8/11
 *
 * 输出：
 *
 * 1/2+1/5+1/55+1/110
 */

public class TrueFractions2EgyptianTest {
    @Test
    void numerator_1_denominator_2() {
        Fraction fraction = Fraction.getFraction(1, 2);
        String result = convert(fraction);
        Assertions.assertEquals("1/2", result);
    }

    @Test
    void numerator_2_denominator_3() {
        Fraction fraction = Fraction.getFraction(2, 3);
        String result = convert(fraction);
        Assertions.assertEquals("1/2+1/6", result);
    }
    @Test
    void numerator_8_denominator_11() {
        Fraction fraction = Fraction.getFraction(8, 11);
        String result = convert(fraction);
        Assertions.assertEquals("1/2+1/5+1/37+1/4070", result);
    }

    private String convert(Fraction fraction) {
        // 如果分子为1，直接返回
        if (fraction.getNumerator() == 1) {
            return fraction.toProperString();
        }
        
        // 先化简分数
        fraction = fraction.reduce();
        int numerator = fraction.getNumerator();
        int denominator = fraction.getDenominator();
        
        // 找到第一个不大于原分数的单位分数
        int firstDenominator = (int) Math.ceil((double) denominator / numerator);
        
        // 构造第一个单位分数
        Fraction firstUnit = Fraction.getFraction(1, firstDenominator);
        
        // 计算剩余部分
        Fraction remainder = fraction.subtract(firstUnit);
        
        // 如果没有剩余，直接返回第一个单位分数
        if (remainder.getNumerator() == 0) {
            return firstUnit.toProperString();
        }
        
        // 否则，递归处理剩余部分
        return firstUnit.toProperString() + "+" + convert(remainder);
    }
}
