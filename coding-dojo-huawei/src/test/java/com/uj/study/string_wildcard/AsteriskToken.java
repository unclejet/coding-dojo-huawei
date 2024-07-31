package com.uj.study.string_wildcard;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/5/7 下午12:29
 * @description： *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 */
public class AsteriskToken extends Token {
    public AsteriskToken(int index, int point) {
        super(index, point);
    }

    @Override
    public boolean match(Indicator indicator, List<Token> txtTokens) {
        checkValid(this);

        for (int i = indicator.getTxtIdx(); i < txtTokens.size(); i++) {
            Token txtToken = txtTokens.get(i);
            if (txtToken.point == this.prevToken.point) {
                indicator.setTxtIdx(i + 1);
            } else {
                break;
            }
        }
        return true;
    }

    private void checkValid(AsteriskToken asteriskToken) {
        if (asteriskToken.prevToken == null || !isAlnum(asteriskToken.prevToken.getPoint())) {
            throw new PatternSyntaxException("Invalid pattern: * must be followed by an alphanumeric character",
                    "*", asteriskToken.index);
        }
    }
}
