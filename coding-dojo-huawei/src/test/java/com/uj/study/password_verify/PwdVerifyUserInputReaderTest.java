package com.uj.study.password_verify;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.uj.study.common.input.BaseUserInputReader.EXIT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/31 上午11:39
 * @description：
 * 描述
 *
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有相同长度大于2的子串重复
 * 输入描述：
 *
 * 一组或多组长度超过2的字符串。每组占一行
 * 输出描述：
 *
 * 如果符合要求输出：OK，否则输出NG
 * 示例1
 * 输入：
 *
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 *
 * 输出：
 *
 * OK
 * NG
 * NG
 * OK
 */
public class PwdVerifyUserInputReaderTest extends BaseUserInputReaderTest {
    PwdVerifyUserInputReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new PwdVerifyUserInputReader(lineReaderStub);
    }

    @Test
    void readLines() {
        lineReaderStub.simulateUserInputs("021Abc9000", "021Abc9Abc1", EXIT);
        List<String> pwds = reader.readPwdList();
        assertThat(pwds, contains("021Abc9000", "021Abc9Abc1"));
    }
}
