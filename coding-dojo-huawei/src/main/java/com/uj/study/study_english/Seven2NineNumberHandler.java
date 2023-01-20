package com.uj.study.study_english;

import static com.uj.study.study_english.EnglishNumberDict.MILLION;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:42
 * @description：
 */
public class Seven2NineNumberHandler extends RangeNumberHandler {

    protected Seven2NineNumberHandler() {
        super(new Four2SixNumberHandler());
    }

    @Override
    protected String getDigitLabel() {
        return MILLION;
    }

    @Override
    protected int getDigitIndex(char[] nums) {
        return nums.length - 6;
    }
}
