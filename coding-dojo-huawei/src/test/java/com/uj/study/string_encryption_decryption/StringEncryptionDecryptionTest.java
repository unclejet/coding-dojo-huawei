package com.uj.study.string_encryption_decryption;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.uj.study.string_encryption_decryption.StringEncryptionDecryption.handleDecrypt;
import static com.uj.study.string_encryption_decryption.StringEncryptionDecryption.handleEncrypt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/6/13 下午12:45
 * @description： 描述
 * <p>
 * 对输入的字符串进行加解密，并输出。
 * <p>
 * 加密方法为：
 * <p>
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * <p>
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * <p>
 * 其他字符不做变化。
 * 解密方法为加密的逆过程。
 * 数据范围：输入的两个字符串长度满足 1≤n≤1000 1 \le n \le 1000 \ 1≤n≤1000  ，保证输入的字符串都是只由大小写字母或者数字组成
 * 输入描述：
 * <p>
 * 第一行输入一串要加密的密码
 * 第二行输入一串加过密的密码
 * 输出描述：
 * <p>
 * 第一行输出加密后的字符
 * 第二行输出解密后的字符
 * 示例1
 * 输入：
 * <p>
 * abcdefg
 * BCDEFGH
 * <p>
 * 输出：
 * <p>
 * BCDEFGH
 * abcdefg
 */
public class StringEncryptionDecryptionTest extends BaseUserInputReaderTest {

    StringEncryptionDecryptionReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StringEncryptionDecryptionReader(lineReaderStub);
    }

    @Test
    void inputStringIsValid() {
        String bigStr = RandomAlphabetGenerator.generateRandomCharacters(1001);
        lineReaderStub.simulateUserInputs("", "1", bigStr, "1000");
        assertThat(reader.read2Lines(), arrayContaining("1", "1000"));

        lineReaderStub.simulateUserInputs("-", "A9", "bc,", "b0");
        assertThat(reader.read2Lines(), arrayContaining("A9", "b0"));
    }

    @Test
    void encrypt() {
        assertThat(handleEncrypt("a"), is("B"));
        assertThat(handleEncrypt("z"), is("A"));
        assertThat(handleEncrypt("A"), is("b"));
        assertThat(handleEncrypt("Z"), is("a"));
        assertThat(handleEncrypt("0"), is("1"));
        assertThat(handleEncrypt("9"), is("0"));
        assertThat(handleEncrypt("aB"), is("Bc"));
        assertThat(handleEncrypt("abcdefg"), is("BCDEFGH"));
    }

    @Test
    void decrypt() {
        assertThat(handleDecrypt("B"), is("a"));
        assertThat(handleDecrypt("A"), is("z"));
        assertThat(handleDecrypt("b"), is("A"));
        assertThat(handleDecrypt("a"), is("Z"));
        assertThat(handleDecrypt("1"), is("0"));
        assertThat(handleDecrypt("0"), is("9"));
        assertThat(handleDecrypt("Bc"), is("aB"));
        assertThat(handleDecrypt("BCDEFGH"), is("abcdefg"));
    }


}



