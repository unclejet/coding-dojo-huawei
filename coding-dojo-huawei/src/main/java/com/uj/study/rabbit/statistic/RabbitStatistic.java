package com.uj.study.rabbit.statistic;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/14 下午12:27
 * @description：
 */
public class RabbitStatistic {
    public static int statistic(int months) {
        if (months <= 2) {
            return 1;
        }
        int count = 2;
        for (int monthIdx = 3, factor = 1; monthIdx < months; monthIdx++, factor++)
            count += factor;
        return count;
    }
}
