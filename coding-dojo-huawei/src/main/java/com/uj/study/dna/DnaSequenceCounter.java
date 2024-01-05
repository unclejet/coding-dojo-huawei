package com.uj.study.dna;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DnaSequenceCounter {
    public static final String C = "C";
    public static final String G = "G";

    public DnaSequenceCounter() {
    }

    static String gcRatio(String dna, int length) {
        List<String> dnaList = splitStrByLength(dna, length);
        Optional<String> result = dnaList.stream().max(Comparator.comparing(s -> numberOfCG(s)));
        return result.get();
    }

    static int numberOfCG(String dnaStr) {
        int count = 0;
        String[] split = dnaStr.split("");
        for (String s : split) {
            if (C.equals(s) || G.equals(s))
                count++;
        }
        return count;
    }

    static List<String> splitStrByLength(String dna, int length) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < dna.length(); i++) {
            String lengthStr = dna.substring(i, i + length <= dna.length() ? i + length : dna.length());
            if (lengthStr.length() == length)
                result.add(lengthStr);
            else
                break;
        }
        return result;
    }
}