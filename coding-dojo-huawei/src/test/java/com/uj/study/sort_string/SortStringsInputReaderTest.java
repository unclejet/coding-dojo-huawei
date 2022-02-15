package com.uj.study.sort_string;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/1/24 下午12:43
 * @description：
 * 描述
 *
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 * 数据范围：输入的字符串长度满足 1≤n≤1000 1 \le n \le 1000 \ 1≤n≤1000
 *
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 * 示例1
 * 输入：
 *
 * A Famous Saying: Much Ado About Nothing (2012/8).
 *
 * 输出：
 *
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class SortStringsInputReaderTest extends BaseUserInputReaderTest {
    private SortStringsInputReader inputReader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        inputReader = new SortStringsInputReader(lineReaderStub);
    }

    @Test
    void inputALine_lessThan1000() {
        String input = RandomAlphabetGenerator.generateRandomCharacters(1000);
        lineReaderStub.simulateUserInputs(RandomAlphabetGenerator.generateRandomCharacters(1001), input);
        assertThat(inputReader.readLine(), is(input));
    }


}
