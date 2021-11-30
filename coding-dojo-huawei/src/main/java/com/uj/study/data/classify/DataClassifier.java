package com.uj.study.data.classify;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/23 下午12:12
 * @description：
 */
public class DataClassifier {

    public static final String DELIMITER = " ";

    public static List<String> sortSequenceR(String[] sequ) {
        return Arrays.stream(sequ).distinct().sorted().collect(Collectors.toList());
    }

    public static List<DataInput> structureSequenceI(String[] sequenceI) {
        return IntStream.range(0, sequenceI.length).mapToObj(si->structure(si, sequenceI[si])).collect(Collectors.toList());
    }

    private static DataInput structure(int i, String si) {
        return DataInput.builder().index(i).data(si).build();
    }

    public static String classify(String[] sr, String[] si) {
        List<String> sortedSr = sortSequenceR(sr);
        List<DataInput> siList = structureSequenceI(si);
        String result = sortedSr.stream().map(s -> doClassify(s, siList)).collect(Collectors.joining(DELIMITER));
        if (result.startsWith(DELIMITER)) {
            result = result.substring(1);
        }
        int size = result.split(DELIMITER).length;
        return (size + DELIMITER + result);
    }

    private static String doClassify(String s, List<DataInput> siList) {
        List<DataInput> matchedList = siList.stream().filter(dataInput -> dataInput.getData().contains(s)).collect(Collectors.toList());
        if (matchedList.isEmpty()) {
            return StringUtils.EMPTY;
        }
        String str = matchedList.stream().map(DataInput::toString).collect(Collectors.joining(DELIMITER));
        return s + DELIMITER + matchedList.size() + DELIMITER + str;
    }
}
