package com.uj.study.ip_number_transition;

import org.junit.jupiter.api.Test;

import static com.uj.study.ip_number_transition.NumberIpTransition.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.core.Is.is;
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
public class NumberIpTransitionTest {
    @Test
    void splitIpWith4Pieces() {
        assertThat(splitIp("10.0.3.193"), arrayContaining("10", "0", "3", "193"));
    }

    @Test
    void splitBinWith4Pieces() {
        assertThat(splitBin("00001010000000000000001111000001"), arrayContaining("00001010", "00000000", "00000011", "11000001"));
    }

//    private String[] splitBin(String binary) {
//        return Iterables.toArray(Splitter.fixedLength(8).split(binary), String.class);
//    }

    @Test
    void decimal2Binary() {
        assertThat(dec2Bin("10"), is("00001010"));
        assertThat(dec2Bin("193"), is("11000001"));
        assertThat(dec2Bin("0"), is("00000000"));

        assertThat(longDec2Bin("167773121"), is("00001010000000000000001111000001"));
        assertThat(longDec2Bin("4294967295"), is("11111111111111111111111111111111"));
        assertThat(longDec2Bin("0"), is("00000000000000000000000000000000"));
    }

    @Test
    void combineBinary() {
        String[] bins = {"00001010", "00000000", "00000011", "11000001"};
        assertThat(combineBin(bins), is("00001010000000000000001111000001"));
    }

    @Test
    void binary2Decimal() {
        assertThat(bin2Long("00001010000000000000001111000001"), is(167773121L));
        assertThat(bin2IntegerStr("00001010"), is("10"));
        assertThat(bin2IntegerStr("11000001"), is("193"));
    }

    @Test
    void ip2NumberTest() {
        assertThat(ip2Number("10.0.3.193"), is(167773121L));
        assertThat(ip2Number("10.3.3.193"), is(167969729L));
        assertThat(ip2Number("255.255.255.255"), is(4294967295L));
        assertThat(ip2Number("0.0.0.0"), is(0l));
    }

    @Test
    void number2IpTest() {
        assertThat(number2Ip("167773121"), is("10.0.3.193"));
        assertThat(number2Ip("4294967295"), is("255.255.255.255"));
    }

//    private String number2Ip(String number) {
//        return Stream.of(splitBin(longDec2Bin(number))).map(this::bin2IntegerStr).collect(Collectors.joining("."));
//    }
//
//    private long ip2Number(String ip) {
//        return bin2Long(Stream.of(splitIp(ip)).map(this::dec2Bin).collect(Collectors.joining()));
//    }
//
//    private long bin2Long(String bin) {
//        return Long.parseLong(bin, 2);
//    }
//
//    private String bin2IntegerStr(String bin) {
//        return String.valueOf(Integer.parseInt(bin, 2));
//    }
//
//    private String combineBin(String[] bins) {
//        return Stream.of(bins).collect(Collectors.joining());
//    }
//
//    private String dec2Bin(String decStr) {
//        return String.format("%8s", Integer.toBinaryString(Integer.parseInt(decStr))).replaceAll(" ", "0");
//    }
//
//    private String longDec2Bin(String decStr) {
//        return String.format("%32s", Long.toBinaryString(Long.parseLong(decStr))).replaceAll(" ", "0");
//    }
//
//    private String[] splitIp(String ip) {
//        return ip.split("\\.");
//    }
}
