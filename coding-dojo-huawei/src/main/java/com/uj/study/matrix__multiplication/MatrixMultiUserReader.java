package com.uj.study.matrix__multiplication;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.Arrays;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/28 下午12:49
 * @description：
 */
public class MatrixMultiUserReader {
    PositiveIntegerReader positiveIntegerReader;
    MatrixReader matrixReader;

    public MatrixMultiUserReader(LineReader lineReader) {
        positiveIntegerReader = new PositiveIntegerReader(lineReader);
        matrixReader = new MatrixReader(lineReader);
    }

    public int readRow() {
        System.out.println("please input row:");
        return readPositiveNumber();
    }

    public int readY() {
        System.out.println("please input y:");
        return readPositiveNumber();
    }

    public int readColumn() {
        System.out.println("please input column:");
        return readPositiveNumber();
    }

    int readPositiveNumber() {
        return positiveIntegerReader.readNumber();
    }

    public int[] readArrA(int row, int column) {
        System.out.println("please input array A:");
        return matrixReader.readMatrix(row, column);
    }

    public int[] readArrB(int row, int column) {
        System.out.println("please input array B:");
        return matrixReader.readMatrix(row, column);
    }

    int[] readMatrix(int row, int column) {
        return matrixReader.readMatrix(row, column);
    }

    class PositiveIntegerReader extends ValidLineReader {

        public PositiveIntegerReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            if (isInteger(line)) {
                int n = getInteger(line);
                return n >= 1 && n <= 100;
            }
            return false;
        }

        int readNumber() {
            return getInteger(readValidLine("Please input number between 1 and 100"));
        }
    }

    class MatrixReader extends ValidLineReader {
        private int row;
        private int column;

        public MatrixReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            int[] arr = strArr2IntArr(line);
            if (arr != null) {
                return arr.length == column;
            }
            return false;
        }

        public int[] readMatrix(int row, int column) {
            this.row = row;
            this.column = column;
            int[] result = new int[row * column];
            for (int i = 0, idx = 0; i < row; i++) {
                int[] arr = strArr2IntArr(readValidLine("please input matrix data at " + (i + 1) + " row, almost" + row + " row and " + column + " cloumn:"));
                System.arraycopy(arr, 0, result, idx, arr.length);
                idx += arr.length;
            }
            return result;
        }

        private int[] strArr2IntArr(String line) {
            try {
                return Arrays.stream(line.strip().split("\\p{Space}+")).mapToInt(Integer::parseInt).toArray();
            } catch (Exception e) {
                return null;
            }
        }
    }
}
