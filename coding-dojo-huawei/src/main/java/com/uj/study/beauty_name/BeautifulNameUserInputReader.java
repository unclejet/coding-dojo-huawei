package com.uj.study.beauty_name;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/5 下午12:49
 * @description：
 */
public class BeautifulNameUserInputReader {
    LinesNumUserInputReader linesNumUserInputReader;
    LinesContentInputReader linesContentInputReader;

    public BeautifulNameUserInputReader(LineReader lineReader) {
        linesNumUserInputReader = new LinesNumUserInputReader(lineReader);
        linesContentInputReader = new LinesContentInputReader(lineReader);
    }

    int readLinesNumber() {
        return linesNumUserInputReader.readNumber();
    }

    public List<String> readLinesContent(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(linesContentInputReader.readLineContent());
        }
        return result;
    }

    class LinesNumUserInputReader extends ValidLineReader {
        public LinesNumUserInputReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            if (isInteger(line)) {
                int num = Integer.parseInt(line);
                return num >= 1;
            }
            return false;
        }

        int readNumber() {
            return Integer.parseInt(readValidLine("Please input a number: "));
        }
    }

    class LinesContentInputReader extends ValidLineReader {
        public final Pattern LOWER_CASE = Pattern.compile("\\p{Lower}+");

        public LinesContentInputReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            return LOWER_CASE.matcher(line).matches() &&
                    (line.strip().length() >= 1 && line.length() <= 10000);
        }

        String readLineContent() {
            return readValidLine("please input valid line 1≤length≤10000");
        }
    }
}
