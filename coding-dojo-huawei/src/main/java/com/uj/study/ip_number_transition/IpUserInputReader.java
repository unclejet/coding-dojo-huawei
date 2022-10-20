package com.uj.study.ip_number_transition;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.stream.Stream;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/17 下午12:26
 * @description：
 */
public class IpUserInputReader extends ValidLineReader {

    public IpUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readIp() {
        return readValidLine("please input correct ip like: 10.0.0.1");
    }

    @Override
    protected boolean isValidString(String line) {
        try {
            String[] arr = line.split("\\.");
            return arr.length == 4 && Stream.of(arr).map(Integer::parseInt).allMatch(n-> n <= 255 && n >= 0);
        } catch (Exception e){
            return false;
        }
    }

}
