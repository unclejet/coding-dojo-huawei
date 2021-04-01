package com.uj.study.coordinate;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/3/24 上午11:48
 * @description：
 */
public class CoordinateUserInputReaderTest extends BaseUserInputReaderTest {
    CoordinateUserInputReader userInputReader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        userInputReader = new CoordinateUserInputReader(lineReaderStub);
    }

    @Test
    void validInput() {
        lineReaderStub.simulateUserInputs("A10;S20;W10;D30;X;A1A;B10A11;;A10;A111;A;X10");
        List<String> coordinates = userInputReader.readValidCoordinates();
        assertThat(coordinates.size(), is(5));
    }
}
