package com.uj.study.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
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

    public static String generateRandomLowercaseCharacters(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    /**
     * use apache commons
     * @param length
     * @return
     */
    public static String generateRandomCharacters(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
