package com.uj.study.find_code_error;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/4/19 上午11:41
 * @description：
 */
public class CodeErrorFinderUserInputReader extends BaseUserInputReader {
    public static final Pattern ERROR_FILE_FORMAT = Pattern.compile("^[\\w:\\\\]+\\s+\\d+$");
    public CodeErrorFinderUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public List<CodeFileErrorRecored> readCodeFileErrorRecords() {
        List<CodeFileErrorRecored> result = new ArrayList<>();
        String line = lineReader.readLine();
        while (!line.equals("q")) {
            if (ERROR_FILE_FORMAT.matcher(line).matches()) {
                result.add(new CodeFileErrorRecored(line));
            }
            line = lineReader.readLine();
        }
        return result;
    }
}
