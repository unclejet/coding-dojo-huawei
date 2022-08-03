package com.uj.study.string_combine_handle;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;


/**
 * @author ：UncleJet
 * @date ：Created in 2022/7/26 下午12:34
 * @description：
 * 描述
 *
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 * 第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
 *
 * 第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
 *
 * 第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
 * 转换规则如下：
 * 对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
 * 如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
 * 如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
 * 如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
 *
 * 根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
 *
 * 数据范围：输入的字符串长度满足 1≤n≤100 1 \le n \le 100 \ 1≤n≤100
 *
 *
 * 输入描述：
 *
 * 样例输入两个字符串，用空格隔开。
 * 输出描述：
 *
 * 输出转化后的结果。
 * 示例1
 * 输入：
 *
 * dec fab
 *
 * 输出：
 *
 * 5D37BF
 *
 * 示例2
 * 输入：
 *
 * ab CD
 *
 * 输出：
 *
 * 3B5D
 *
 * 说明：
 *
 * 合并后为abCD，按奇数位和偶数位排序后是CDab（请注意要按ascii码进行排序，所以C在a前面，D在b前面），转换后为3B5D
 *
 * 示例3
 * 输入：
 *
 * 123 15
 *
 * 输出：
 *
 * 88C4A
 */
public class StringCombineHandleTest extends BaseUserInputReaderTest {

    StringCombineHandleReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StringCombineHandleReader(lineReaderStub);
    }

    @Test
    void inputIsValid() {
        lineReaderStub.simulateUserInputs("", RandomAlphabetGenerator.generateRandomCharacters(50) + " " + RandomAlphabetGenerator.generateRandomCharacters(51), "str1", " str1 str2 ", "dec fab");
        assertThat(reader.readLine(), is("str1 str2"));
    }

    @Test
    void combine() {
        assertThat(combine("dec fab"), is("decfab"));
    }

    @Test
    void sort() {
        assertThat(sort("ba"), is("ab"));
    }

    @Test
    void getSpecifiedArrayIdxStr() {
        assertThat(getOddIdxStr("decfab"), is("efb"));
        assertThat(getEvenIdxStr("decfab"), is("dca"));
    }

    @Test
    void step2() {
        assertThat(handleSpecifiedIdxString("decfab"), is("abcedf"));
    }

    @Test
    void transform() {
        assertThat(transform('4'), is('2'));
        assertThat(transform('7'), is('E'));
        assertThat(transform('C'), is('3'));
    }

    @Test
    void combineAndHandle() {
        assertThat(combineAndHandle("dec fab"), is("5D37BF"));
        assertThat(combineAndHandle("ab CD"), is("3B5D"));
        assertThat(combineAndHandle("123 15"), is("88C4A"));
    }

    private String combineAndHandle(String input) {
        String s = handleSpecifiedIdxString(combine(input));
        return transformStr(s);
    }

    private String transformStr(String str) {
        IntStream is = str.chars().map(c->transform((char) c));
        return  is.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    private char transform(char c) {
        return binary2Hex(StringUtils.reverse(hex2Binary(c))).toUpperCase().charAt(0);
    }

    private String binary2Hex(String reverse) {
        int decimal = Integer.parseInt(reverse,2);
        return Integer.toString(decimal, 16);
    }

    private String hex2Binary(char c) {
        int decimal = Integer.parseInt(String.valueOf(c), 16);
        return String.format("%4s", Integer.toBinaryString(decimal)).replaceAll(" ", "0");
    }

    private String handleSpecifiedIdxString(String combinedStr) {
        char[] chars = new char[combinedStr.length()];
        String sortedOddIdxStr = sort(getOddIdxStr(combinedStr));
        String sortedEvenIdxStr = sort(getEvenIdxStr(combinedStr));
        for (int i = 0; i < combinedStr.length(); i++) {
            if (i % 2 == 0) {
                chars[i] = sortedEvenIdxStr.charAt(i >> 1);
            } else {
                chars[i] = sortedOddIdxStr.charAt(i >> 1);
            }

        }
        return new String(chars);
    }

    private String getEvenIdxStr(String combinedStr) {
        char[] chars = combinedStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, chars.length).filter(i-> i % 2 == 0).forEach(i->sb.append(chars[i]));
        return sb.toString();
    }

    private String getOddIdxStr(String combinedStr) {
        char[] chars = combinedStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, chars.length).filter(i-> i % 2 != 0).forEach(i->sb.append(chars[i]));
        return sb.toString();
    }

    private String sort(String combinedStr) {
        return combinedStr.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    private String combine(String input) {
        return input.replaceAll("\\s+", "");
    }
}
