package com.uj.study.find_code_error;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/4/19 上午11:53
 * @description：
 */
public class CodeFileErrorRecored {
    private String filename;
    private String score;

    public CodeFileErrorRecored(String line) {
        fit(line);
    }

    private void fit(String line) {
        String[] strings = line.split("\\s");
        filename = strings[0].substring(strings[0].lastIndexOf('\\') + 1);
        score = strings[1];
    }

    public String getFilename() {
        return filename;
    }

    public String getScore() {
        return score;
    }
}
