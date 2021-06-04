package com.uj.study.password_verify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.uj.study.password_verify.PwdVerifier.NG;
import static com.uj.study.password_verify.PwdVerifier.OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/2 上午11:58
 * @description：
 * * 密码要求:
 *  *
 *  * 1.长度超过8位
 *  *
 *  * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *  *
 *  * 3.不能有相同长度大于2的子串重复
 */
public class PwdVerifierTest {
    @Test
    void verify() {
        List<String> input = Arrays.asList("021Abc9000", "021Abc9", "021ABC9000", "021$bc9000", "021Abc900bc");
        List<String> result = PwdVerifier.verify(input);
        assertThat(result, contains(OK, NG, NG, OK, NG));
    }

    @Test
    void typeVerify() {
        assertThat(PwdVerifier.isValidType("021Abc9000"), is(true));
        assertThat(PwdVerifier.isValidType("021Abc9000_"), is(true));
        assertThat(PwdVerifier.isValidType("021ABC9000"), is(false));
        assertThat(PwdVerifier.isValidType("021ABC9000#"), is(true));
    }

    @Test
    void duplicateRuleVerify() {
        assertThat(PwdVerifier.isValidDuplicateRule("021Abc9Abc1"), is(false));
        assertThat(PwdVerifier.isValidDuplicateRule("021Abc900bc"), is(false));
        assertThat(PwdVerifier.isValidDuplicateRule("021ABC900bcbc"), is(false));
        assertThat(PwdVerifier.isValidDuplicateRule("021Abc9000"), is(true));
    }
}
