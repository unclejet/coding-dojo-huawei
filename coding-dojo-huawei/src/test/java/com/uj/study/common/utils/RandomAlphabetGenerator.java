package com.uj.study.common.utils;

import java.util.UUID;

public final class RandomAlphabetGenerator {
    private RandomAlphabetGenerator() {
    }

    public static String generateRandomAlphabetByUUIDNoDash(int length) {
        int i = 0;
        int loop = length / 32;
        String uuid = UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder(uuid);
        while (i++ < loop) {
            uuid = UUID.randomUUID().toString().replace("-", "");
            sb.append(uuid);
        }
        String result = sb.toString().substring(0, length);
        return result;
    }
}
