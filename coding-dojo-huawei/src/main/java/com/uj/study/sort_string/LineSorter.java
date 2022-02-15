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
            for (int index = 0; index + 1 < length; index++)
                if (outOfOrder(result, index))
                    swap(result, index);

        return String.valueOf(result);
    }

    private static boolean outOfOrder(char[] result, int index) {
        return Character.toLowerCase(result[index]) > Character.toLowerCase(result[index + 1]);
    }

    private static void swap(char[] result, int index) {
        char temp = result[index];
        result[index] = result[index + 1];
        result[index + 1] = temp;
    }
}
