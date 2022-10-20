package com.uj.study.ip_number_transition;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/9/28 下午12:47
 * @description：
 * 描述
 *
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 *
 * 输入描述：
 *
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * 输出描述：
 *
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * 示例1
 * 输入：
 *
 * 10.0.3.193
 * 167969729
 *
 * 输出：
 *
 * 167773121
 * 10.3.3.193
 */
public class NumberIpTransition {

    static String[] splitBin(String binary) {
        return Iterables.toArray(Splitter.fixedLength(8).split(binary), String.class);
    }

    public static String number2Ip(String number) {
        return Stream.of(splitBin(longDec2Bin(number))).map(NumberIpTransition::bin2IntegerStr).collect(Collectors.joining("."));
    }

    public static long ip2Number(String ip) {
        return bin2Long(Stream.of(splitIp(ip)).map(NumberIpTransition::dec2Bin).collect(Collectors.joining()));
    }

    static long bin2Long(String bin) {
        return Long.parseLong(bin, 2);
    }

    static String bin2IntegerStr(String bin) {
        return String.valueOf(Integer.parseInt(bin, 2));
    }

    static String combineBin(String[] bins) {
        return Stream.of(bins).collect(Collectors.joining());
    }

    static String dec2Bin(String decStr) {
        return String.format("%8s", Integer.toBinaryString(Integer.parseInt(decStr))).replaceAll(" ", "0");
    }

    static String longDec2Bin(String decStr) {
        return String.format("%32s", Long.toBinaryString(Long.parseLong(decStr))).replaceAll(" ", "0");
    }

    static String[] splitIp(String ip) {
        return ip.split("\\.");
    }
}
