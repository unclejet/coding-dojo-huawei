package com.uj.study.string_encryption_decryption;

import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/7/25 下午12:36
 * @description：
 */
public class StringEncryptionDecryption {
    public static final int POINT_z = 122;
    public static final int POINT_a = 97;
    public static final int POINT_Z = 90;
    public static final int POINT_A = 65;
    public static final int POINT_0 = 48;
    public static final int POINT_9 = 57;

    public static String handleDecrypt(String input) {
        IntStream is = input.chars().map(c -> decrypt(c));
        return is.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static String handleEncrypt(String input) {
        IntStream is = input.chars().map(c -> encrypt(c));
        return is.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }



    private static int encrypt(int codePoint) {
        if (Character.isLowerCase(codePoint)) {
            return codePoint + 1 > POINT_z ? POINT_a - 32 : codePoint + 1 - 32;
        } else if (Character.isUpperCase(codePoint)) {
            return codePoint + 1 > POINT_Z ? POINT_A + 32 : codePoint + 1 + 32;
        } else if (Character.isDigit(codePoint)) {
            return codePoint + 1 > POINT_9 ? POINT_0 : codePoint + 1;
        }
        return codePoint;
    }

    private static  int decrypt(int codePoint) {
        if (Character.isUpperCase(codePoint)) {
            return codePoint - 1 < POINT_A ? POINT_Z + 32 : codePoint - 1 + 32;
        } else if (Character.isLowerCase(codePoint)) {
            return codePoint - 1 < POINT_a ? POINT_z - 32 : codePoint - 1 - 32;
        } else if (Character.isDigit(codePoint)) {
            return codePoint - 1 < POINT_0 ? POINT_9 : codePoint - 1;
        }
        return codePoint;
    }
}
