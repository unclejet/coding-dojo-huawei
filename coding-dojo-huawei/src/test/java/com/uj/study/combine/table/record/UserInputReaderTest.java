package com.uj.study.combine.table.record;

import com.uj.study.common.utils.LineReaderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 复制
 * 0 3
 * 1 2
 * 3 4
 */
public class UserInputReaderTest {

    private LineReaderStub lineReaderStub;
    private UserInputReader userInputReader;

    @BeforeEach
    void setUp() {
        lineReaderStub = new LineReaderStub();
        userInputReader = new UserInputReader(lineReaderStub);
    }

    @Test
    void inputIndexMustBeNumber() {
        lineReaderStub.simulateUserInputs("4");
        assertThat(userInputReader.readIndexNumber(), is(4));

        lineReaderStub.simulateUserInputs("a", "3.14", "4");
        assertThat(userInputReader.readIndexNumber(), is(4));
    }

    @Test
    void inputKeyValuePair_twoNumber_blankSplit() {
        lineReaderStub.simulateUserInputs("0 1");
        Pair pair = userInputReader.readIndexedNumberKeyValues(1).get(0);
        assertThat(pair.getKey(), is(0));
        assertThat(pair.getValue(), is(1));

        lineReaderStub.simulateUserInputs("01", "0.1 1", "1 b", "0~1", "0     1");
        pair = userInputReader.readIndexedNumberKeyValues(1).get(0);
        assertThat(pair.getKey(), is(0));
        assertThat(pair.getValue(), is(1));
    }

    @Test
    void readIndexedNumberKeyValues() {
        lineReaderStub.simulateUserInputs("0 1", "0  2", "1 2", "3 4");
        List<Pair> pairs = userInputReader.readIndexedNumberKeyValues(4);
        assertThat(pairs.size() ,is(4));
    }
}
