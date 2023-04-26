package com.uj.study.maze;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.password_interception.PasswordInterceptionUserInputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/4/7 下午12:23
 * @description：
 * * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 *  * <p>
 *  * <p>
 *  * int maze[5][5] = {
 *  * 0, 1, 0, 0, 0,
 *  * 0, 1, 1, 1, 0,
 *  * 0, 0, 0, 0, 0,
 *  * 0, 1, 1, 1, 0,
 *  * 0, 0, 0, 1, 0,
 *  * };
 *  * <p>
 *  * <p>
 *  * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 *  * <p>
 *  * 数据范围： 2≤n,m≤10 2≤n,m≤10  ， 输入的内容只包含 0≤val≤1 0≤val≤1
 *  * 输入描述：
 *  * <p>
 *      * 示例1
 *  * 输入：
 *  * <p>
 *  * 5 5
 *  * 0 1 0 0 0
 *  * 0 1 1 1 0
 *  * 0 0 0 0 0
 *  * 0 1 1 1 0
 *  * 0 0 0 1 0
 */
public class UserInputTest extends BaseUserInputReaderTest {
    MazeProblemUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new MazeProblemUserInputReader(lineReaderStub);
    }

    @Test
    void mazeSizeValid() {
        lineReaderStub.simulateUserInputs("55", "a 5", "1 10", "2 11", "5 5");
        int[] mazeSize = reader.readMazeSize();
        Assertions.assertArrayEquals(mazeSize, new int[]{5, 5});
    }

    @Test
    void mazeValid() {
        lineReaderStub.simulateUserInputs("0 1 0 0", "a 0", "2 0", "0   1 0 0 0");
        Assertions.assertArrayEquals(reader.readMazeLine(5), new String[]{"0", "1", "0", "0", "0"});
    }

    @Test
    void readMazeData() {
        lineReaderStub.simulateUserInputs("0 1", "0 0");
        assertThat(reader.readMazeData(2, 2), contains("0", "1", "0", "0"));
    }

    @Test
    void readMaze() {
        lineReaderStub.simulateUserInputs("2 2", "0 1", "0 0");
        int[][] maze = reader.readMaze();
        assertThat(maze[0][1], is(1));
    }

    @Test
    void match() {
        String s = "0 1   0";
        boolean b = s.matches("[01\\s]+");
        assertThat(b, is(true));
        String[] sa = s.split("\\s+");
        assertThat(sa.length ,is (3));
    }
}
