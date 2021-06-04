package com.uj.study.ip_identity.io;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/8 下午12:02
 * @description：
 */
public class IpNetmaskUserInputReader extends BaseUserInputReader {

    public static final Pattern IP_PATTERN = Pattern.compile("(\\d*\\.){3}?\\d*~(\\d*\\.){3}?\\d*");

    public IpNetmaskUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public Map<String, String> readInput() {
        Map<String, String> result = new HashMap<>();
//        List<Map<String, String>> validInputs = new ArrayList<>();
        String line = lineReader.readLine();
        while (!exit(line)) {
            if (IP_PATTERN.matcher(line).matches()) {
                String[] split =  line.split("~");
                result.put(split[0], split[1]);
            } else {
                System.out.println("Please input <ip>~<netmask> like this: 192.168.0.2~255.255.255.0");
            }
            line = lineReader.readLine();
        }
        return result;
    }
}
