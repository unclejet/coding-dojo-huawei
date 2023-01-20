package com.uj.study.study_english;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.uj.study.study_english.EnglishNumberDict.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:30
 * @description：
 */
public class ThreeNumbersHandler extends BaseNumberHandler {
    public ThreeNumbersHandler() {
        super(new TwoNumbersHandler());
    }

    @Override
    public List<String> handleNumbers(char[] nums) {
        List<String> labels = super.handleNumbers(nums);
        if (labels.size() > 2) {
            labels.add(2, AND);
        }
        return labels;
    }

    @Override
    protected List<String> handleCurrentDigit(char[] nums) {
        List<String> labels = new ArrayList<>();
        if (nums[0] != '0') {
            labels.add(String.valueOf(nums[0]));
            labels.add(HUNDRED);
        }
        return labels;
    }

    @Override
    protected char[] getOtherNums(char[] nums) {
        return Arrays.copyOfRange(nums, 1, nums.length);
    }
}
