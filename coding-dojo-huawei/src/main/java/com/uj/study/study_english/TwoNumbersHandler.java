package com.uj.study.study_english;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:29
 * @description：
 */
public class TwoNumbersHandler extends BaseNumberHandler {
    public TwoNumbersHandler() {
        super(null);
    }

    @Override
    protected List<String> handleCurrentDigit(char[] nums) {
        List<String> labels = new ArrayList<>();
        if (nums[1] == '0' || nums[0] == '1') { //十位数无规则英文字符处理
            if (nums[0] != '0')
                labels.add(nums[0] + String.valueOf(nums[1]));
        } else {
            if (nums[0] != '0')
                labels.add(nums[0] + "0"); //处理十位
            if (nums[1] != '0')
                labels.add(String.valueOf(nums[1])); //处理个位
        }
        return labels;
    }

    @Override
    protected char[] getOtherNums(char[] nums) {
        return nums;
    }
}
