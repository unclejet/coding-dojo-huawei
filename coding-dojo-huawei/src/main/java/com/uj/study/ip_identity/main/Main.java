package com.uj.study.ip_identity.main;

import com.uj.study.common.input.LineReader;
import com.uj.study.ip_identity.io.IpNetmaskUserInputReader;
import com.uj.study.ip_identity.io.NetworkReporter;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/21 上午11:44
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        IpNetmaskUserInputReader reader = new IpNetmaskUserInputReader(lineReader);
        String report = NetworkReporter.report(reader.readInput());
        System.out.println(report);
    }
}
