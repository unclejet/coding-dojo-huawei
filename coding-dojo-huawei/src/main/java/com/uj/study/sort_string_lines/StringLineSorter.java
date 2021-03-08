package com.uj.study.sort_string_lines;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/8 下午5:25
 * @description：
 */
public class StringLineSorter {
    public static List<String> sort(List<String> lines) {
        return lines.stream().sorted().collect(Collectors.toList());
    }
}
