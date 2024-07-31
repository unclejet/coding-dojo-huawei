package com.uj.study.string_wildcard;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/5/7 下午12:29
 * @description：
 * * 实现如下2个通配符：
 *  * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 *  * ？：匹配1个字符
 *  * 注意：匹配时不区分大小写。
 */
public class QuestionMarkToken extends Token {
    public QuestionMarkToken(int index, int point) {
        super(index, point);
    }

    @Override
    public boolean match(Indicator indicator, List<Token> txtTokens) {
        checkValid(this);
        if (txtTokens.isEmpty())
            return false;
        if (indicator.getTxtIdx() < txtTokens.size() &&
                this.prevToken.point == txtTokens.get(indicator.getTxtIdx()).getPoint()) {
            indicator.setTxtIdx(indicator.getTxtIdx() + 1);
            return true;
        }
        return false;
//        if (indicator.getTxtIdx() >= txtTokens.size())
//            return false;
//        int tp = txtTokens.get(indicator.getTxtIdx()).getPoint();
//        indicator.setTxtIdx(indicator.getTxtIdx() + 1);
//        return isAlnum(tp);
    }

    private void checkValid(QuestionMarkToken questionMarkToken) {
        if (questionMarkToken.prevToken == null || !isAlnum(questionMarkToken.prevToken.getPoint())) {
            throw new PatternSyntaxException("Invalid pattern: ? must be followed by an alphanumeric character",
                    "?", questionMarkToken.index);
        }
    }
}
