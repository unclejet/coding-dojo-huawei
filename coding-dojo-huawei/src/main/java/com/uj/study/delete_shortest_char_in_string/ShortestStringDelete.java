package com.uj.study.delete_shortest_char_in_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/22 下午12:13
 * @description：
 */
public class ShortestStringDelete {

    public static String shortIt(String input) {
        List<String> shortestChars = getShortestChars(input);
        return Arrays.stream(input.split("")).filter(s -> !shortestChars.contains(s)).collect(Collectors.joining());
    }

    private static List<String> getShortestChars(String input) {
        Map<String, Long> shortChar = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map<Long, List<Map.Entry<String, Long>>> shortListMap = shortChar.entrySet().stream().collect(Collectors.groupingBy(e -> e.getValue()));
        Map<Long, List<String>> shortListMap = shortChar.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey,
                        Collectors.toList())));
        return shortListMap.size() <= 1 ? Collections.emptyList() : shortListMap.entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue();
    }
}
