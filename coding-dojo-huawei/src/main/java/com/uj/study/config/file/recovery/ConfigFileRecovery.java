package com.uj.study.config.file.recovery;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConfigFileRecovery {
    public static final String UNKNOWN_COMMAND = "unknown command";

    static List<CommandExecutor> commandExecutorList = new ArrayList<>();
    static {
        ConfigFileRecovery.commandExecutorList.add(new CommandExecutor("reset", "reset what"));
        ConfigFileRecovery.commandExecutorList.add(new CommandExecutor("reset board", "board fault"));
        ConfigFileRecovery.commandExecutorList.add(new CommandExecutor("board add", "where to add"));
        ConfigFileRecovery.commandExecutorList.add(new CommandExecutor("board delete", "no board at all"));
        ConfigFileRecovery.commandExecutorList.add(new CommandExecutor("reboot backplane", "impossible"));
        ConfigFileRecovery.commandExecutorList.add(new CommandExecutor("backplane abort", "install first"));
    }


    public static String execute(String command) {
        List<CommandExecutor> matchedList = commandExecutorList.stream().filter(match(command)).collect(Collectors.toList());
        return matchedList.size() == 1 ? matchedList.get(0).getResult() : UNKNOWN_COMMAND;
    }

    private static Predicate<CommandExecutor> match(String command) {
        String[] cmdArr = command.split("\\s");
        return cmdArr.length == 1 ? getCommandExecutorOneCmdPredicate(command) : getCommandExecutorTwoCmdPredicate(cmdArr);
    }

    private static Predicate<CommandExecutor> getCommandExecutorTwoCmdPredicate(String[] cmdArr) {
        Predicate<CommandExecutor> twoCmdPre = tcp -> {
            String[] ceArr = tcp.getCommand().split("\\s");
            return ceArr.length == 2 && ceArr[0].startsWith(cmdArr[0]) && ceArr[1].startsWith(cmdArr[1]);
        };
        return twoCmdPre;
    }

    private static Predicate<CommandExecutor> getCommandExecutorOneCmdPredicate(String command) {
        Predicate<CommandExecutor> oneCmdPre = ocp -> {
            String[] ceArr = ocp.getCommand().split("\\s");
            return ceArr.length == 1 && ocp.getCommand().startsWith(command);
        };
        return oneCmdPre;
    }
}