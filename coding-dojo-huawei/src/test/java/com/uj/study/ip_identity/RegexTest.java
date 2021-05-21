package com.uj.study.ip_identity;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/10 上午11:43
 * @description：
 */
public class RegexTest {
//    public static final Pattern IP_PATTERN = Pattern.compile("\\d*.\\d*.\\d*.\\d*~\\d*.\\d*.\\d*.\\d*");
    public static final Pattern IP_PATTERN = Pattern.compile("(\\d*.){3}?\\d*~(\\d*.){3}?\\d*");
    @Test
    void name() {
        assertThat(isValid("192.168.0.2~255.255.255.0"), is(true));
    }

    private boolean isValid(String number) {
        return IP_PATTERN.matcher(number).matches();
    }
}
