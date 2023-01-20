package com.uj.study.study_english;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:26
 * @description：
 */
public abstract class BaseNumberHandler implements NumberHandler {
    private NumberHandler nextNumbersHandler;

    protected BaseNumberHandler(NumberHandler nextNumbersHandler) {
        this.nextNumbersHandler = nextNumbersHandler;
    }

    public List<String> handleNumbers(char[] nums) {
        List<String> labels = new ArrayList<>();
        labels.addAll(handleCurrentDigit(nums));
        if (nextNumbersHandler != null) {
            labels.addAll(nextNumbersHandler.handleNumbers(getOtherNums(nums)));
        }
        return labels;
    }

    protected abstract List<String> handleCurrentDigit(char[] nums);
    protected abstract char[] getOtherNums(char[] nums);
}
