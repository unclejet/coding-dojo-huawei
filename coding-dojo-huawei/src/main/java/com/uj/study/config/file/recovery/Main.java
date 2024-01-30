package com.uj.study.config.file.recovery;

import com.uj.study.common.SuperMain;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/30 下午12:45
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        ConfigFileRecoveryUserInputReader reader = new ConfigFileRecoveryUserInputReader(lineReader);
        List<String> commands = reader.readCommands();
        for (String cmd :
                commands) {
            System.out.println(ConfigFileRecovery.execute(cmd));
        }
    }
}
