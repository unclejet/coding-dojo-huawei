package com.uj.study.approximate.value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/15 12:02
 * @description：
 * @modified By：
 * @version:
 */
public class ApproximateValuerTest {
    @Test
    void canary() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[1], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }

    @Test
    void calculateApproximateValue() {
        assertAll(
                "approximateValue",
                () -> assertEquals(ApproximateValuer.calculate(5.5F), 6),
                () -> assertEquals(ApproximateValuer.calculate(.1F), 0),
                () -> assertEquals(ApproximateValuer.calculate(5.4F), 5)
        );

    }
}
