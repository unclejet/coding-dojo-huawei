package com.uj.study.ip_is_same_subnet;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/1 下午12:08
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        IpSameSubnetUserInputReader reader = new IpSameSubnetUserInputReader(lineReader);
        List<String> ips = reader.readIps();
        for (int i = 0; i < ips.size(); i += 3) {
            System.out.println(IpSameSubnet.match(ips.get(i), ips.get(i + 1), ips.get(i + 2)));
        }
    }
}
