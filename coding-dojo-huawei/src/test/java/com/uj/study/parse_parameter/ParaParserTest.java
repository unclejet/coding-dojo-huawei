package com.uj.study.parse_parameter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;


/**
 * 描述
 * <p>
 * 在命令行输入如下命令：
 * <p>
 * xcopy /s c:\\ d:\\e，
 * <p>
 * 各个参数如下：
 * <p>
 * 参数1：命令字xcopy
 * <p>
 * 参数2：字符串/s
 * <p>
 * 参数3：字符串c:\\
 * <p>
 * 参数4: 字符串d:\\e
 * <p>
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 * <p>
 * <p>
 * 解析规则：
 * <p>
 * 1.参数分隔符为空格
 * 2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\\program files" "d:\"时，
 * 参数仍然是4个，第3个参数应该是字符串C:\\program files，而不是C:\\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 * 数据范围：字符串长度：1≤s≤1000 1≤s≤1000
 * 进阶：时间复杂度：O(n) O(n) ，空间复杂度：O(n) O(n)
 * 输入描述：
 * <p>
 * 输入一行字符串，可以有空格
 * 输出描述：
 * <p>
 * 输出参数个数，分解后的参数，每个参数都独占一行
 * 示例1
 * 输入：
 * <p>
 * xcopy /s c:\\ d:\\e
 * <p>
 * 输出：
 * <p>
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\e
 */
public class ParaParserTest {
    @Test
    void one_parameter() {
        List<String> parsed = parse("xcopy");
        assertThat(parsed, hasSize(1));
        assertThat(parsed, contains("xcopy"));
    }

    @Test
    void two_parameters() {
        List<String> parsed = parse("xcopy /s");
        assertThat(parsed, hasSize(2));
        assertThat(parsed, contains("xcopy", "/s"));
    }

    @Test
    void three_parameters_with_space() {
        List<String> parsed = parse("xcopy  /s  \"C:\\\\program files\"");
        assertThat(parsed, hasSize(3));
        assertThat(parsed, contains("xcopy", "/s", "C:\\\\program files"));
    }

    public static List<String> parse(String command) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean inQuotes = false;

        for (char c : command.toCharArray()) {
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                addTokenIfNotEmpty(tokens, currentToken);
            } else {
                currentToken.append(c);
            }
        }

        addTokenIfNotEmpty(tokens, currentToken);

        return tokens;
    }

    private static void addTokenIfNotEmpty(List<String> tokens, StringBuilder currentToken) {
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
            currentToken.setLength(0);
        }
    }
}


