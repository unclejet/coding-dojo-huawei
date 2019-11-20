package com.uj.study.mingming_random;

import java.util.Arrays;

public class MingMingRandom {
    public int[] handle(int[] input) {
        return Arrays.stream(input).distinct().sorted().toArray();
    }
}
