package com.uj.study.string_encrypt;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/8 下午12:33
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        StringEncryptUserInputReader reader = new StringEncryptUserInputReader(lineReader);
        reader.readKeyAndEncryptString();
        System.out.println(StringEncrypt.encrypt(reader.getKey(), reader.getEncryptString()));
    }
}
