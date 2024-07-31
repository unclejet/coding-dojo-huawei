package com.uj.study.string_wildcard;

import java.util.ArrayList;
import java.util.List;

public class TokenFactory {
    public static final int QUESTION_MARK_POINT = 63;
    public static final int ASTERISK_POINT = 42;

    private TokenFactory() {
    }

    public static List<Token> parse(String str) {
        List<Token> result = new ArrayList<>();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Token token;
            int p = str.toLowerCase().codePointAt(i);
            if (p == QUESTION_MARK_POINT) {
                token = new QuestionMarkToken(i, p);
            } else if (p == ASTERISK_POINT) {
                token = new AsteriskToken(i, p);
            } else
                token = new ASCIIToken(i, p);
            result.add(token);
        }
        assembleTokens(result);
        return result;
    }

    private static void assembleTokens(List<Token> result) {
        for (int i = 0; i < result.size(); i++) {
            Token token = result.get(i);
            if (i > 0) {
                token.setPrevToken(result.get(i - 1));
            }
            if (i < result.size() - 1) {
                token.setNextToken(result.get(i + 1));
            }
        }
    }
}
