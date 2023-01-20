package com.uj.study.study_english;

import static com.uj.study.study_english.EnglishNumberDict.THOUSAND;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:43
 * @description：
 */
public class Four2SixNumberHandler extends RangeNumberHandler {

    protected Four2SixNumberHandler() {
        super(new ThreeNumbersHandler());
    }

    @Override
    protected String getDigitLabel() {
        return THOUSAND;
    }

    @Override
    protected int getDigitIndex(char[] nums) {
        return nums.length - 3;
    }
}
