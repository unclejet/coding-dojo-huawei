package com.uj.study.oneway_list_k_node;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/25 下午12:55
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        OnewayListKNodeUserInputReader reader = new OnewayListKNodeUserInputReader(lineReader);
        int length = reader.readLength();
        ListNode ln = OnewayListKNode.buildList(reader.readNodeData(length));
        System.out.println(OnewayListKNode.getKNode(reader.readK(length), ln));
    }
}
