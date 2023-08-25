package com.uj.study.oneway_list_k_node;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;
import com.uj.study.prime.partner.PrimeFactorUserInputNumberReader;

import java.util.Arrays;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/24 下午12:53
 * @description：
 */
public class OnewayListKNodeUserInputReader {
    private LengthReader lengthReader;
    private DataReader dataReader;
    private KReader kReader;

    public OnewayListKNodeUserInputReader(LineReader lineReader) {
        lengthReader = new LengthReader(lineReader);
        dataReader = new DataReader(lineReader);
        kReader = new KReader(lineReader);
    }

    public int readLength() {
        return lengthReader.readLength();
    }

    public int[] readNodeData(int length) {
        return dataReader.readData(length);
    }

    public int readK(int length) {
        return kReader.readK(length);
    }




    class LengthReader extends ValidLineReader {
        LengthReader(LineReader lineReader) {
            super(lineReader);
        }

        int readLength() {
            String line = readValidLine("Please input number between 1-1000:");
            return Integer.parseInt(line);
        }

        @Override
        protected boolean isValidString(String line) {
            try {
                int n = Integer.parseInt(line);
                return n >= 1 && n <= 1000;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    class DataReader extends ValidLineReader {
        private int length;

        DataReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            int[] data = strArr2IntArr(line);
            if (data != null && data.length == this.length) {
                return !Arrays.stream(data).anyMatch(i->i < 0 || i > 10000);
            }
            return false;
        }

        int[] readData(int length) {
            this.length = length;
            String line = readValidLine("please input " + length + " number between 0-10000:");
            return strArr2IntArr(line);
        }

        private int[] strArr2IntArr(String line) {
            try {
                return Arrays.stream(line.split("\\p{Space}")).mapToInt(Integer::parseInt).toArray();
            } catch (Exception e) {
                return null;
            }
        }
    }

    class KReader extends ValidLineReader {
        private int length;

        KReader(LineReader lineReader) {
            super(lineReader);
        }

        int readK(int length) {
            this.length = length;
            String line = readValidLine("Please input number <= " + length);
            return Integer.parseInt(line);
        }

        @Override
        protected boolean isValidString(String line) {
            try {
                int k = Integer.parseInt(line);
                return k <= length;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }


}
