package com.uj.study.sort_string;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/1/25 下午12:28
 * @description：
 */
public class LineSorter {
    public static String sort(String input) {
        char[] result = input.toCharArray();
        for (int length = result.length; length > 0; length--)
            for (int index = 0; index + 1 < length; index++) {
                int nextIdx = nextLetter(result, index);
                if (outOfOrder(result, index, nextIdx))
                    swap(result, index, nextIdx);
            }
        return String.valueOf(result);
    }

    static int nextLetter(char[] result, int startIdx) {
        for (int nextIdx = startIdx + 1; nextIdx < result.length; nextIdx++) {
            if (isLetter(result[nextIdx]))
                return nextIdx;
        }
        return -1;
    }

    private static boolean outOfOrder(char[] result, int index, int nextIdx) {
        char ch = result[index];
        if (!isLetter(ch)) {
            return false;
        }
        return  hasNextLetter(nextIdx) ? Character.toLowerCase(ch) > Character.toLowerCase(result[nextIdx]) : false;
    }

    private static boolean hasNextLetter(int nextIdx) {
        return nextIdx > 0;
    }

    private static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private static void swap(char[] result, int index, int nextIdx) {
        char temp = result[index];
        result[index] = result[nextIdx];
        result[nextIdx] = temp;
    }
}
