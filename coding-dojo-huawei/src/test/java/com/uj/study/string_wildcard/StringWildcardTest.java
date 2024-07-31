package com.uj.study.string_wildcard;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/28 下午12:44
 * @description： 描述
 * <p>
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 * 注意：匹配时不区分大小写。
 * <p>
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * <p>
 * 输出：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 数据范围：字符串长度：1≤s≤100 1≤s≤100
 * 进阶：时间复杂度：O(n2) O(n2) ，空间复杂度：O(n) O(n)
 * 输入描述：
 * <p>
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 * 输出描述：
 * <p>
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 示例1
 * 输入：
 * <p>
 * te?t*.*
 * txt12.xls
 * <p>
 * 输出：
 * <p>
 * false
 * <p>
 * 示例2
 * 输入：
 * <p>
 * z
 * zz
 * <p>
 * 输出：
 * <p>
 * false
 * <p>
 * 示例3
 * 输入：
 * <p>
 * pq
 * pppq
 * <p>
 * 输出：
 * <p>
 * false
 * <p>
 * 示例4
 * 输入：
 * <p>
 * **Z
 * 0QZz
 * <p>
 * 输出：
 * <p>
 * true
 * <p>
 * 示例5
 * 输入：
 * <p>
 * ?*Bc*?
 * abcd
 * <p>
 * 输出：
 * <p>
 * true
 * <p>
 * 示例6
 * 输入：
 * <p>
 * h*?*a
 * h#a
 * <p>
 * 输出：
 * <p>
 * false
 * <p>
 * 说明：
 * <p>
 * 根据题目描述可知能被*和?匹配的字符仅由英文字母和数字0到9组成，所以?不能匹配#，故输出false
 * <p>
 * 示例7
 * 输入：
 * <p>
 * p*p*qp**pq*p**p***ppq
 * pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp
 * <p>
 * 输出：
 * <p>
 * false
 */
public class StringWildcardTest {
    private Wildcard wildcard = new Wildcard();

    @Test
    void one_regex() {
        assertTrue(wildcard.matched("#", "#"));
        assertTrue(wildcard.matched("a", "a"));
        assertFalse(wildcard.matched("a", "ab"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("*", "te"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("?", "t"));
    }

    @Test
    void two_regex_alphabet() {
        assertTrue(wildcard.matched("ab", "ab"));
        assertFalse(wildcard.matched("ab", "abc"));
    }

    @Test
    void two_regex_asterisk() {
        assertTrue(wildcard.matched("a*", ""));
        assertTrue(wildcard.matched("a*", "a"));
        assertTrue(wildcard.matched("A*", "a"));
        assertTrue(wildcard.matched("a*", "A"));
        assertTrue(wildcard.matched("a*", "aa"));
        assertTrue(wildcard.matched("a*", "aaa"));
        assertTrue(wildcard.matched("1*", "1"));
        assertFalse(wildcard.matched("a*", "ab"));
        assertFalse(wildcard.matched("a*", "t#"));
        assertFalse(wildcard.matched("a*", "t"));
        assertFalse(wildcard.matched("a*", "a#"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("**", "te"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("*a", "a"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("#*", "#"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("?*", "?"));
    }

    @Test
    void two_regex_questionMark() {
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("??", "te"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("?t", "t"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("#?", "#"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("*?", "*"));
        assertTrue(wildcard.matched("a?", "a"));
        assertTrue(wildcard.matched("A?", "a"));
        assertTrue(wildcard.matched("a?", "A"));
        assertTrue(wildcard.matched("2?", "2"));
        assertFalse(wildcard.matched("a?", ""));
        assertFalse(wildcard.matched("a?", " "));
        assertFalse(wildcard.matched("a?", "b"));
        assertFalse(wildcard.matched("a?", "ab"));
    }

    @Test
    void three_regex_alphabet() {
        assertTrue(wildcard.matched("abc", "abc"));
        assertTrue(wildcard.matched("#@$", "#@$"));
        assertTrue(wildcard.matched("abC", "abc"));
    }

    @Test
    void three_regex_asterisk() {
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("***", "tex"));
        //one letter
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("t**", "ttt"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("*t*", "ttt"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("**t", "ttt"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("a#*", "a"));

        //two letters
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("*ab", "tab"));
        assertTrue(wildcard.matched("a*b", "ab"));
        assertTrue(wildcard.matched("a*b", "aab"));
        assertTrue(wildcard.matched("a*b", "b"));
        assertFalse(wildcard.matched("a*b", "bb"));
        assertTrue(wildcard.matched("ab*", "a"));
        assertTrue(wildcard.matched("ab*", "ab"));
        assertTrue(wildcard.matched("ab*", "abb"));
        assertFalse(wildcard.matched("ab*", "b"));
    }

    @Test
    void three_regex_questionMark() {
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("???", "tex"));
        //one letter
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("t??", "tex"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("?t?", "etx"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("??t", "ext"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("a#?", "a#"));
        //two letters
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("?ab", "ab"));
        assertFalse(wildcard.matched("a?b", "a"));
        assertFalse(wildcard.matched("a?b", "b"));
        assertTrue(wildcard.matched("a?b", "ab"));
        assertFalse(wildcard.matched("a?b", "aab"));
        assertFalse(wildcard.matched("ab?", "a"));
        assertFalse(wildcard.matched("ab?", "b"));
        assertTrue(wildcard.matched("ab?", "ab"));
        assertTrue(wildcard.matched("a0?", "a0"));
        assertFalse(wildcard.matched("ab?", "abb"));
    }

    @Test
    void mix_cases() {
        assertFalse(wildcard.matched("te?t*.*", "txt12.xls"));
        assertFalse(wildcard.matched("z", "zz"));
        assertFalse(wildcard.matched("pq", "pppq"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("**Z", "0QZz"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("?*Bc*?", "abcd"));
        assertThrows(PatternSyntaxException.class, () -> wildcard.matched("p*p*qp**pq*p**p***ppq",
                "pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp"));
    }

    @Disabled
    @Test
    void matcher() {
        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile("te?t*.*");
        // 创建 matcher 对象
        Matcher matcher = pattern.matcher("txt12.xls");
//        assertTrue(matcher.matches());
        assertFalse(matcher.matches());
    }

    @Disabled
    @Test
    void asterisk() {
        assertFalse(asterisk("*", " "));
        assertFalse(asterisk("*", "    "));
        assertTrue(asterisk("*", "t"));
        assertTrue(asterisk("*", "text"));


        assertTrue(asterisk("a*", "a"));
        assertFalse(asterisk("a*", "b"));
        assertTrue(asterisk("a*", "abc"));
        assertTrue(asterisk("a*", "aa"));
        assertFalse(asterisk("a*", "ba"));
        assertTrue(asterisk("*a", "a"));
        assertFalse(asterisk("*a", "b"));
        assertTrue(asterisk("*a", "ba"));
        assertFalse(asterisk("*a", "ab"));
        assertTrue(asterisk("*a", "cba"));
        assertFalse(asterisk("*a", "cab"));
        assertFalse(asterisk("*a", "bb"));
        assertTrue(asterisk("*a", "BA"));
        assertFalse(asterisk("*a", "#a"));

        assertFalse(asterisk("a**", " "));
        assertTrue(asterisk("a**", "a"));
        assertFalse(asterisk("a**", "b"));
        assertTrue(asterisk("a**", "ab"));
        assertFalse(asterisk("a**", "ba"));
        assertTrue(asterisk("a**", "abc"));
        assertTrue(asterisk("a**", "abcd"));
        assertTrue(asterisk("*a*", "a"));
        assertFalse(asterisk("*a*", "b"));
        assertTrue(asterisk("*a*", "ab"));
        assertTrue(asterisk("*a*", "ba"));
        assertTrue(asterisk("*a*", "abc"));
        assertTrue(asterisk("*a*", "bac"));
        assertTrue(asterisk("*a*", "bca"));
        assertTrue(asterisk("**a", "a"));
        assertFalse(asterisk("**a", "b"));
        assertFalse(asterisk("**a", "ab"));
        assertTrue(asterisk("**a", "ba"));
        assertTrue(asterisk("**a", "cba"));
        assertFalse(asterisk("**a", "abc"));
        assertFalse(asterisk("**a", "**a"));

        assertTrue(asterisk("**Z", "0QZz"));
        assertTrue(asterisk("**Z", "0QZzZ"));
        assertFalse(asterisk("**Z", "0QZzzb"));
        assertFalse(asterisk("p*p*qp**pq*p**p***ppq", "pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp"));
    }

    @Disabled
    @Test
    void direct_match() {
        assertFalse(dMatch("a", "aa"));
    }

    @Disabled
    @Test
    void questionMark() {
        assertFalse(questionMark("?", " "));
        assertTrue(questionMark("?", "a"));
        assertFalse(questionMark("?", "ab"));

        assertFalse(questionMark("a?", "a"));
        assertFalse(questionMark("a?", "b"));
        assertTrue(questionMark("a?", "aa"));
        assertTrue(questionMark("a?", "ab"));
        assertFalse(questionMark("a?", "ba"));
        assertFalse(questionMark("a?", "abc"));
        assertFalse(questionMark("?a", "a"));
        assertFalse(questionMark("?a", "b"));
        assertFalse(questionMark("?a", "ab"));
        assertTrue(questionMark("?a", "ba"));
        assertFalse(questionMark("?a", "bac"));

        assertFalse(questionMark("a??", "a"));
        assertFalse(questionMark("a??", "b"));
        assertFalse(questionMark("a??", "ab"));
        assertFalse(questionMark("a??", "ba"));
        assertTrue(questionMark("a??", "abc"));
        assertTrue(questionMark("a??", "acb"));
        assertFalse(questionMark("a??", "bac"));
        assertFalse(questionMark("a??", "bca"));
        assertFalse(questionMark("a??", "cba"));
        assertFalse(questionMark("a??", "abcd"));
        assertFalse(questionMark("?a?", "a"));
        assertFalse(questionMark("?a?", "b"));
        assertFalse(questionMark("?a?", "ab"));
        assertFalse(questionMark("?a?", "ba"));
        assertFalse(questionMark("?a?", "abc"));
        assertFalse(questionMark("?a?", "acb"));
        assertTrue(questionMark("?a?", "bac"));
        assertFalse(questionMark("?a?", "bca"));
        assertTrue(questionMark("?a?", "cab"));
        assertFalse(questionMark("?a?", "cba"));
        assertFalse(questionMark("?a?", "cabd"));
        assertFalse(questionMark("??a", "a"));
        assertFalse(questionMark("??a", "b"));
        assertFalse(questionMark("??a", "ab"));
        assertFalse(questionMark("??a", "ba"));
        assertFalse(questionMark("??a", "abc"));
        assertFalse(questionMark("??a", "acb"));
        assertFalse(questionMark("??a", "bac"));
        assertTrue(questionMark("??a", "bca"));
        assertTrue(questionMark("??a", "cba"));
        assertFalse(questionMark("??a", "cab"));
        assertFalse(questionMark("??a", "cbad"));
    }

    @Disabled
    @Test
    void mixed() {
        assertTrue(matched("*", "a"));
        assertTrue(matched("?", "a"));

        assertFalse(matched("?*", "#"));
        assertTrue(matched("?*", "a"));
        assertTrue(matched("?*", "ab"));
        assertTrue(matched("?*", "abc"));
        assertFalse(matched("*?", "a"));
        assertTrue(matched("*?", "ab"));
        assertTrue(matched("*?", "abc"));
    }

    private boolean matched(String regex, String text) {
        if (notInRange(text)) {
            return false;
        }
        Token[] regTokens = parse(regex.toLowerCase(Locale.ROOT));
        Token[] txtTokens = parse(text.toLowerCase(Locale.ROOT));
        boolean matched = true;
        for (int rIdx = 0;rIdx < regTokens.length && matched; rIdx++) {
            Token rt = regTokens[rIdx];
            if (isQuestionMark(rt.point)) {
                if (rt.index < txtTokens.length) {
                    if (!hasNextToken(rt, regTokens) && hasNextToken(txtTokens[rt.index], txtTokens)) {
                        matched = false;
                    }
                }else {
                    matched = false;
                }
            } else if (isAsterisk(rt.point)) {
                Token nextAlRt = findNextAlnumToken(rt.index, regTokens);
                if (nextAlRt != null) {
                    Token nextTxt = findSpecialToken(rt.index, nextAlRt.point, txtTokens);
                    if (nextTxt == null) {
                        matched = false;
                    } else if (nextAlRt.point != nextTxt.point) {
                        matched = false;
                    } else if (!hasNextToken(nextAlRt, regTokens) && hasNextDiffToken(nextTxt,txtTokens)) {
                        matched = false;
                    } else {
                        rIdx = nextAlRt.index;
                    }
                }
            }
        }
        return matched;
    }

    public static final int QUESTION_MARK_POINT = 63;

    private boolean questionMark(String regex, String text) {
        if (notInRange(text)) {
            return false;
        }
        Token[] regTokens = parse(regex.toLowerCase(Locale.ROOT));
        Token[] txtTokens = parse(text.toLowerCase(Locale.ROOT));
        boolean matched = true;
        for (int rIdx = 0;rIdx < regTokens.length && matched; rIdx++) {
            Token rt = regTokens[rIdx];
            if (isAlnum(rt.point)) {
                if (rt.index < txtTokens.length) {
                    if (!(rt.point == txtTokens[rt.index].point))
                        matched = false;
                    if (!hasNextToken(rt, regTokens) && hasNextToken(txtTokens[rt.index], txtTokens)) {
                        matched = false;
                    }
                } else {
                    matched = false;
                }
            } else if (isQuestionMark(rt.point)) {
                if (rt.index < txtTokens.length) {
                    if (!hasNextToken(rt, regTokens) && hasNextToken(txtTokens[rt.index], txtTokens)) {
                        matched = false;
                    }
                }else {
                    matched = false;
                }
            }
        }
        return matched;
    }

    private boolean isQuestionMark(int point) {
        return point == QUESTION_MARK_POINT;
    }

    public static final int ASTERISK_POINT = 42;

    private boolean dMatch(String reg, String text) {
        return reg.equals(text);
    }

    boolean asterisk(String regex, String text) {
        if (notInRange(text)) {
            return false;
        }
        Token[] regTokens = parse(regex.toLowerCase(Locale.ROOT));
        Token[] txtTokens = parse(text.toLowerCase(Locale.ROOT));
        if (regTokens.length == 1 && regTokens[0].point == ASTERISK_POINT) {
            return true;
        }
        boolean matched = true;
        for (int rIdx = 0;rIdx < regTokens.length && matched; rIdx++) {
            Token rt = regTokens[rIdx];
            if (isAlnum(rt.point)) {
                if (rt.index < txtTokens.length) {
                    if (!(rt.point == txtTokens[rt.index].point))
                        matched = false;
                } else {
                    matched = false;
                }
            } else if (isAsterisk(rt.point)) {
                Token nextAlRt = findNextAlnumToken(rt.index, regTokens);
                if (nextAlRt != null) {
                    Token nextTxt = findSpecialToken(rt.index, nextAlRt.point, txtTokens);
                    if (nextTxt == null) {
                        matched = false;
                    } else if (nextAlRt.point != nextTxt.point) {
                        matched = false;
                    } else if (!hasNextToken(nextAlRt, regTokens) && hasNextDiffToken(nextTxt,txtTokens)) {
                        matched = false;
                    } else {
                        rIdx = nextAlRt.index;
                    }
                }
            }
        }
        return matched;
    }

    private boolean hasNextToken(Token token, Token[] tokens) {
        return token.index < tokens.length - 1;
    }

    private boolean hasNextDiffToken(Token token, Token[] tokens) {
        OptionalInt idx = IntStream.range(token.index, tokens.length).filter(i->tokens[i].point != token.point).findFirst();
        return idx.isPresent();
    }

    private Token findSpecialToken(int start, int point, Token[] tokens) {
        OptionalInt idx = IntStream.range(start, tokens.length).filter(i->tokens[i].point == point).findFirst();
        if (idx.isPresent()) {
            return tokens[idx.getAsInt()];
        }
        return null;
    }


    private Token findNextAlnumToken(int start, Token[] tokens) {
        OptionalInt idx = IntStream.range(start + 1, tokens.length).filter(i->isAlnum(tokens[i].point)).findFirst();
        if (idx.isPresent()) {
            return tokens[idx.getAsInt()];
        }
        return null;
    }

    private boolean isAsterisk(int point) {
        return point == ASTERISK_POINT;
    }

    private Token[] parse(String str) {
        char[] charArray = str.toCharArray();
        Token[] result = new Token[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            result[i] = new Token(i, str.codePointAt(i));
        }
        return result;
    }

//    boolean asterisk(String regex, String text) {
//        regex = regex.toLowerCase(Locale.ROOT);
//        text = text.toLowerCase(Locale.ROOT);
//        String ts = "";
//        String rs = "";
//        int asIdx = regex.indexOf('*');
//        if (asIdx == 0) {
//            if (regex.length() == 1)
//                return true;
//            if (!inRange(text)) {
//                return false;
//            }
//            rs = findChars(regex, asIdx + 1);
//            return text.contains(rs);
//
//        } else {
//            ts = text.substring(0, asIdx);
//            rs = regex.substring(0, asIdx);
//        }
//        return ts.equals(rs);
//    }

    private String findChars(String string, int idx) {
        int startIdx = idx;
        int nextIdx = string.indexOf('*', startIdx);
        while (nextIdx == startIdx) {
            startIdx = nextIdx + 1;
            nextIdx = string.indexOf('*', startIdx);
        }
        if (nextIdx == -1) {
            nextIdx = string.length();
        }
        return string.substring(startIdx, nextIdx);
    }

    /*
    48-57：0-9
    65-90：A-Z
    97-122：a-z
     */
    private boolean notInRange(String text) {
        if (text.chars().anyMatch(i->isInValidChar(i)))
            return true;
        return false;
    }

    private boolean isAlnum(int i) {
        return (i >= 48  && i <= 57) ||
                (i >= 65 && i <= 90) ||
                (i >= 97 && i <= 122);
    }

    private boolean isInValidChar(int i) {
        return i < 48  ||
                (i > 57 && i < 65) ||
                (i > 90 && i < 97) ||
                i > 122;
    }

    class Token {
        int index ;
        int point ;
        int leftPoint = -1;
        int rightPoint = -1;

        public Token(int index, int point) {
            this.index = index;
            this.point = point;
        }
    }
}
