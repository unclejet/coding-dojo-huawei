package com.uj.study.dna;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.Arrays;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/3 下午12:47
 * @description：
 */
public class DnaSequenceReader  {
    private FirstLineReader firstLineReader;
    private SecondLineReader secondLineReader;

    public DnaSequenceReader(LineReader lineReader) {
        firstLineReader = new FirstLineReader(lineReader);
        secondLineReader = new SecondLineReader(lineReader);
    }

    public void read() {
        firstLineReader.readStr();
        secondLineReader.readNumber(firstLineReader.acgtStr.length());
    }

    public String getFirstLine() {
        return firstLineReader.acgtStr;
    }

    public int getSecondLine() {
        return secondLineReader.number;
    }

    class FirstLineReader extends ValidLineReader {
        private String acgtStr;

        public FirstLineReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            return (line.length() >= 1 && line.length() <= 1000) &&
                    isACGT(line);
        }

        private boolean isACGT(String line) {
            return Arrays.stream(line.split("")).allMatch(c -> "ACGT".contains(String.valueOf(c)));
        }

        public void readStr() {
            acgtStr = readValidLine("please input ACGT String length >= 1 and <= 1000");
        }
    }

    class SecondLineReader extends ValidLineReader {
        private int acgtLength;
        private int number;

        public SecondLineReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            return isInteger(line) && getInteger(line) <= acgtLength;
        }

        public void readNumber(int strLength) {
            acgtLength = strLength;
            String line = readValidLine("please input a number less than " + strLength);
            number = getInteger(line);
        }
    }
}
