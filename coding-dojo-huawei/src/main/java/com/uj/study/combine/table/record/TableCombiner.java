package com.uj.study.combine.table.record;

import java.util.*;
import java.util.stream.Collectors;

public class TableCombiner {
    public static List<Pair> combineTable(List<Pair> inputs) {
        Map<Integer, List<Pair>> numberByKey = inputs.stream().collect(Collectors.groupingBy(Pair::getKey));
        List<Pair> result = new ArrayList<>();
        numberByKey.forEach((key, value)->{
            Integer sum = value.stream().collect(Collectors.summingInt(Pair::getValue));
            result.add(new Pair(key, sum));
        });
        result.stream().sorted(Comparator.comparingInt(Pair::getKey));
        return result;
    }
}
