package com.uj.study.string_encryption_decryption;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/7/25 下午12:37
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        StringEncryptionDecryptionReader reader = new StringEncryptionDecryptionReader(lineReader);
        String[] lines = reader.read2Lines();
        System.out.println(StringEncryptionDecryption.handleEncrypt(lines[0]) + "\n" + StringEncryptionDecryption.handleDecrypt(lines[1]));
    }
}
