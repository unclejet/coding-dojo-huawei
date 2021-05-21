package com.uj.study.ip_identity.model;

import lombok.Getter;

import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/12 上午11:49
 * @description：
 */
@Getter
public class Address {
    public enum Type {
        A, B, C, D, E, W, P, R
    }

    private IP ip;
    private Netmask netmask;

    public Address(IP ip, Netmask netmask) {
        this.ip = ip;
        this.netmask = netmask;
    }

    public IntStream getIpStream() {
        return ip.getStream();
    }

    public IntStream getNetmaskStream() {
        return netmask.getStream();
    }
}
