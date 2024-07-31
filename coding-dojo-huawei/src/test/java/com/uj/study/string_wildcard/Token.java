package com.uj.study.string_wildcard;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/5/7 下午12:28
 * @description：
 */
public abstract class Token {
    protected int index ;
    protected int point ;
    protected Token prevToken ;
    protected Token nextToken ;

    public Token(int index, int point) {
        this.index = index;
        this.point = point;
    }

    public void setPrevToken(Token prevToken) {
        this.prevToken = prevToken;
    }

    public void setNextToken(Token nextToken) {
        this.nextToken = nextToken;
    }

    public int getPoint() {
        return point;
    }

    public abstract boolean match(Indicator indicator, List<Token> txtTokens);

    protected boolean isAlnum(int i) {
        return (i >= 48 && i <= 57) ||
                (i >= 65 && i <= 90) ||
                (i >= 97 && i <= 122);
    }
}
