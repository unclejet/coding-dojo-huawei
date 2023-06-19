package com.uj.study.beauty_name;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/19 下午12:36
 * @description：
 */
public class BeautifulName {
    public static long countChars(String s) {
        Map<Integer, Long> m = s.chars().boxed().collect(groupingBy(Function.identity(), counting()));
        AtomicLong count = new AtomicLong(26);
        return m.values().stream().sorted(Comparator.reverseOrder()).mapToLong(l -> l * count.getAndDecrement()).sum();
    }
}
