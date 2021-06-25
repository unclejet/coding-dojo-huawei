package com.uj.study.password_crack;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/24 上午11:49
 * @description：
 */
public class PwdCrackerTest {
    @Test
    void crack() {
        assertThat(PwdCracker.crack("YUANzhi1987"), is("zvbo9441987"));
    }
}
