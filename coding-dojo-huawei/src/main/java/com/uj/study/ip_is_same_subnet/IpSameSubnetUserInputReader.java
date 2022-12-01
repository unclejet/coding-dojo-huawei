package com.uj.study.ip_is_same_subnet;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/30 下午12:11
 * @description：
 */
public class IpSameSubnetUserInputReader extends BaseUserInputReader {
    public IpSameSubnetUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public List<String> readIps() {
        List<String> result = new ArrayList<>();
        String line = lineReader.readLine();
        while (!exit(line)) {
            result.add(line);
            line = lineReader.readLine();
        }
        padding(result);
        return result;
    }

    private void padding(List<String> ips) {
        int mod = ips.size() % 3;
        while (mod > 0 && mod++ < 3) {
            ips.add("");
        }
    }
}
