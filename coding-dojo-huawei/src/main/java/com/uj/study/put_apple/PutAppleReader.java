package com.uj.study.put_apple;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/19 下午12:26
 * @description：
 */
public class PutAppleReader extends ValidLineReader {
    private int apple;
    private int plate;

    public PutAppleReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        String[] arr = line.split("\\s");
        if (arr.length == 2) {
            int apple = getInteger(arr[0]);
            int plate = getInteger(arr[1]);
            return (apple >= 0 && apple <= 10) && (plate >= 1 && plate <= 10);
        }
        return false;
    }

    public void readAppleAndPlateNumber() {
        String line = readValidLine("please input m and n like 7 3:");
        String[] arr = line.split("\\s");
        apple = getInteger(arr[0]);
        plate = getInteger(arr[1]);
    }

    public int getApple() {
        return apple;
    }

    public int getPlate() {
        return plate;
    }
}
