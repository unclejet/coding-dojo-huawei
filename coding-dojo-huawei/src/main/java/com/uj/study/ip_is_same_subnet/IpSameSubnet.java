package com.uj.study.ip_is_same_subnet;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/1 下午12:03
 * @description：
 */
public class IpSameSubnet {
    static int match(String mask, String ip1, String ip2) {
        return isAllValid(mask, ip1, ip2) ?
                isSameSubnet(mask, ip1, ip2) ? 0 : 2
                : 1;
    }

    private static boolean isSameSubnet(String mask, String ip1, String ip2) {
        String maskBin = combineBin(mask);
        return and(combineBin(ip1), maskBin).equals(and(combineBin(ip2), maskBin));
    }

    private static boolean isAllValid(String mask, String ip1, String ip2) {
        return isValidMask(mask) && isValidIp(ip1) && isValidIp(ip2);
    }

    static boolean isValidIp(String ip) {
        try {
            String[] arr = ip.split("\\.");
            return arr.length == 4 && Stream.of(arr).map(Integer::parseInt).allMatch(n -> n <= 255 && n >= 0);
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isValidMask(String mask) {
        if (isValidIp(mask)) {
            String maskBin = combineBin(mask);
            int last1Idx = maskBin.lastIndexOf("1");
            if (last1Idx == -1)
                return false;
            int first0Idx = maskBin.indexOf("0");
            return first0Idx > last1Idx;
        }
        return false;
    }

    static String and(String ip, String mask) {
        int maskNum = calMaskNumber(mask);
        return ip.substring(0, maskNum).concat("0".repeat(32 - maskNum));
    }

    static int calMaskNumber(String maskBin) {
        return maskBin.lastIndexOf("1") + 1;
    }

    private static String combineBin(String ip) {
        return Arrays.stream(splitIp(ip)).map(IpSameSubnet::dec2Bin).collect(Collectors.joining());
    }

    static String dec2Bin(String decStr) {
        return String.format("%8s", Integer.toBinaryString(Integer.parseInt(decStr))).replaceAll(" ", "0");
    }

    static String[] splitIp(String ip) {
        return ip.split("\\.");
    }
}
