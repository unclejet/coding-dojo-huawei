package com.uj.study.config.file.recovery;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/24 下午12:37
 * @description：
 */
public class CommandExecutor {
    private String command;
    private String result;

    public CommandExecutor(String command, String result) {
        this.command = command;
        this.result = result;
    }

    public String getCommand() {
        return command;
    }

    public String getResult() {
        return result;
    }
}
