package com.uj.study.prime.partner;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/6/7 下午12:43
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        PrimeFactorUserInputNumberReader reader = new PrimeFactorUserInputNumberReader(lineReader);
        System.out.println(PrimePartner.bestPartner(reader.readNumbers(4)));
    }
}
