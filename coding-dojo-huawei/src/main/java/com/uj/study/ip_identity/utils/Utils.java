package com.uj.study.ip_identity.utils;

import com.uj.study.ip_identity.model.Address;
import com.uj.study.ip_identity.model.IP;
import com.uj.study.ip_identity.model.Netmask;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/13 上午11:46
 * @description：
 */
public class Utils {
    public static List<Address> transform(Map<String, String> userInputs) {
        return userInputs.entrySet().stream()
                .map(entry->transform(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private static Address transform(String ipStr, String netmaskStr) {
        IP ip = new IP(translate(ipStr));
        Netmask netmask = new Netmask(translate(netmaskStr));
        return new Address(ip, netmask);
    }

    private static int[] translate(String ipStr) {
        String[] arr = StringUtils.replace(ipStr, "", "-1").split("\\.");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) {
                arr[i] = "-1";
            }
        }
        return Arrays.stream(arr)
                .mapToInt(s->Integer.parseInt(s))
                .toArray();
    }
}
