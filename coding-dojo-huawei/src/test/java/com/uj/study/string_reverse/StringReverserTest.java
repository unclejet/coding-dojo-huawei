package com.uj.study.string_reverse;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.uj.study.string_reverse.StringReverser.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsEmptyCollection.empty;


/**
 * @author ：UncleJet
 * @date ：Created in 2022/8/3 下午12:34
 * @description：
 * 描述
 *
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 *
 * 数据范围：字符串长度满足 1≤n≤10000 1 \le n \le 10000 \ 1≤n≤10000
 * 输入描述：
 *
 * 输入一行，表示用来倒排的句子
 * 输出描述：
 *
 * 输出句子的倒排结果
 * 示例1
 * 输入：
 *
 * I am a student
 *
 * 输出：
 *
 * student a am I
 *
 * 示例2
 * 输入：
 *
 * $bo*y gi!r#l
 *
 * 输出：
 *
 * l r gi y bo
 */
public class StringReverserTest extends BaseUserInputReaderTest {
    StringReverseUserReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StringReverseUserReader(lineReaderStub);
    }

    @Test
    void validInput() {
        lineReaderStub.simulateUserInputs("", RandomAlphabetGenerator.generateRandomCharacters(100001) ,"abc");
        assertThat(reader.read(), is("abc"));
    }

    @Test
    void extractWords() {
        assertThat(StringReverser.extractWords("x"), contains("x"));
        assertThat(StringReverser.extractWords("x x"), contains("x", "x"));
        assertThat(StringReverser.extractWords(" x x "), contains("x", "x"));
        assertThat(StringReverser.extractWords("x xx xxx"), contains("x", "xx", "xxx"));

        assertThat(StringReverser.extractWords("x!x"), contains("x", "x"));
        assertThat(StringReverser.extractWords("!x!X!"), contains("x", "X"));
        assertThat(StringReverser.extractWords("x!#x"), contains("x", "x"));
        assertThat(StringReverser.extractWords("!#"), empty());
        assertThat(StringReverser.extractWords("$$bo*y gi!!r#l"), contains("bo", "y", "gi", "r", "l"));
    }

    @Test
    void reverse() {
        assertThat(StringReverser.reverse("$bo*y gi!r#l"), is("l r gi y bo"));
    }




}
