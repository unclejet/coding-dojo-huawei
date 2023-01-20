package com.uj.study.study_english;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:28
 * @description：
 */
public class OneNumberHandler  extends BaseNumberHandler {
    public OneNumberHandler() {
        super(null);
    }

    @Override
    protected List<String> handleCurrentDigit(char[] nums) {
        List<String> labels = new ArrayList<>();
        labels.add(String.valueOf(nums[0]));
        return labels;
    }

    @Override
    protected char[] getOtherNums(char[] nums) {
        return nums;
    }
}
