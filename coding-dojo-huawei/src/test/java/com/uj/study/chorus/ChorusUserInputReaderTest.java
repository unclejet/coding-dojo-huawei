package com.uj.study.chorus;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/10 下午12:39
 * @description：
 * 备注：
 * 1<=N<=3000
 * 输入描述：
 *
 * 有多组用例，每组都包含两行数据，第一行是同学的总数N，第二行是N位同学的身高，以空格隔开
 * 输出描述：
 *
 * 最少需要几位同学出列
 * 示例1
 * 输入：
 *
 * 8
 * 186 186 150 200 160 130 197 200
 *
 * 输出：
 *
 * 4
 */
public class ChorusUserInputReaderTest extends BaseUserInputReaderTest {
    ChorusUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new ChorusUserInputReader(lineReaderStub);
    }

    @Test
    void inputTwoLine() {
        lineReaderStub.simulateUserInputs("8", "186 186 150 200 160 130 197 200");
        int[] heights = reader.readHeights();
        assertThat(heights.length, is(8));
        assertThat(heights[0], is(186));
        assertThat(heights[7], is(200));
    }

    @Test
    void heightsQueueInputFormatMatch() {
        String inputs = "186 186 150 200 160 130 197 200";
        assertThat(reader.isValidFormat(inputs, 8), is(true));
        inputs = "186";
        assertThat(reader.isValidFormat(inputs, 1), is(true));
        inputs = "186 a";
        assertThat(reader.isValidFormat(inputs, 2), is(false));
        inputs = "186 ";
        assertThat(reader.isValidFormat(inputs, 2), is(false));
    }
}
