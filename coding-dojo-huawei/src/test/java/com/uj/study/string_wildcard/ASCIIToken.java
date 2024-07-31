package com.uj.study.string_wildcard;

import java.util.List;

import static com.uj.study.string_wildcard.TokenFactory.ASTERISK_POINT;
import static com.uj.study.string_wildcard.TokenFactory.QUESTION_MARK_POINT;

public class ASCIIToken extends Token {
    public ASCIIToken(int index, int point) {
        super(index, point);
    }

    @Override
    public boolean match(Indicator indicator, List<Token> txtTokens) {
        if (this.nextToken != null && (this.nextToken.point == ASTERISK_POINT || this.nextToken.point == QUESTION_MARK_POINT))
            return true;
        int tp = indicator.getTxtIdx() < txtTokens.size() ? txtTokens.get(indicator.getTxtIdx()).getPoint() : -1;
        indicator.setTxtIdx(indicator.getTxtIdx() + 1);
        return tp == point;
    }
}
