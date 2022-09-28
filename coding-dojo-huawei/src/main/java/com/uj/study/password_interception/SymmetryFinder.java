package com.uj.study.password_interception;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SymmetryFinder {
    private List<Range> findSymmetryRanges(char[] chars) {
        List<Range> ranges = new ArrayList<>();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = chars.length - 1; j > i; j--) {
                if (chars[i] == chars[j])
                    ranges.add(new Range(i, j));
            }
        }
        return ranges;
    }

    public int findMaxSymmetryLength(String input) {
        char[] chars = input.toCharArray();
        List<Range> symmetryRangesCandidate = findSymmetryRanges(chars);
        symmetryRangesCandidate.sort(Comparator.comparing(Range::getLength).reversed());
        for (Range range : symmetryRangesCandidate) {
            if (isAllSymWithinRange(chars, range)) {
                return range.getLength();
            }
        }
        return 0;
    }

    private boolean isAllSymWithinRange(char[] chars, Range range) {
        for (int s = range.getNextIdx(), e = range.getPreviousIdx(); s <= e; s++, e--) {
            if (chars[s] != chars[e])
                return false;
        }
        return true;
    }
}