package com.uj.study.study_english;

import static com.uj.study.study_english.EnglishNumberDict.BILLION;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:41
 * @description：
 */
public class Ten2TwelveNumberHandler extends RangeNumberHandler {

    protected Ten2TwelveNumberHandler() {
        super(new Seven2NineNumberHandler());
    }

    @Override
    protected String getDigitLabel() {
        return BILLION;
    }

    @Override
    protected int getDigitIndex(char[] nums) {
        return nums.length - 9;
    }
}
