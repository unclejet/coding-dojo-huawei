package com.uj.study.beauty_name;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/5 下午12:48
 * @description：
 * * 本题含有多组数据。
 *  *
 *  * 数据范围：输入的名字长度满足 1≤n≤10000 1≤n≤10000
 *  *
 *  *
 *  * 输入描述：
 *  *
 *  * 第一行一个整数N，接下来N行每行一个字符串
 *  * 输出描述：
 *  *
 *  * 每个字符串可能的最大漂亮程度
 *  * 示例1
 *  * 输入：
 *  *
 *  * 2
 *  * zhangsan
 *  * lisi
 *  *
 */
public class BeautifulNameUserInputReaderTest extends BaseUserInputReaderTest {
    BeautifulNameUserInputReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new BeautifulNameUserInputReader(lineReaderStub);
    }

    @Test
    void linesNumberCorrect() {
        lineReaderStub.simulateUserInputs("a", "0", "2");
        assertThat(reader.readLinesNumber(), is(2));
    }

    @Test
    void linesContentCorrect() {
        lineReaderStub.simulateUserInputs("", " ", "ZhangSan", "zhangsan", "lisi", "wanger");
        List<String> linesContent = reader.readLinesContent(2);
        assertThat(linesContent, hasSize(2));
        assertThat(linesContent, containsInAnyOrder("zhangsan","lisi"));
    }
}
