package com.uj.study.suduku;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/5/23 下午12:42
 * @description：
 * * 输入：
 *  * <p>
 *  * 0 9 2 4 8 1 7 6 3
 *  * 4 1 3 7 6 2 9 8 5
 *  * 8 6 7 3 5 9 4 1 2
 *  * 6 2 4 1 9 5 3 7 8
 *  * 7 5 9 8 4 3 1 2 6
 *  * 1 3 8 6 2 7 5 9 4
 *  * 2 7 1 5 3 8 6 4 9
 *  * 3 8 6 9 1 4 2 5 7
 *  * 0 4 5 2 7 6 8 3 1
 */
public class SuDuKuUserInputTest extends BaseUserInputReaderTest {
    SuDuKuUserInputReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new SuDuKuUserInputReader(lineReaderStub);
    }

    @Test
    void input9x9Array() {
        lineReaderStub.simulateUserInputs("-1 9 2 4 8 1 7 6 3", "0 10 2 4 8 1 7 6 3", "0 9 ad 4 8 1 7 6 3", "0 9 2 4 8 1 7 6 3", "4 1 1 7 6 2 9 8 5", "0 9 2 4 8 1 7 6 3",  "4 1 3 7 6 2 9 8 5", "8 6 7 3 5 9 4 1 2", "6 2 4 1 9 5 3 7 8", "7 5 9 8 4 3 1 2 6", "1 3 8 6 2 7 5 9 4", "2 7 1 5 3 8 6 4 9", "3 8 6 9 1 4 2 5 7", "0 4 5 2 7 6 8 3 1");
        int[][] data = reader.readSuDu();
        assertThat(data.length, is(9));
        assertThat(data[1].length, is(9));
        assertThat(data[8][0], is(0));
    }
}
