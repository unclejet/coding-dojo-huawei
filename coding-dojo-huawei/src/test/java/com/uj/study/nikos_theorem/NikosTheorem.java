package com.uj.study.nikos_theorem;

public class NikosTheorem {
    public static String decompose(int m) {
        StringBuilder result = new StringBuilder();
        int start = m * m - m + 1; // 计算起始奇数
        for (int i = 0; i < m; i++) {
            if (i > 0) {
                result.append("+");
            }
            result.append(start + 2 * i);
        }
        return result.toString();
    }
}

