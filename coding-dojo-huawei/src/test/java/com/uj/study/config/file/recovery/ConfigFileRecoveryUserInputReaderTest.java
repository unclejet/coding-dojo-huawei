package com.uj.study.config.file.recovery;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/29 下午12:41
 * @description：
 * * 注意：有多组输入。
 *  * 数据范围：数据组数：1≤t≤800 1≤t≤800 ，字符串长度1≤s≤20 1≤s≤20
 *  * 进阶：时间复杂度：O(n) O(n) ，空间复杂度：O(n) O(n)
 *  * 输入描述：
 *  *
 *  * 多行字符串，每行字符串一条命令
 *  * 输出描述：
 *  *
 *  * 执行结果，每条命令输出一行
 *  * 示例1
 *  * 输入：
 *  *
 *  * reset
 *  * reset board
 *  * board add
 *  * board delet
 *  * reboot backplane
 *  * backplane abort
 *  *
 *  * 输出：
 *  *
 *  * reset what
 *  * board fault
 *  * where to add
 *  * no board at all
 *  * impossible
 *  * install first
 */
public class ConfigFileRecoveryUserInputReaderTest extends BaseUserInputReaderTest {
    private ConfigFileRecoveryUserInputReader reader;

    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new ConfigFileRecoveryUserInputReader(lineReaderStub);
    }

    @Test
    void string_length_is_valid() {
        lineReaderStub.simulateUserInputs(RandomAlphabetGenerator.generateRandomCharacters(21), "reset", "");
        assertThat(reader.readCommands(), contains("reset"));
    }

    @Test
    void array_length_is_valid() {
        lineReaderStub.simulateUserInputs(inputTimes(801));
        assertThat(reader.readCommands().size(), is(800));
    }

    private String[] inputTimes(int i) {
        String[] result = new String[i];
        for (int j = 0; j < i; j++) {
            result[j] = RandomAlphabetGenerator.generateRandomLowercaseCharacters(10);
        }
        return result;
    }
}
