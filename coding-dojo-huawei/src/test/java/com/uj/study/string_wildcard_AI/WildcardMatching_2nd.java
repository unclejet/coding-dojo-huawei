package com.uj.study.string_wildcard_AI;

public class WildcardMatching_2nd {

    public static boolean matched(String pattern, String string) {
        return helper(pattern, string, 0, 0);
    }

    private static boolean helper(String pattern, String string, int pIdx, int sIdx) {
        // If both pattern and string are at the end, it's a match
        if (pIdx == pattern.length() && sIdx == string.length()) {
            return true;
        }
        // If pattern is at the end but string is not, it's not a match
        if (pIdx == pattern.length()) {
            return false;
        }
        // If string is at the end but pattern is not
        if (sIdx == string.length()) {
            // Check if the remaining pattern is all '*'
            for (int i = pIdx; i < pattern.length(); i++) {
                if (pattern.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        // If the current character in pattern is '*'
        if (pattern.charAt(pIdx) == '*') {
            // Try to match 0 characters or more
            return helper(pattern, string, pIdx + 1, sIdx) || helper(pattern, string, pIdx, sIdx + 1);
        }
        // If the current character in pattern is '?' or matches the current character in string
        else if (pattern.charAt(pIdx) == '?' || Character.toLowerCase(pattern.charAt(pIdx)) == Character.toLowerCase(string.charAt(sIdx))) {
            return helper(pattern, string, pIdx + 1, sIdx + 1);
        }
        // If the current characters do not match
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(matched("te?t*.*", "txt12.xls")); // false
        System.out.println(matched("z", "zz")); // false
        System.out.println(matched("pq", "pqpq")); // false
        System.out.println(matched("**Z", "0QZz")); // true
        System.out.println(matched("?*Bc*?", "abcd")); // true
        System.out.println(matched("h*?*a", "h#a")); // false
        System.out.println(matched("p*p*qp**pq*p**p***ppq", "pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp")); // false
    }
}

