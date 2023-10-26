package com.uj.study.smallest;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/24 下午12:50
 * @description：
 */
public class SmallestIntegerKGeneratorReader {
    private FirstLineReader firstLineReader;
    private SecondLineReader secondLineReader;

    public SmallestIntegerKGeneratorReader(LineReader lineReader) {
        firstLineReader = new FirstLineReader(lineReader);
        secondLineReader = new SecondLineReader(lineReader);
    }

    public void read() {
        readFirstLine();
        readSecondLine(firstLineReader.getArraySize());
    }

    void readFirstLine() {
        firstLineReader.readTwoIntegers();
    }

    void readSecondLine(int size) {
        secondLineReader.readArray(size);
    }

    public int getArraySize() {
        return firstLineReader.getArraySize();
    }

    public int getKNumber() {
        return firstLineReader.getKNumber();
    }

    public int[] getArray() {
        return secondLineReader.getArray();
    }

    class FirstLineReader extends ValidLineReader {
        private int arraySize;
        private int kNumber;

        public FirstLineReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            String[] n_str = line.split("\\p{Space}+");
            try {
                if (n_str.length == 2) {
                    int arrSize = Integer.parseInt(n_str[0]);
                    int k = Integer.parseInt(n_str[1]);
                    return arrSize >= k && (arrSize >= 1 && arrSize <= 1000) && (k >= 1 && k <= 1000);
                }
            } catch (NumberFormatException e) {
            }
            return false;
        }

        public int getArraySize() {
            return arraySize;
        }

        public int getKNumber() {
            return kNumber;
        }

        public void readTwoIntegers() {
            String line = readValidLine("please input two numbers >=1 <= 1000 like 5 2:");
            generateData(line);
        }

        private void generateData(String line) {
            String[] n_str = line.split("\\p{Space}+");
            arraySize = Integer.parseInt(n_str[0]);
            kNumber = Integer.parseInt(n_str[1]);
        }
    }

    class SecondLineReader extends ValidLineReader {
        private int[] array;
        private int size;

        public SecondLineReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            String[] n_str = line.split("\\p{Space}+");
            if (size == n_str.length) {
                try {
                    for (String s : n_str) {
                        int n = Integer.parseInt(s);
                        if (n < 1 || n > 10000)
                            return false;
                    }
                    return true;
                } catch (NumberFormatException e) {
                }
            }
            return false;
        }

        public void readArray(int size) {
            this.size = size;
            String line = readValidLine("Please input " + size + " number separated by space: like 1 3 5 7 2:");
            generateArray(line);
        }

        private void generateArray(String line) {
            array = new int[size];
            String[] n_str = line.split("\\p{Space}+");
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(n_str[i]);
            }
        }

        public int[] getArray() {
            return array;
        }
    }
}
