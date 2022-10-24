package com.uj.study.ip_number_transition;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/21 上午11:53
 * @description：
 */
public class Main {

    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        IpUserInputReader ipUserInputReader = new IpUserInputReader(lineReader);
        NumberUserInputReader numberUserInputReader = new NumberUserInputReader(lineReader);
//        System.out.println(NumberIpTransition.ip2Number(ipUserInputReader.readIp()));
        System.out.println(NumberIpTransition.number2Ip(String.valueOf(numberUserInputReader.readNumber())));
    }
}
