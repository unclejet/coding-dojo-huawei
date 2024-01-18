package com.uj.study.mp3_cursor_location;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/16 下午12:46
 * @description：
 * * <p>
 *  * 其他情况，不用翻页，只是挪动光标就行。
 *  * 数据范围：命令长度1≤s≤100 1≤s≤100 ，歌曲数量1≤n≤150 1≤n≤150
 *  * 进阶：时间复杂度：O(n) O(n) ，空间复杂度：O(n) O(n)
 *  * 输入描述：
 *  * <p>
 *  * 输入说明：
 *  * 1 输入歌曲数量
 *  * 2 输入命令 U或者D
 *  * 输出描述：
 *  * <p>
 *  * 输出说明
 *  * 1 输出当前列表
 *  * 2 输出当前选中歌曲
 *  * 示例1
 *  * 输入：
 *  * <p>
 *  * 10
 *  * UUUU
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * 7 8 9 10
 *  * 7
 */
public class MP3CursorLocationUserReaderTest extends BaseUserInputReaderTest {
    MP3CursorLocationUserReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new MP3CursorLocationUserReader(lineReaderStub);
    }

    @Test
    void songNumber_input_check() {
        lineReaderStub.simulateUserInputs("a","[", "", "0", "2.5", "151", "150");
        assertThat(reader.readSongNumber(), is(150));
    }

    @Test
    void instruction_check() {
        lineReaderStub.simulateUserInputs("u","d","AU", "CD", RandomAlphabetGenerator.generateSpecialCharacterManyTimes("A", 101), "UDUD");
        assertThat(reader.readInstructions(), is("UDUD"));
    }
}
