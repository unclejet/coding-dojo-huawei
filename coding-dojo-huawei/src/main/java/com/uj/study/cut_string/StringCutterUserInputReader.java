package com.uj.study.cut_string;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/19 下午12:54
 * @description：
 */
public class StringCutterUserInputReader  {
    private StringReader stringReader;
    private NumberReader numberReader;

    public StringCutterUserInputReader(LineReader lineReader) {
        stringReader = new StringReader(lineReader);
        numberReader = new NumberReader(lineReader);
    }

    public String readString() {
        return stringReader.read();
    }

    public int readNumber(int strLength) {
        return numberReader.read(strLength);
    }

    class StringReader extends ValidLineReader {

        public StringReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            return line.strip().length() >= 1 && line.strip().length() <= 1000;
        }

        String read() {
            return readValidLine("Please input string 字符串长度满足 1≤n≤1000 1≤n≤1000:");
        }
    }

    class NumberReader extends ValidLineReader {
        private int length;

        public NumberReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            if (isInteger(line)) {
                int i = Integer.parseInt(line);
                return i >= 1 && i <= length;
            }
            return false;
        }

        int read(int strLength) {
            length = strLength;
            return Integer.parseInt(readValidLine("please input number between 1 and " + length + " :"));
        }
    }
}
