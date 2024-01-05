package com.uj.study.dna;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/3 下午12:47
 * @description：
 * * <p>
 *  * 数据范围：字符串长度满足 1≤n≤1000 1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
 *  * 输入描述：
 *  * <p>
 *  * 输入一个string型基因序列，和int型子串的长度
 *  * 输出描述：
 *  * <p>
 *  * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 *  * 示例1
 *  * 输入：
 *  * <p>
 *  * ACGT
 *  * 2
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * CG
 *  * <p>
 */
public class DnaSequenceReaderTest extends BaseUserInputReaderTest {
    DnaSequenceReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new DnaSequenceReader(lineReaderStub);
    }

    @Test
    void str_length_isValid() {
        lineReaderStub.simulateUserInputs(RandomAlphabetGenerator.generateRandomCharacters(1001), "", "ACGT", "2");
        reader.read();
        assertThat(reader.getFirstLine(), is("ACGT"));
    }

    @Test
    void input_number_less_than_strLength() {
        lineReaderStub.simulateUserInputs("ACGT", "5", "2");
        reader.read();
        assertThat(reader.getSecondLine(), is(2));
    }

    @Test
    void only_A_C_G_T() {
        lineReaderStub.simulateUserInputs("ABCT", "acgt", "ACG T", "ACGT ", "ACGT", "2");
        reader.read();
        assertThat(reader.getFirstLine(), is("ACGT"));
    }

    @Test
    void isACGT() {
        assertThat(isACGT("ACT"), is(true));
    }

    private boolean isACGT(String line) {
        return Arrays.stream(line.split("")).allMatch(s -> "ACGT".contains(String.valueOf(s)));
    }
}
