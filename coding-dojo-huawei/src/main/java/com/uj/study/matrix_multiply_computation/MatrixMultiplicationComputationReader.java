package com.uj.study.matrix_multiply_computation;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/20 下午12:50
 * @description：
 */
public class MatrixMultiplicationComputationReader{
    private MatrixReader matrixReader;
    private RuleReader ruleReader;

    public MatrixMultiplicationComputationReader(LineReader lineReader) {
        matrixReader = new MatrixReader(lineReader);
        ruleReader = new RuleReader(lineReader);
    }

    public Map<String, Matrix> readMatrix() {
        return matrixReader.getMatrix();
    }

    public String readRule() {
        return ruleReader.read();
    }


    class MatrixReader extends ValidLineReader {
        private MatrixNumberReader matrixNumberReader;
        private Map<String, Matrix> matrixMap = new HashMap<>();
        public MatrixReader(LineReader lineReader) {
            super(lineReader);
            matrixNumberReader = new MatrixNumberReader(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            String[] ma = line.strip().split("\\s+");
            if (ma.length == 2) {
                int row = getInteger(ma[0]);
                int column = getInteger(ma[1]);
                return (row >= 1 && row <= 100) && (column >= 1 && column <= 100);
            }
            return false;
        }

        private void readMatrix(int number) {
            char letter = 'A';
            for (int i = 0; i < number; i++) {
                String line = readValidLine("please input matrix row and column like 50 20");
                String[] ma = line.strip().split("\\s+");
                int row = getInteger(ma[0]);
                int column = getInteger(ma[1]);
                matrixMap.put(String.valueOf(letter), new Matrix(row, column));
                letter = getNextLetter(letter);
            }
        }

        public char getNextLetter(char letter) {
            return (char) (letter + 1);
        }

        public Map<String, Matrix> getMatrix() {
            readMatrix(matrixNumberReader.readNumber());
            return matrixMap;
        }

        private class MatrixNumberReader extends ValidLineReader {

            public MatrixNumberReader(LineReader lineReader) {
                super(lineReader);
            }

            public int readNumber() {
                String line = readValidLine("please input matrix number between 1 and 15:");
                return getInteger(line);
            }

            @Override
            protected boolean isValidString(String line) {
                int n = getInteger(line);
                return n >= 1 && n <= 15;
            }
        }
    }

    class RuleReader extends ValidLineReader {
        public final Pattern RULE_PATTERN = Pattern.compile("^[\\)\\(A-Z]+$");
        public RuleReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            return RULE_PATTERN.matcher(line).matches();
        }

        public String read() {
            return readValidLine("Please input rule like (A(BC))");
        }
    }
}
