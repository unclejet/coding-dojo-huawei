package com.uj.study.study_english;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:27
 * @description：
 */
public abstract class RangeNumberHandler extends BaseNumberHandler {

    protected RangeNumberHandler(NumberHandler nextNumbersHandler) {
        super(nextNumbersHandler);
    }

    @Override
    protected List<String> handleCurrentDigit(char[] nums) {
        List<String> labels = new ArrayList<>();
        if (nums[0] != '0') {
            char[] currantDigitRangeNums = Arrays.copyOfRange(nums, 0, getDigitIndex(nums));
            labels.addAll(getNumberHandler(currantDigitRangeNums.length).handleNumbers(currantDigitRangeNums));
            labels.add(getDigitLabel());
        }
        return labels;
    }

    @Override
    protected char[] getOtherNums(char[] nums) {
        return Arrays.copyOfRange(nums, getDigitIndex(nums), nums.length);
    }

    private NumberHandler getNumberHandler(int numbersLength) {
        if (numbersLength == 1) {
            return new OneNumberHandler();
        }
        if (numbersLength == 2) {
            return new TwoNumbersHandler();
        }
        if (numbersLength == 3) {
            return new ThreeNumbersHandler();
        }
        return null;
    }

    protected abstract String getDigitLabel();
    protected abstract int getDigitIndex(char[] nums);
}
