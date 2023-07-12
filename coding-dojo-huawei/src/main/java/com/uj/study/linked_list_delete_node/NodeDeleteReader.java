package com.uj.study.linked_list_delete_node;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/30 下午12:49
 * @description：
 */
public class NodeDeleteReader extends ValidLineReader {
    public NodeDeleteReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        try {
            List<Integer> list = Stream.of(line.split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
            if (list.stream().anyMatch(i -> (i < 0 || i > 10000))) {
                return false;
            }
            return validLogic(list);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validLogic(List<Integer> list) {
        return isValidSize(list) && isDeleteNumContained(list);
    }

    private boolean isValidSize(List<Integer> list) {
        return list.size() == 2 * list.get(0) + 1;
    }

    private boolean isDeleteNumContained(List<Integer> list) {
        int size = list.size();
        List<Integer> integers = list.subList(1, size - 1);
        boolean isDeleteNumContained = integers.contains(list.get(size - 1));
        return isDeleteNumContained;
    }

    public List<Integer> read() {
        String line = readValidLine("please input data(0≤val≤10000) like this: 5 2 3 2 4 3 5 2 1 4 3");
        return Stream.of(line.split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
    }
}
