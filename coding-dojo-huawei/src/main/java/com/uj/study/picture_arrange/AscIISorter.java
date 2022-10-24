package com.uj.study.picture_arrange;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/24 下午12:12
 * @description：
 */
public class AscIISorter {
    public static String sortASCII(String pictures) {
        return pictures.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
