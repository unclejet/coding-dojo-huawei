package com.uj.study.linked_list_delete_node;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/7/7 下午12:58
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        NodeDeleteReader reader = new NodeDeleteReader(lineReader);
        List<Integer> integerList = reader.read();
        NodeDeleter deleter = new NodeDeleter();
        deleter.generate(integerList);
        deleter.deleteNode();
        deleter.print();
    }
}
