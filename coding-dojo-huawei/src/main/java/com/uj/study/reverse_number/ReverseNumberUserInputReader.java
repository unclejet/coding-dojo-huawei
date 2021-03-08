package com.uj.study.reverse_number;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/1/26 上午11:43
 * @description：
 */
public class ReverseNumberUserInputReader extends UserInputReader {
    public ReverseNumberUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readNumberStr() {
        String inputStr = lineReader.readLine();
        while (!isValidInput(inputStr)) {
            System.out.println("please input positive number:");
            inputStr = lineReader.readLine();
        }
        return inputStr;
    }

    private boolean isValidInput(String inputStr) {
        return isInteger(inputStr) && isPositive(inputStr) ? true : false;
    }

    private boolean isPositive(String inputStr) {
        return inputStr.startsWith("-") ? false : true;
    }

}
