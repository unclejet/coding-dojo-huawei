package com.uj.study.password_crack;

import com.uj.study.password_crack.transformer.old.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/17 下午12:01
 * @description：
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 */
public class PwdTransformerOldTest {
    @Test
    void numberNotTransFormed() {
        char one = '1';
        PwdTransformerOld transformer  = new NumberTransFormerOld(null);
        assertThat(transformer.handle(one), is('1'));
    }

    @Test
    void symbolNotTransFormed() {
        char one = '#';
        PwdTransformerOld transformer  = new SymbolTransFormerOld(null);
        assertThat(transformer.handle(one), is('#'));
    }

    @Test
    void uppercaseTransFormed_toNextLowercase() {
        PwdTransformerOld transformer  = new UppercaseTransFormerOld(null);
        assertThat(transformer.handle('A'), is('b'));
        assertThat(transformer.handle('Z'), is('a'));
    }

    @Test
    void lowercaseTransFormed_toNextLowercase() {
        PwdTransformerOld transformer  = new LowercaseTransformerOld(null);
        assertThat(transformer.handle('a'), is('2'));
        assertThat(transformer.handle('z'), is('9'));
    }
}
