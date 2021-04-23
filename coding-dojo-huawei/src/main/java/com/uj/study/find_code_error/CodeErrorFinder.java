package com.uj.study.find_code_error;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/4/22 下午12:01
 * @description：
 */
public class CodeErrorFinder {
    public static Map<String, List<CodeFileErrorRecored>> handleRecords(List<CodeFileErrorRecored> recoredList) {
        return recoredList.stream().collect(Collectors.groupingBy(CodeFileErrorRecored::getFilename));
    }

    public static List<String> report(Map<String, List<CodeFileErrorRecored>> listMap) {
        return listMap.size() > 8 ?
                listMap.values().stream().skip(listMap.size() - 8).map(list -> format(list)).collect(Collectors.toList())
                : listMap.values().stream().map(list -> format(list)).collect(Collectors.toList());
    }

    private static String format(List<CodeFileErrorRecored> list) {
        CodeFileErrorRecored recored = list.get(0);
        return String.format("%s %s %s", formatFileName(recored.getFilename()), recored.getScore(), list.size());
    }

    private static String formatFileName(String filename) {
        return filename.length() > 16 ? filename.substring(0, 16) : filename;
    }
}
