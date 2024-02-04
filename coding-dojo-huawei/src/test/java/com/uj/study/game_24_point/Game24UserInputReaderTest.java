package com.uj.study.game_24_point;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/2 下午12:50
 * @description：
 * * 读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 *  * 输出描述：
 *  *
 *  * 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 *  * 示例1
 *  * 输入：
 *  *
 *  * 7 2 1 10
 *  *
 *  * 输出：
 *  *
 *  * true
 */
public class Game24UserInputReaderTest extends BaseUserInputReaderTest {
    Game24UserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new Game24UserInputReader(lineReaderStub);
    }

    @Test
    void check_input_number() {
        lineReaderStub.simulateUserInputs("a 1 2 3", "0 1 2 3", "1 2 3 11", "2 3 4", "4/5/6/7", "3 3 4 5");
        int[] nums = reader.readNumber();
        assertThat(nums[0], is(3));
        assertThat(nums[3], is(5));

    }
}
