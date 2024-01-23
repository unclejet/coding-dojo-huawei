package com.uj.study.string_common_max_substring_length;

public class MaxCommonSubStringSearcher {

    static String search(String a, String b) {
        String result = "";
        String ss = a.length() <= b.length() ? a : b;
        String ls = a.length() > b.length() ? a : b;
        String[] ssArr = ss.split("");
        String[] lsArr = ls.split("");
        for (int i = 0; i < ssArr.length; i++) {
            int start = 0;
            int idx = ls.indexOf(ssArr[i], start);
            while (idx >= 0) {
                String matchSubString = getMatchSubString(ssArr, i, lsArr, idx);
                if (matchSubString.length() > result.length())
                    result = matchSubString;
                start = idx + 1;
                idx = ls.indexOf(ssArr[i], start);
            }
        }
        return result;
    }

    private static String getMatchSubString(String[] ssArr, int ssIdx, String[] lsArr, int lsIdx) {
        StringBuilder sb = new StringBuilder();
        for (int i = ssIdx, j = lsIdx; i < ssArr.length && j < lsArr.length; i++, j++) {
            if (ssArr[i].equals(lsArr[j]))
                sb.append(ssArr[i]);
            else
                break;
        }
        return sb.toString();
    }
}