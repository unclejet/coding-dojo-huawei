package com.uj.study.common.input;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/4/29 下午12:40
 * @description：
 */

public abstract class ValidLineReader extends UserInputReader {
    public ValidLineReader(LineReader lineReader) {
        super(lineReader);
    }

    public  String readValidLine(String remindMsg) {
        String line = lineReader.readLine();
        while (!isValidString(line)) {
            System.out.println(remindMsg);
            line = lineReader.readLine();
        }
        return line;
    }

    protected abstract boolean isValidString(String line);
}
